package com.brogrammers.jielian.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentBranchBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BranchFragment extends Fragment {
    private FragmentBranchBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBranchBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        Bundle bundle = new Bundle();

        binding.firstBranchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(Constant.BRANCH_NAME_KEY,binding.firstBranchName.getText().toString());
                bundle.putString(Constant.BRANCH_ADDRESS_KEY,binding.firstBranchAddress.getText().toString());
                navController.navigate(BranchFragmentDirections.actionBranchFragmentToHomeFragment());
            }
        });

        binding.secondBranchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(Constant.BRANCH_NAME_KEY,binding.secondBranchName.getText().toString());
                bundle.putString(Constant.BRANCH_ADDRESS_KEY,binding.secondBranchAddress.getText().toString());
                navController.navigate(BranchFragmentDirections.actionBranchFragmentToHomeFragment());
            }
        });
    }
}