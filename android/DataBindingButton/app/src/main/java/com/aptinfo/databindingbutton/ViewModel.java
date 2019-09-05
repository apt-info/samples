package com.aptinfo.databindingbutton;

import androidx.databinding.ObservableField;

public class ViewModel {
    private int count = 0;
    private ObservableField<String> buttonText = new ObservableField<>();

    public ViewModel() {
        updateButtonText();
    }

    public ObservableField<String> getButtonText() {
        return buttonText;
    }

    public void updateButtonText() {
        buttonText.set(count + " clicked");
    }

    public void onButtonClick() {
        ++count;
        updateButtonText();
    }
}
