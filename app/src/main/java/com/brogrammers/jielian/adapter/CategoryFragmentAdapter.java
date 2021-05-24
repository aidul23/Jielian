package com.brogrammers.jielian.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.brogrammers.jielian.fragments.FoodListFragment;

import org.jetbrains.annotations.NotNull;

public class CategoryFragmentAdapter extends FragmentStateAdapter {

    public CategoryFragmentAdapter(@NonNull @NotNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        return new FoodListFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
