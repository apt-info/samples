package com.aptinfo.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.aptinfo.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String text = "Hello Data Binding";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setText(text);
    }
}
