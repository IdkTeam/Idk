package com.idkteam.idk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.idkteam.idk.R;
import com.idkteam.idk.model.PostItem;

import java.util.ArrayList;
import java.util.List;

/**
 * The adapter for the RecycleView
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<PostItem> listData;
    private LayoutInflater inflater;
    private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);

    }

    public void setItemClickCallBack(final ItemClickCallBack itemClickCallBack){
        this.itemClickCallBack = itemClickCallBack;
    }

    public MainAdapter(List<PostItem> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.card_post, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {

        PostItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        /*if (item.isFavorite()){
            holder.secondaryIcon.setImageResource(R.drawable.ic_action_add);
        } else {
            holder.secondaryIcon.setImageResource(R.drawable.ic_action_add);
        }*/
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setListData(ArrayList<PostItem> exerciseList) {
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    class MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView subTitle;
        private ImageView thumbnail;
        //private ImageView secondaryIcon;
        private View container;
        private Button load;

        public MainHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.lbl_post_text);
            subTitle = (TextView) itemView.findViewById(R.id.lbl_post_sub_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.im_post_icon);
            //secondaryIcon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
            container = itemView.findViewById(R.id.cont_post_root);
            //secondaryIcon.setOnClickListener(this);
            //container.setOnClickListener(this);
            load = (Button)itemView.findViewById(R.id.btn_card_load);
            load.setOnClickListener(this);
            thumbnail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.btn_card_load || v.getId() == R.id.im_post_icon){

                itemClickCallBack.onItemClick(getAdapterPosition());
            }
            else{

               // itemCliclCallBack.onSecondaryIconClick(getAdapterPosition());
            }

        }
    }
}
