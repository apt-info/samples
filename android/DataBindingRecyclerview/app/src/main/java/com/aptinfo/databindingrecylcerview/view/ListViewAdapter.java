package com.aptinfo.databindingrecylcerview.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aptinfo.databindingrecylcerview.R;
import com.aptinfo.databindingrecylcerview.databinding.ListItemBinding;
import com.aptinfo.databindingrecylcerview.viewModel.ListItemViewModel;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<BindingViewHolder<ListItemBinding>> {
    private ArrayList<ListItemViewModel> listItemViewModels = new ArrayList<>();

    public void updateItems(ArrayList<ListItemViewModel> listItemViewModels) {
        ListItemDiffCallback callback = new ListItemDiffCallback(this.listItemViewModels, listItemViewModels);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        this.listItemViewModels.clear();
        this.listItemViewModels.addAll(listItemViewModels);
        result.dispatchUpdatesTo(this);
    }

    @Override
    public BindingViewHolder<ListItemBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BindingViewHolder<>(inflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder<ListItemBinding> holder, int position) {
        holder.binding().setViewModel(listItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemViewModels.size();
    }
}
