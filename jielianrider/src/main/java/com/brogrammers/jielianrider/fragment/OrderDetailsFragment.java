package com.brogrammers.jielianrider.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielianrider.R;
import com.brogrammers.jielianrider.adapter.OrderStatusAdapter;
import com.brogrammers.jielianrider.clicklistener.StatusClickListener;
import com.brogrammers.jielianrider.databinding.FragmentOrderDetailsBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.jetbrains.annotations.NotNull;

public class OrderDetailsFragment extends Fragment {

    private BottomSheetBehavior bottomSheetBehavior;
    private FragmentOrderDetailsBinding binding;

    public OrderDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrderDetailsBinding.inflate(getLayoutInflater());

        bottomSheetBehavior = BottomSheetBehavior.from(binding.getRoot().findViewById(R.id.bottom_sheet));
        bottomSheetBehavior.setPeekHeight(200);
        bottomSheetBehavior.setHideable(false);
       // bottomSheetBehavior.addBottomSheetCallback(callback);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OrderStatusAdapter adapter = new OrderStatusAdapter();

        RecyclerView orderStatusRecyclerView = binding.getRoot().findViewById(R.id.order_status_recyclerview);

        orderStatusRecyclerView.setAdapter(adapter);

        adapter.setStatusClickListener(new StatusClickListener() {
            @Override
            public void onChecked(int position) {

            }
        });
    }
}