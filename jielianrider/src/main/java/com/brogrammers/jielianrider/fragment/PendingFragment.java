package com.brogrammers.jielianrider.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.brogrammers.jielianrider.R;
import com.brogrammers.jielianrider.adapter.OrderAdapter;
import com.brogrammers.jielianrider.clicklistener.OrderItemClickListener;
import com.brogrammers.jielianrider.databinding.FragmentPendingBinding;
import com.brogrammers.jielianrider.model.Order;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class PendingFragment extends Fragment implements OrderItemClickListener {

    private FragmentPendingBinding binding;

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPendingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        OrderAdapter orderAdapter = new OrderAdapter(getDummyOrder());

        binding.pendingRecyclerview.setHasFixedSize(true);
        binding.pendingRecyclerview.setAdapter(
                orderAdapter
        );
        orderAdapter.setOrderItemClickListener(this);
    }

    private List<Order> getDummyOrder() {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));
        orders.add(new Order("#102391", "12th April, 12.30", getResources().getString(R.string.pickupAddress), getResources().getString(R.string.destinationAddress), "Pending", 200));

        return orders;
    }

    @Override
    public void onClick(Order order) {
        Bundle bundle = new Bundle();
        bundle.putString("", order.getOrderId());
        navController.navigate(R.id.action_pendingFragment_to_orderDetailsFragment, bundle);
    }
}