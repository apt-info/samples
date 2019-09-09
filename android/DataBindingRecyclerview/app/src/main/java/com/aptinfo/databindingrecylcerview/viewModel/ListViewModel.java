package com.aptinfo.databindingrecylcerview.viewModel;

import androidx.databinding.ObservableArrayList;

public class ListViewModel {
    private int count = 0;
    private ObservableArrayList<ListItemViewModel> listItemViewModels;

    public ListViewModel() {
        listItemViewModels = new ObservableArrayList<>();
    }

    public ObservableArrayList<ListItemViewModel> getListItemViewModels() {
        return this.listItemViewModels;
    }

    public void addListItem() {
        ++count;
        listItemViewModels.add(new ListItemViewModel("title " + count, "content " + count));
    }
}
