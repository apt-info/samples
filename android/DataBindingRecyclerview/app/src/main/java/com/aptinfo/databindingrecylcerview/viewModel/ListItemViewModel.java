package com.aptinfo.databindingrecylcerview.viewModel;

public class ListItemViewModel {
    private String title;
    private String content;

    public ListItemViewModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
