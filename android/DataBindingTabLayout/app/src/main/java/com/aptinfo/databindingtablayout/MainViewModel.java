package com.aptinfo.databindingtablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainViewModel {

    private FragmentStatePagerAdapter viewPagerAdapter;
    private TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener;
    private TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener;

    public MainViewModel(FragmentManager fm,
                         TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener,
                         TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener) {
        this.viewPagerOnTabSelectedListener = viewPagerOnTabSelectedListener;
        this.tabLayoutOnPageChangeListener = tabLayoutOnPageChangeListener;

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Page1Fragment());
        fragments.add(new Page2Fragment());
        viewPagerAdapter = new ViewPagerAdapter(fm, fragments);
    }

    public FragmentStatePagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public TabLayout.ViewPagerOnTabSelectedListener getViewPagerOnTabSelectedListener() {
        return viewPagerOnTabSelectedListener;
    }

    public TabLayout.TabLayoutOnPageChangeListener getTabLayoutOnPageChangeListener() {
        return tabLayoutOnPageChangeListener;
    }
}
