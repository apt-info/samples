package com.aptinfo.databindingrecylcerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.aptinfo.databindingrecylcerview.databinding.ActivityMainBinding;
import com.aptinfo.databindingrecylcerview.view.ListViewAdapter;
import com.aptinfo.databindingrecylcerview.viewModel.ListItemViewModel;
import com.aptinfo.databindingrecylcerview.viewModel.ListViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new ListViewModel());
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, ObservableArrayList<ListItemViewModel> listItemViewModels) {
        ListViewAdapter adapter;
        if (recyclerView.getAdapter() == null) {
            adapter = new ListViewAdapter();
            recyclerView.setAdapter(adapter);
        } else {
            adapter = (ListViewAdapter)recyclerView.getAdapter();
        }
        adapter.updateItems(listItemViewModels);
    }
}
