package com.bcit.lukaszbednarek.lab5.lukaszbednarek_midterm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;

public class PreviewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "com.bcit.lukaszbednarek.lab5.lukaszbednarek_midterm";

    // TODO: Rename and change types of parameters
    private Hippo mParam1;

    public PreviewFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PreviewFragment newInstance(Hippo param1) {
        PreviewFragment fragment = new PreviewFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Hippo) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preview, container, false);
    }
}