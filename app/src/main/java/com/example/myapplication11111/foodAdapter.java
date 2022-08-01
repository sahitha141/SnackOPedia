package com.example.myapplication11111;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.List;
import java.util.zip.Inflater;

public class foodAdapter implements ListAdapter {
    private Activity context;
    private int resource;
    private List<GalleryModelClass> listGalleryImage;
    public foodAdapter(@NonNull food_display context, @LayoutRes int resource,@NonNull List<GalleryModelClass> object){
        super(context,resource,object);
        this.context=context;
        this.resource=resource;
        listGalleryImage=object;
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @NonNull
    @Override
    public View getView(final int position,@NonNull View convertView,@NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View view = Inflater.inflate(resource, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.lunch);

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}