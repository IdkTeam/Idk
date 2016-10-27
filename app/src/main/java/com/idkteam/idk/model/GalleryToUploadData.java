package com.idkteam.idk.model;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.idkteam.idk.ui.GalleryUploadItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 22/10/2016.
 */
public class GalleryToUploadData {

    private static List<GalleryUploadItem> data = new ArrayList<>();

    public static void addTo_GalleyToUpload(ImageView imageView){
        GalleryUploadItem item = new GalleryUploadItem();
      //  item.setImageView(imageView);
        data.add(item);
    }

    public static List<GalleryUploadItem> getGalleryToUpload(){
       return data;
    }
}
