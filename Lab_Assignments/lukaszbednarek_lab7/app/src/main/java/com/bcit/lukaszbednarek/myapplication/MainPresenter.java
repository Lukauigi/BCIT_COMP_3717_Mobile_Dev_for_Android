package com.bcit.lukaszbednarek.myapplication;

import java.util.List;

public class MainPresenter {

    public interface View {
        void onUpdateRecycler(List<OffLeashParks.Record> areas);
    }

    private final MainModel mainModel;
    private final View view;

    public MainPresenter(final View view, final MainModel mainModel) {
        this.mainModel = mainModel;
        this.view = view;
    }

    public void getDataFromModel() {
        List<OffLeashParks.Record> areas = this.mainModel.getData();
        view.onUpdateRecycler(areas);
    }

}
