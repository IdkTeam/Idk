package com.idkteam.idk.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.idkteam.idk.R;
import com.idkteam.idk.ui.GalleryUploadItem;

import java.util.List;

/**
 * Created by Danny on 22/10/2016.
 */
public class GalleryToUploadAdapter extends RecyclerView.Adapter<GalleryToUploadAdapter.GalleryToUploadHolder> {

    private List<GalleryUploadItem> listData;
    private LayoutInflater inflater;

    public GalleryToUploadAdapter(List<GalleryUploadItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public GalleryToUploadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.gallery_upload_item, parent, false);
        return new GalleryToUploadHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryToUploadHolder holder, int position) {
        GalleryUploadItem item = listData.get(position);
        holder.imgView.setImageBitmap(item.getBitmap());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, GalleryUploadItem data) {
        listData.add(position, data);
        //notifyItemInserted(position);
    }

    class GalleryToUploadHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;

        public GalleryToUploadHolder(View itemView) {
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.img_photo_to_upload);
        }
    }
}

