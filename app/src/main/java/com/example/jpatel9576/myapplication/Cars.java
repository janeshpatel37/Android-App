package com.example.jpatel9576.myapplication;

/**
 * Created by Jpatel9576 on 11/19/2018.
 */

public class Cars {
    private String mTitle;
    private String mDescript;
    private String mprice;


    public Cars (String title, String description, String price) {
        this.mTitle = title;
        this.mDescript = description;
        this.mprice = price;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescript() {
        return mDescript;
    }

    public void setmDescript(String mDescript) {
        this.mDescript = mDescript;
    }

    public String getmprice() {
        return mprice;
    }

    public void setmprice(String mprice) {
        this.mprice = mprice;
    }
}
