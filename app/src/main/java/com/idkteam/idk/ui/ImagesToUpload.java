package com.idkteam.idk.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.idkteam.idk.R;
import com.idkteam.idk.adapter.GalleryToUploadAdapter;
import com.idkteam.idk.model.GalleryToUploadData;

import java.util.ArrayList;
import java.util.List;

public class ImagesToUpload extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GalleryToUploadAdapter adapter;
    private GalleryToUploadData galleryToUploadData;
    private List<GalleryUploadItem> imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_to_upload);

        recyclerView = (RecyclerView) findViewById(R.id.recView_images_to_upload);

        //The LayoutManager decides the way the recycle view will look, in this case, a linear horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //Create new list of items that will appear in the recycleView
        imagesList = new ArrayList<>();

        adapter = new GalleryToUploadAdapter(imagesList, getApplication());
        recyclerView.setAdapter(adapter);

        //Going to take the initial image
        Intent goToCamera = new Intent(this, TakePhoto.class);
        startActivityForResult(goToCamera, 1);
    }

    public void addAnotherImage_btnClicked(View view){
        Intent goToCamera = new Intent(this, TakePhoto.class);
        startActivityForResult(goToCamera, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
               // Bundle extras = getIntent().getExtras();
                //Bitmap bmp = extras.getParcelable("imagebitmap");
                Bitmap bmp = (Bitmap) data.getExtras().get("imagebitmap");
                imagesList.add(new GalleryUploadItem(bmp));
                adapter.notifyDataSetChanged();

            }
          else if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
