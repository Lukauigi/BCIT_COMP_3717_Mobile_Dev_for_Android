package com.bcit.lukaszbednarek.lab5.lecture6;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartoonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartoonFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Cartoon mParam1;

    public CartoonFragment() {
        // Required empty public constructor
    }

    public static CartoonFragment newInstance(Cartoon param1) {
        CartoonFragment fragment = new CartoonFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Cartoon) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartoon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.imageView_cartoon);
        imageView.setImageResource(mParam1.getResourceId());

        TextView textView = view.findViewById(R.id.textView_cartoon_species);
        textView.setText(mParam1.getSpecies());
    }
}