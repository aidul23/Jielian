package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.brogrammers.jielian.MyPageTransformer.MyPageTransformer;
import com.brogrammers.jielian.adapter.BannerAdapter;
import com.brogrammers.jielian.adapter.CommonAdapter;
import com.brogrammers.jielian.clicklisteners.OnItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentHomeBinding;
import com.brogrammers.jielian.model.CategoryItem;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;
import com.denzcoskun.imageslider.models.SlideModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnItemClickListener {

    private FragmentHomeBinding binding;
    private MainActivityViewModel model;

    private CommonAdapter adapter;

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.bannerViewpager.setPageTransformer(new MyPageTransformer());

        binding.bannerViewpager.setAdapter(new BannerAdapter());

        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CommonAdapter(getDummyList(), Constant.LAYOUT_TYPE_CATEGORY);

        binding.categoryRecyclerView.setLayoutManager(manager);
        binding.categoryRecyclerView.setHasFixedSize(true);
        binding.categoryRecyclerView.setAdapter(
                adapter
        );

        adapter.setOnItemClickListener(this);

        manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CommonAdapter(getDummyItemList(), Constant.LAYOUT_TYPE_ITEM);
        adapter.setOnItemClickListener(this);

        binding.itemRecyclerView1.setLayoutManager(manager);
        binding.itemRecyclerView1.setHasFixedSize(true);
        binding.itemRecyclerView1.setAdapter(
                adapter
        );

        manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter = new CommonAdapter(getDummyItemList(), Constant.LAYOUT_TYPE_ITEM);
        adapter.setOnItemClickListener(this);

        binding.itemRecyclerView2.setLayoutManager(manager);
        binding.itemRecyclerView2.setHasFixedSize(true);
        binding.itemRecyclerView2.setAdapter(
                adapter
        );

    }

    private List<CategoryItem> getDummyList() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Biriyani", "", "", 0));
        categoryItems.add(new CategoryItem("Pizza", "", "", 0));
        categoryItems.add(new CategoryItem("Burger", "", "", 0));
        categoryItems.add(new CategoryItem("Fast Foods", "", "", 0));
        categoryItems.add(new CategoryItem("Indian", "", "", 0));
        return categoryItems;
    }

    private List<CategoryItem> getDummyItemList() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Biriyani", "", "", 120));
        categoryItems.add(new CategoryItem("Pizza", "", "", 90));
        categoryItems.add(new CategoryItem("Burger", "", "", 500));
        categoryItems.add(new CategoryItem("Fast Foods", "", "", 900));
        categoryItems.add(new CategoryItem("Indian", "", "", 871));
        return categoryItems;
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
        if (type.equals(Constant.LAYOUT_TYPE_CATEGORY)) {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToCategoryFragment());
        } else {
            model.getCategoryItemMutableLiveData().postValue(categoryItem);
        }
    }
}