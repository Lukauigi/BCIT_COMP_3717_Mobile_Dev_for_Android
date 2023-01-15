package com.bcit.lukaszbednarek.lab5.lukaszbednarek_lab6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private Person[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView location;

        public ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.textView_item_name);
            location = view.findViewById(R.id.textView_item_location);
        }

        public TextView getName() {
            return name;
        }
        public TextView getLocation() { return location; }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public PersonAdapter(Person[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_person, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getName().setText(String.format("%s%s%s%s", " ",
                localDataSet[position].getFirstName(), " ", localDataSet[position].getLastName()));
        viewHolder.getLocation().setText(localDataSet[position].getLocation());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}