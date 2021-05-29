package com.brogrammers.jielian.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentProfileBinding;

import org.jetbrains.annotations.NotNull;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private NavController navController;
    private FragmentProfileBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        binding.userAddressLayout.setOnClickListener(this);
        binding.userNameLayout.setOnClickListener(this);
        binding.userEmailLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();

        switch (v.getId()) {
            case R.id.user_name_layout:
                bundle.putInt(Constant.USER_EDIT_SELECTION, Constant.USER_NAME_VALUE);
                navController.navigate(R.id.action_profileFragment_to_editUserProfileFragment, bundle);
                break;
            case R.id.user_email_layout:
                bundle.putInt(Constant.USER_EDIT_SELECTION, Constant.USER_EMAIL_VALUE);
                navController.navigate(R.id.action_profileFragment_to_editUserProfileFragment, bundle);
                break;
            case R.id.user_address_layout:
                bundle.putInt(Constant.USER_EDIT_SELECTION, Constant.USER_ADDRESS_VALUE);
                navController.navigate(R.id.action_profileFragment_to_editUserProfileFragment, bundle);
                break;
        }
    }
}