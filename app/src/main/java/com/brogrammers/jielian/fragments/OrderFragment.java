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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.adapter.OrderAdapter;
import com.brogrammers.jielian.clicklisteners.OrderItemClickListener;
import com.brogrammers.jielian.databinding.FragmentOrderBinding;
import com.brogrammers.jielian.model.Order;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    private FragmentOrderBinding binding;

    private NavController navController;

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
        binding = FragmentOrderBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        OrderAdapter orderAdapter = new OrderAdapter(getDummyOrder());

        binding.orderHistoryRecyclerview.setHasFixedSize(true);
        binding.orderHistoryRecyclerview.setAdapter(
                orderAdapter
        );

        orderAdapter.setOrderItemClickListener(new OrderItemClickListener() {
            @Override
            public void onClick() {
                navController.navigate(OrderFragmentDirections.actionOrderFragmentToOrderDetailsFragment());
            }
        });
    }


    private List<Order> getDummyOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Delivered", 200));

        return orders;
    }
}