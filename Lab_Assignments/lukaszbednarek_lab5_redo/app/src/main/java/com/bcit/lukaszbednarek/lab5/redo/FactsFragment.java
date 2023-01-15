package com.bcit.lukaszbednarek.lab5.redo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FactsFragment extends Fragment {

    private static final String ARG_PARAM1 = "com.bcit.lukaszbednarek.lab05.redo";

    private ArrayList<String> mParam1;
    private Button randomFact;
    private TextView factInfo;

    public FactsFragment() {
        // Required empty public constructor
    }

    public static FactsFragment newInstance(ArrayList<String> param1) {
        FactsFragment fragment = new FactsFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getStringArrayList(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_facts, container, false);
        randomFact = view.findViewById(R.id.button_fragment_facts_random);
        factInfo = view.findViewById(R.id.textView_fragment_facts_info);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // mParam1 = FactsFragment.newInstance()

        randomFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomNumberGenerator = new Random();

                int randomFact = randomNumberGenerator.nextInt(mParam1.size());
                factInfo.setText(mParam1.get(randomFact));
            }
        });
    }

    public void changeFacts(ArrayList<String> facts) {
        mParam1 = facts;
    }
}