package com.aptinfo.databindingedittext;

import androidx.databinding.ObservableField;

public class MainViewModel {
    private ObservableField<String> text;

    public MainViewModel() {
        this.text = new ObservableField<>("text binding");
    }

    public ObservableField<String> getText() {
        return text;
    }
}
