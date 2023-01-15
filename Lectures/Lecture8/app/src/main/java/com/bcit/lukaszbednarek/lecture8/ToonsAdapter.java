package com.bcit.lukaszbednarek.lecture8;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ToonsAdapter extends RecyclerView.Adapter<ToonsAdapter.ViewHolder> {

    private Toon[] localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * This template comes with a TextView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewGender;
        private final TextView textViewOccupation;
        private final ImageView toonImageView;

        public ViewHolder(View view) {
            super(view);

            textViewName = view.findViewById(R.id.textView_toon_name);
            textViewGender = view.findViewById(R.id.textView_toon_gender);
            textViewOccupation = view.findViewById(R.id.textView_toon_occupation);
            toonImageView = view.findViewById(R.id.imageView_toon);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewGender() { return textViewGender; }
        public TextView getTextViewOccupation() { return textViewOccupation; }
        public ImageView getToonImageView() { return toonImageView; }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView.
     */
    public ToonsAdapter(Toon[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_toon, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewName().setText(localDataSet[position].getFirstName());
        viewHolder.getTextViewGender().setText(localDataSet[position].getGender());
        viewHolder.getTextViewOccupation().setText(localDataSet[position].getOccupation());

        ImageView imageView = viewHolder.getToonImageView(); // gets image from toon imageview
        // gets pic url from data passed from adapter
        Future<Bitmap> imageRequest = createHttpRequestForImage(localDataSet[position].getPictureUrl());

        Bitmap bitmap = null;

        try {
            bitmap = imageRequest.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // display image if there, or put this stock image
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Drawable placeholder = imageView.getContext().getDrawable(R.drawable.ic_launcher_background);
            imageView.setImageDrawable(placeholder);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }

    public Future<Bitmap> createHttpRequestForImage(String url) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        HttpHandler<Bitmap> httpHandler = new HttpHandler<>(url, true);
        return executorService.submit(httpHandler);
    }
}