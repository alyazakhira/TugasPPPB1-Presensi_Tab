package com.example.presensi_manual;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFrag extends Fragment {

    public LoginFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        Button login = rootView.findViewById(R.id.btn_submit_login);
        login.setOnClickListener(view -> {
            Intent it1 = new Intent(rootView.getContext(),MainActivity2.class);
            startActivity(it1);
        });
        return rootView;
    }

}