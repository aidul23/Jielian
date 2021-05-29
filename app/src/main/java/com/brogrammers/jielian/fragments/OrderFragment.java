package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.brogrammers.jielian.adapter.OrderAdapter;
import com.brogrammers.jielian.databinding.FragmentOrderBinding;
import com.brogrammers.jielian.model.Order;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.orderHistoryRecyclerview.setHasFixedSize(true);
        binding.orderHistoryRecyclerview.setAdapter(
                new OrderAdapter(getDummyOrder())
        );
    }

    private List<Order> getDummyOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        orders.add(new Order("#102391", "12th April, 12.30", 200));
        return orders;
    }
}