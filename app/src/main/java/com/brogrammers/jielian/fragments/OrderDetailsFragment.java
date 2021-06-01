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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.brogrammers.jielian.adapter.CartAdapter;
import com.brogrammers.jielian.clicklisteners.CartItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentOrderDetailsBinding;
import com.brogrammers.jielian.model.OrderItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsFragment extends Fragment{

    private FragmentOrderDetailsBinding binding;

    public OrderDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        binding = FragmentOrderDetailsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.orderItemRecyclerview.setAdapter(
                new CartAdapter(getOrders(), Constant.LAYOUT_TYPE_ORDER_DETAIL)
        );
    }

    private List<OrderItem> getOrders() {

        List<OrderItem> orderItems = new ArrayList<>();

        orderItems.add(new OrderItem("Fried Burger", 200, 2));
        orderItems.add(new OrderItem("Fried Burger", 200, 2));
        orderItems.add(new OrderItem("Fried Burger", 200, 2));
        orderItems.add(new OrderItem("Fried Burger", 200, 2));
        orderItems.add(new OrderItem("Fried Burger", 200, 2));
        orderItems.add(new OrderItem("Fried Burger", 200, 2));

        return orderItems;

    }
}