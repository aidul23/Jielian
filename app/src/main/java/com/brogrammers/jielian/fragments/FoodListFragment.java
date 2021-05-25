package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.brogrammers.jielian.adapter.CommonAdapter;
import com.brogrammers.jielian.clicklisteners.OnItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentFoodlistBinding;
import com.brogrammers.jielian.model.CategoryItem;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment implements OnItemClickListener {


    private MainActivityViewModel model;

    private FragmentFoodlistBinding binding;
    private CommonAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
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

        adapter = new CommonAdapter(getDummyItemList2(), Constant.LAYOUT_TYPE_ITEM_LARGE);
        binding.foodListRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    private List<CategoryItem> getDummyItemList2() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Biriyani", "", "Served with sauteed vegetables and onion rings and vegetable sauce, chicken broast, chicken masala, chicken shami kabab", 120));
        categoryItems.add(new CategoryItem("Pizza", "", "Served with sauteed vegetables and onion rings", 90));
        categoryItems.add(new CategoryItem("Burger", "", "Served with sauteed vegetables and onion rings", 500));
        categoryItems.add(new CategoryItem("Fast Foods", "", "Served with sauteed vegetables and onion rings", 900));
        categoryItems.add(new CategoryItem("Indian", "", "Served with sauteed vegetables and onion rings", 871));
        return categoryItems;
    }

    @Override
    public void onClick(CategoryItem categoryItem, String type) {
        model.getCategoryItemMutableLiveData().postValue(categoryItem);
    }
}