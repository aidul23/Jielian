package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.brogrammers.jielian.adapter.CartAdapter;
import com.brogrammers.jielian.databinding.FragmentCartBinding;
import com.brogrammers.jielian.model.OrderItem;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private MainActivityViewModel model;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        model.getOrderItemLiveData().observe(this, new Observer<List<OrderItem>>() {
            @Override
            public void onChanged(List<OrderItem> orderItems) {
                if (orderItems != null && orderItems.size() > 0) {
                    binding.orderItemRecyclerview.setHasFixedSize(true);
                    binding.orderItemRecyclerview.setAdapter(
                            new CartAdapter(orderItems)
                    );
                }
            }
        });
    }
}