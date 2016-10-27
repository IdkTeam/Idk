package com.idkteam.idk.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * The class represents the image that will appear in the gallery when uploading images
 * @author Danny
 */
public class GalleryUploadItem {
    private Bitmap bitmap;

    public GalleryUploadItem(){}

    public GalleryUploadItem(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
