package com.example.jpatel9576.myapplication;

import java.util.ArrayList;

/**
 * Created by Jpatel9576 on 11/19/2018.
 */

public class CarsSingleton {
    private ArrayList<Cars> mSongList;
    private static CarsSingleton mSongSingleton;

    public static CarsSingleton getSongSingleton() {

        if (mSongSingleton == null){
            mSongSingleton = new CarsSingleton();
        }
        return mSongSingleton;
    }

    private CarsSingleton() {
        mSongList = new ArrayList<>();

        Cars car1 = new Cars("2019 RANGE ROVER", "The ultimate Range Rover", "$112,000");
        Cars car2 = new Cars("2019 RANGE ROVER SPORT", "The most agile and dynamic Land Rover", "$79,000");
        Cars car3 = new Cars("2019 RANGE ROVER VELAR", "The avant-grade Range Rover", "$63,700");
        Cars car4 = new Cars("2019 RANGE ROVER EVOQUE", "Distinctive and individual, a true Range Rover in compact form", "$$49,900");
        Cars car5 = new Cars("2019 RANGE ROVER DISCOVERY", "The most versatile suv", "66,300");
        Cars car6 = new Cars("2019 RANGE ROVER DISCOVERY SPORT", "The adventorous and versatile compact suv", "43,500");
        mSongList.add(car1);
        mSongList.add(car2);
        mSongList.add(car3);
        mSongList.add(car4);
        mSongList.add(car5);
        mSongList.add(car6);
    }

    public ArrayList<Cars> getmSongList() {
        return mSongList;
    }
}
