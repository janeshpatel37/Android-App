package com.example.jpatel9576.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class ListFragment extends Fragment{
    private RecyclerView rView;
    private CarsAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment, container, false);
        rView = v.findViewById(R.id.recyclerView);
        rView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }
    private void updateUI() {
        CarsSingleton sSingleton = CarsSingleton.getSongSingleton();
        ArrayList<Cars> cars = sSingleton.getmSongList();
        mAdapter = new CarsAdapter(cars);
        rView.setAdapter(mAdapter);
    }

    private class CarsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitle;
        private TextView mDescript;
        private TextView mPrice;
        private Cars mCars;

        public CarsHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));
            mTitle = itemView.findViewById(R.id.txtListTitle);
            mDescript = itemView.findViewById(R.id.txtListDescription);
            itemView.setOnClickListener(this);
        }
        public void bind(Cars Car) {
            mCars = Car;
            mTitle.setText(mCars.getmTitle());
            mDescript.setText(mCars.getmDescript());
//            mPrice.setText(mCars.getmprice());
        }
        @Override
        public void onClick(View v){
            if (getActivity().findViewById(R.id.displayHolder) == null) {
                Intent i = new Intent(getActivity(), ProtraitActivity.class);
                i.putExtra("TITLE", mCars.getmTitle());
                i.putExtra("PRICE", mCars.getmprice());
                i.putExtra("DESCRIPT", mCars.getmDescript());
                startActivity(i);
            }
            else{
                Fragment frag = DisplayFragment.newInstance(mCars.getmTitle(), mCars.getmprice(), mCars.getmDescript());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.displayHolder, frag).commit();
            }
        }
    }

    private class CarsAdapter extends RecyclerView.Adapter<CarsHolder> {
        private ArrayList<Cars> mCars;

        public CarsAdapter(ArrayList<Cars> cars){
            mCars = cars;
        }
        @Override
        public CarsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CarsHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(CarsHolder holder, int position) {
            Cars car = mCars.get(position);
            holder.setIsRecyclable(false);
            holder.bind(car);
        }
        @Override
        public int getItemCount() {
            return mCars.size();
        }
    }
}
