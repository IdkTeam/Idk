package com.idkteam.idk.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.idkteam.idk.R;

/**
 * Created by Danny on 15/10/2016.
 */
public class TakePhoto extends AppCompatActivity {

    private ImageView imageHolder;
    private final int requestCode = 20;
    private Bitmap bitmap;
    private Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        imageHolder = (ImageView) findViewById(R.id.captured_photo);

        // used to launch the camera image capture.
        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(photoCaptureIntent, requestCode);
        /* The result returned from this method will be access in the override method of the Activity class
         called onActivityResult(int requestCode, int resultCode, Intent data)*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //A bitmap image is obtained from the Intent data and it is set to the ImageView
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
            bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }

    public void onClick_continuePhoto(View view){
        returnIntent = getIntent();
        Bundle extras = new Bundle();
        extras.putParcelable("imagebitmap", bitmap);
        returnIntent.putExtras(extras);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
