package com.bcit.lukaszbednarek.lab5.redo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class OceanFragment extends Fragment {

    private static final String ARG_PARAM1 = "com.bcit.lukaszbednarek.lab05.redo";

    private Ocean mParam1;

    public OceanFragment() {
        // Required empty public constructor
    }

    public static OceanFragment newInstance(Ocean param1) {
        OceanFragment fragment = new OceanFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Ocean) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ocean, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.textView_ocean_name);
        String name = mParam1.getName().toLowerCase();
        String capitalName = name.substring(0, 1).toUpperCase() + name.substring(1);
        textView.setText(capitalName);

        ImageView imageView = view.findViewById(R.id.imageView_ocean);
        imageView.setImageResource(mParam1.getId());
    }
}