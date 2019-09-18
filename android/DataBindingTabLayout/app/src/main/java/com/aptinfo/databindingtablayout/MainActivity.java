package com.aptinfo.databindingtablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.aptinfo.databindingtablayout.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new MainViewModel(
                getSupportFragmentManager(),
                new TabLayout.ViewPagerOnTabSelectedListener((ViewPager)findViewById(R.id.viewPager)),
                new TabLayout.TabLayoutOnPageChangeListener((TabLayout)findViewById(R.id.tabLayout)));
        binding.setViewModel(mainViewModel);
    }
}
