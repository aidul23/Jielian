package com.brogrammers.jielian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brogrammers.jielian.databinding.FragmentFoodlistBinding;
import com.brogrammers.jielian.databinding.FragmentHomeBinding;
import com.brogrammers.jielian.fragments.CategoryFragmentAdapter;

import org.jetbrains.annotations.NotNull;

public class FoodListFragment extends Fragment {
    private FragmentFoodlistBinding binding;
    private CategoryFragmentAdapter categoryFragmentAdapter;
    ViewPager2 viewPager2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFoodlistBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = view.findViewById(R.id.viewPager2);
        viewPager2.setAdapter(categoryFragmentAdapter);
    }
}