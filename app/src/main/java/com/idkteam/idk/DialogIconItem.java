package com.idkteam.idk;

public class DialogIconItem {

    public final String text;
    public final int icon;
    public DialogIconItem(String text, Integer icon) {
        this.text = text;
        this.icon = icon;
    }
    @Override
    public String toString() {
        return text;
    }
}
