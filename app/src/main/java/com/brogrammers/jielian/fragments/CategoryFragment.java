package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.brogrammers.jielian.adapter.CategoryFragmentAdapter;
import com.brogrammers.jielian.databinding.FragmentCategoryBinding;
import com.brogrammers.jielian.utility.StringUtility;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;
    private NavController navController;
    private static final String[] titles = {"Burger", "Biriyani", "Indian"};
    private MainActivityViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        model = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager2.setAdapter(new CategoryFragmentAdapter(this));

        navController = Navigation.findNavController(view);

        new TabLayoutMediator(binding.restaurantTabLayout, binding.viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                tab.setText(titles[position]);
            }
        }).attach();

        binding.viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(CategoryFragmentDirections.actionCategoryFragmentToCartFragment());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        model.getTotalOrderQuantity().observe(getViewLifecycleOwner(), orderTotalQuantityObserver);
        model.getTotalCost().observe(getViewLifecycleOwner(), orderTotalCostObserver);
    }

    private final Observer<Integer> orderTotalQuantityObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {
            if (integer != null && integer > 0) {
                binding.orderItemCount.setText(String.valueOf(integer));
            }
        }
    };

    private final Observer<Integer> orderTotalCostObserver = new Observer<Integer>() {
        @Override
        public void onChanged(Integer integer) {
            if (integer != null) {
                binding.orderTotalCost.setText(StringUtility.getFormattedString(integer));
            }

        }
    };

}