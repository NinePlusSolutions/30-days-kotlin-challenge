package com.midterm.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.midterm.myapplication.TabRecycleView;
import com.midterm.myapplication.TabPermission;
import com.midterm.myapplication.TabService;


public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position)
        {
            case 0:
                return new TabRecycleView();
            case 1:
                return new TabPermission();
            case 2:
                return new TabService();
            case 3:
                return new TabPermission();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
