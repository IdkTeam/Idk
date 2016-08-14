package com.idkteam.idk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private ItemCliclCallBack itemCliclCallBack;

    public interface ItemCliclCallBack{
        void onItemClick(int p);
        void onSecondaryIconClick(int p);

    }

    public void setItemCliclCallBack(final ItemCliclCallBack itemCliclCallBack){
        this.itemCliclCallBack = itemCliclCallBack;
    }

    public MainAdapter(List<PostItem> listData, Context c) {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.post_item, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(MainHolder holder, int position) {

        PostItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        if (item.isFavorite()){
            holder.secondaryIcon.setImageResource(R.drawable.ic_action_add);
        } else {
            holder.secondaryIcon.setImageResource(R.drawable.ic_action_add);
        }
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
        private ImageView secondaryIcon;
        private View container;

        public MainHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.username_post_lbl);
            subTitle = (TextView) itemView.findViewById(R.id.lbl_item_sub_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.im_item_icon);
            secondaryIcon = (ImageView) itemView.findViewById(R.id.im_item_icon_secondary);
            container = itemView.findViewById(R.id.cont_post_root);
            secondaryIcon.setOnClickListener(this);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.cont_post_root){

                itemCliclCallBack.onItemClick(getAdapterPosition());
            }
            else{

                itemCliclCallBack.onSecondaryIconClick(getAdapterPosition());
            }

        }
    }
}
