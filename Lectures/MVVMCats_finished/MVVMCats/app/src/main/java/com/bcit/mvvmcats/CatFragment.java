package com.bcit.mvvmcats;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class CatFragment extends Fragment {

    public CatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.imageView_cat);
        TextView textView = view.findViewById(R.id.textView_cat_fact);
        Button button = view.findViewById(R.id.button_cat);

        CatRepository catRepository = new CatRepository();
        //CatViewModel catViewModel = new CatViewModel(catRepository);
        CatViewModelFactory catViewModelFactory = new CatViewModelFactory(getActivity().getApplicationContext(), catRepository);
        CatViewModel catViewModel = new ViewModelProvider(this, catViewModelFactory).get(CatViewModel.class);

        Observer<Bitmap> bitmapObserver = new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        };
        catViewModel.getCatBitmap().observe(getViewLifecycleOwner(), bitmapObserver);

        Observer<String> factObserver = new Observer<String>() {
            @Override
            public void onChanged(String fact) {
                textView.setText(fact);
            }
        };
        catViewModel.getCatFact().observe(getViewLifecycleOwner(), factObserver);


        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                catViewModel.getRandomCatFromRepo();
            }
        });

    }

}