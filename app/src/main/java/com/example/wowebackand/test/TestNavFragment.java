package com.example.wowebackand.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wowebackand.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class TestNavFragment extends Fragment
{
    public static NavController controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.test_navigation,container,false);

        controller= Navigation.findNavController(getActivity(), R.id.nav_host_test_fragment);

        controller.navigate(R.id.loginFragment);

        return view;
    }
}
