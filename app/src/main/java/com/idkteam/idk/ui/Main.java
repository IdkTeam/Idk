package com.idkteam.idk.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.idkteam.idk.R;
import com.idkteam.idk.adapter.MainAdapter;
import com.idkteam.idk.model.DemoData;
import com.idkteam.idk.model.PostItem;

import java.util.ArrayList;

/**
 * The main activity class, here the user sees all the posts
 *
 * @author Danny
 */
public class Main extends AppCompatActivity implements MainAdapter.ItemClickCallBack {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    private RecyclerView recView;
    private MainAdapter adapter;
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_intro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Idk");

        //Add RecycleView
        listData = (ArrayList) DemoData.getListData();
        recView = (RecyclerView)findViewById(R.id.main_recycleView);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(DemoData.getListData(), this);
        recView.setAdapter(adapter);
        adapter.setItemCliclCallBack(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_profile:                              // settings button clicked

                Intent i = new Intent(this, UserProfile.class);
                startActivity(i);
                return true;

            case R.id.menu_add_btn:                             // add button clicked

                addOptionsShow();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * The method creates a popup menu from which the user selects a post type: Image/Text
     */
    public void addOptionsShow() {
        final DialogIconItem[] items = {
                new DialogIconItem("New image post", android.R.drawable.ic_menu_camera),
                new DialogIconItem("New text post", android.R.drawable.ic_menu_edit),
        };

        ListAdapter adapter = new ArrayAdapter<DialogIconItem>(
                this,
                android.R.layout.select_dialog_item,
                android.R.id.text1,
                items) {
            public View getView(int position, View convertView, ViewGroup parent) {
                //Use super class to create the View
                View v = super.getView(position, convertView, parent);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);

                //Put the image on the TextView
                tv.setCompoundDrawablesWithIntrinsicBounds(items[position].icon, 0, 0, 0);

                //Add margin between image and text (support various screen densities)
                int dp5 = (int) (5 * getResources().getDisplayMetrics().density + 0.5f);
                tv.setCompoundDrawablePadding(dp5);

                return v;
            }
        };


        new AlertDialog.Builder(this)
                .setTitle("Post type:")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        //...
                    }
                }).show();
    }

    @Override
    public void onItemClick(int p) {

        PostItem item = (PostItem)listData.get(p);
        Intent i = new Intent(this, PostDetail.class);
        Bundle extras = new Bundle();

        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());
        i.putExtra(BUNDLE_EXTRAS, extras);
        startActivity(i);

    }

    @Override
    public void onSecondaryIconClick(int p) {

        PostItem item = (PostItem) listData.get(p);
        //update our data
        if (item.isFavorite()){
            item.setFavorite(false);
        } else {
            item.setFavorite(true);
        }
        //pass new data to adapter and update
        //TODO should not pass data like that if handling data from data base!!!
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();

    }
}
