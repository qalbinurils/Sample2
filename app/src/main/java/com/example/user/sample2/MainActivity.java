package com.example.user.sample2;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<MineralWater> mMineralWater;
    private MineralWaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMineralWater = new ArrayList<>();

        mAdapter = new MineralWaterAdapter(this, mMineralWater);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        String[] mwaterList = getResources().getStringArray(R.array.mw_names);
        String[] mwaterInfo = getResources().getStringArray(R.array.mw_info);

        TypedArray mwImageResources =
                getResources().obtainTypedArray(R.array.mw_images);

        mMineralWater.clear();

        for(int i=0;i<mwaterList.length;i++){
            mMineralWater.add(new MineralWater(mwaterList[i],mwaterInfo[i],mwImageResources.getResourceId(i,0)));
        }

        mAdapter.notifyDataSetChanged();
        mwImageResources.recycle();
    }

}
