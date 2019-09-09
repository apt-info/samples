package com.aptinfo.databindingrecylcerview.view;

import androidx.recyclerview.widget.DiffUtil;

import com.aptinfo.databindingrecylcerview.viewModel.ListItemViewModel;

import java.util.ArrayList;

public class ListItemDiffCallback extends DiffUtil.Callback {
    private ArrayList<ListItemViewModel> oldListItemViewModels;
    private ArrayList<ListItemViewModel> newListItemViewModels;

    public ListItemDiffCallback(
            ArrayList<ListItemViewModel> oldListItemViewModels,
            ArrayList<ListItemViewModel> newListItemViewModels) {
        this.oldListItemViewModels = oldListItemViewModels;
        this.newListItemViewModels = newListItemViewModels;
    }

    @Override
    public int getOldListSize() {
        return oldListItemViewModels.size();
    }

    @Override
    public int getNewListSize() {
        return newListItemViewModels.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        ListItemViewModel oldItem = oldListItemViewModels.get(oldItemPosition);
        ListItemViewModel newItem = newListItemViewModels.get(newItemPosition);

        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        ListItemViewModel oldItem = oldListItemViewModels.get(oldItemPosition);
        ListItemViewModel newItem = newListItemViewModels.get(newItemPosition);

        if (!oldItem.getTitle().equals(newItem.getTitle()))
            return false;
        if (!oldItem.getContent().equals(newItem.getContent()))
            return false;

        return true;
    }
}
