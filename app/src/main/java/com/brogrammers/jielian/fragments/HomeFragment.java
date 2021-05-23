package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.brogrammers.jielian.adapter.CommonAdapter;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentHomeBinding;
import com.brogrammers.jielian.model.CategoryItem;
import com.denzcoskun.imageslider.models.SlideModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://image.shutterstock.com/image-photo/various-asian-meals-on-rustic-260nw-1125066479.jpg"));
        slideModels.add(new SlideModel("https://image.shutterstock.com/image-photo/various-asian-meals-on-rustic-260nw-1075946798.jpg"));
        slideModels.add(new SlideModel("https://image.shutterstock.com/image-photo/italian-food-background-pasta-meat-260nw-678135781.jpg"));
        binding.homeImageSlider.setImageList(slideModels, true);

        binding.categoryRecyclerView.setLayoutManager(
                new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        binding.categoryRecyclerView.setHasFixedSize(true);

        binding.categoryRecyclerView.setAdapter(
                new CommonAdapter(getDummyList(), Constant.LAYOUT_TYPE_CATEGORY)
        );

    }

    private List<CategoryItem> getDummyList() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Biriyani", "", "", ""));
        categoryItems.add(new CategoryItem("Pizza", "", "", ""));
        categoryItems.add(new CategoryItem("Burger", "", "", ""));
        categoryItems.add(new CategoryItem("Fast Foods", "", "", ""));
        categoryItems.add(new CategoryItem("Indian", "", "", ""));
        return categoryItems;
    }
}