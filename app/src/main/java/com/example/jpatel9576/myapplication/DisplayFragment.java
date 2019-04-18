package com.example.jpatel9576.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jpatel9576 on 11/19/2018.
 */

public class DisplayFragment extends Fragment{
    private TextView songTitle;
    private TextView price;
    private TextView description;

    public static DisplayFragment newInstance(String songTitle, String artist, String description) {

        Bundle args = new Bundle();
        args.putString("SONG_TITLE", songTitle);
        args.putString("PRICE", artist);
        args.putString("DESCRIPT", description);

        DisplayFragment frag = new DisplayFragment();
        frag.setArguments(args);
        return frag;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.display_fragment, container, false);

        songTitle = v.findViewById(R.id.txtSongTitle);
        description = v.findViewById(R.id.txtDescription);
        price = v.findViewById(R.id.price);
        songTitle.setText(getArguments().getString("SONG_TITLE"));
        description.setText(getArguments().getString("DESCRIPT"));
        price.setText(getArguments().getString("PRICE"));
        return v;
    }
}
