package com.bcit.mvvmcats;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

class CatViewModelFactory implements ViewModelProvider.Factory{

    private final CatRepository catRepository;
    private final Context context;

    public CatViewModelFactory(Context context, CatRepository catRepository){
        this.context = context;
        this.catRepository = catRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CatViewModel.class)) {
            return (T) new CatViewModel(context, catRepository);

        }else {
            return null;
        }
    }
}

public class CatViewModel extends ViewModel {

    CatRepository catRepository;
    private MutableLiveData<Bitmap> mutableLiveDataImage;
    private MutableLiveData<String> mutableLiveDataFact;

    Context context;

    public CatViewModel(Context context, CatRepository catRepository){
        this.context = context;
        this.catRepository = catRepository;
    }

    public MutableLiveData<Bitmap> getCatBitmap(){
        if (mutableLiveDataImage == null){
            mutableLiveDataImage = new MutableLiveData<>();
        }
        return mutableLiveDataImage;
    }

    public MutableLiveData<String> getCatFact(){
        if (mutableLiveDataFact == null){
            mutableLiveDataFact = new MutableLiveData<>();
        }
        return mutableLiveDataFact;
    }

    public void getRandomCatFromRepo(){
        Cat cat = catRepository.getRandomCat(context);
        mutableLiveDataImage.setValue(cat.getBitmap());
        mutableLiveDataFact.setValue(cat.getFact());
    }

}
