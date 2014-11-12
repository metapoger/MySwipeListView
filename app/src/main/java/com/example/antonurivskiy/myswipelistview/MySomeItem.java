package com.example.antonurivskiy.myswipelistview;

/**
 * Created by antonurivskiy on 12/11/14.
 */
public class MySomeItem {

    public static final int EXTENDED_ITEM_TYPE = 1;
    private String title, text;
    private int type;


    public MySomeItem() {
        title = "";
        text = "";
        type = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
