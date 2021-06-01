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

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.adapter.CartAdapter;
import com.brogrammers.jielian.clicklisteners.CartItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentCartBinding;
import com.brogrammers.jielian.itemdecoration.CustomItemDecoration;
import com.brogrammers.jielian.model.OrderItem;
import com.brogrammers.jielian.utility.StringUtility;
import com.brogrammers.jielian.viewmodel.MainActivityViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";

    private FragmentCartBinding binding;
    private MainActivityViewModel model;
    private CartAdapter adapter;
    private NavController navController;

    public CartFragment() {
        // Required empty public constructor
    }

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
        binding = FragmentCartBinding.inflate(getLayoutInflater());

        binding.orderItemRecyclerview.addItemDecoration(
                new CustomItemDecoration(requireActivity(), R.drawable.item_divider, 8)
        );

        model.getOrderItemLiveData().observe(getViewLifecycleOwner(), new Observer<List<OrderItem>>() {
            @Override
            public void onChanged(List<OrderItem> orderItems) {
                if (orderItems != null && orderItems.size() > 0) {

                    adapter = new CartAdapter(orderItems, Constant.LAYOUT_TYPE_ORDER_DETAIL);

                    binding.orderItemRecyclerview.setHasFixedSize(true);

                    binding.orderItemRecyclerview.setAdapter(adapter);

                    adapter.setCartItemClickListener(new CartItemClickListener() {
                        @Override
                        public void onClick(OrderItem orderItem) {
                            model.getOrderItemMutableLiveData().setValue(orderItem);
                        }
                    });

                }
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        model.getTotalCost().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer != null) {
                    binding.subtotal.setText(StringUtility.getFormattedString(integer));
                    binding.totalCost.setText(StringUtility.getFormattedString(integer + 40));
                }
            }
        });

        binding.placceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(CartFragmentDirections.actionCartFragmentToMapFragment());
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
    }
}