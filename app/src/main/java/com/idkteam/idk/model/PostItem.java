package com.idkteam.idk.model;

/**
 * Java representation of out data to be displayed in the RecycleView (Demo only!)
 */
public class PostItem {

    private String title;
    private String subTitle;
    private int imageResId;
    private boolean favorite = false;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
