package com.bcit.lukaszbednarek.lab5.lukaszbednarek_midterm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    private String[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView age;
        private final TextView food;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.textView_inventory_name);
            age = view.findViewById(R.id.textView_inventory_age);
            food = view.findViewById(R.id.textView_inventory_food);
        }

        public TextView getNameTextView() {
            return name;
        }
        public void setNameTextView(final String name) {
            itemView.findViewById(R.id.textView_inventory_name);
        }

        public TextView getAgeTextView() {
            return age;
        }
        public void setAgeTextView(final int age) {
            itemView.findViewById(R.id.textView_inventory_age);
        }

        public TextView getFoodTextView() {
            return food;
        }
        public void setFoodTextView(final String food) {
            itemView.findViewById(R.id.textView_inventory_food);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public itemAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_inventory, viewGroup, false); //error here should be expected, this is a template

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getNameTextView().setText(localDataSet[position]);
        viewHolder.getAgeTextView().setText(localDataSet[position]);
        viewHolder.getFoodTextView().setText(localDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}