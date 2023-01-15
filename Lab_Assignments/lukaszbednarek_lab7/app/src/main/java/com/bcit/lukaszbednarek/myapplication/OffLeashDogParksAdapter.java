package com.bcit.lukaszbednarek.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class OffLeashDogParksAdapter extends RecyclerView.Adapter<OffLeashDogParksAdapter.ViewHolder> {

    private final List<OffLeashParks.Record> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewPark;
        private final TextView textViewArea;
        private final TextView textViewAddress;

        public ViewHolder(View view) {
            super(view);

            textViewPark = view.findViewById(R.id.textView_dogPark_park);
            textViewArea = view.findViewById(R.id.textView_dogPark_area);
            textViewAddress = view.findViewById(R.id.textView_dogPark_address);
        }

        public TextView getTextViewPark() {
            return textViewPark;
        }

        public TextView getTextViewArea() {
            return textViewArea;
        }

        public TextView getTextViewAddress() {
            return textViewAddress;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public OffLeashDogParksAdapter(List<OffLeashParks.Record> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_dog_park, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewPark().setText(localDataSet.get(position).fields.name);
        viewHolder.getTextViewArea().setText(localDataSet.get(position).fields.geo_local_area);
        viewHolder.getTextViewAddress().setText(localDataSet.get(position).fields.address);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}