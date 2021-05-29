package com.brogrammers.jielian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.databinding.FragmentEditUserProfileBinding;

import org.jetbrains.annotations.NotNull;

public class EditUserProfileFragment extends Fragment {

    private FragmentEditUserProfileBinding binding;

    private int selection;

    public EditUserProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selection = getArguments().getInt(Constant.USER_EDIT_SELECTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEditUserProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch (selection) {
            case 0:
                binding.firstTextInputLayout.setHint("First Name");
                binding.secondTextInputLayout.setHint("Last Name");
                binding.secondTextInputLayout.setVisibility(View.VISIBLE);
                break;

            case 1:
                binding.firstTextInputLayout.setHint("Email");
                binding.secondTextInputLayout.setVisibility(View.GONE);
                break;

            case 2:
                binding.firstTextInputLayout.setHint("Address");
                binding.secondTextInputLayout.setVisibility(View.GONE);
                break;
        }
    }
}