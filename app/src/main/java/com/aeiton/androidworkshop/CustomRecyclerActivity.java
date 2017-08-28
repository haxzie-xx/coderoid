package com.aeiton.androidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class CustomRecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerAdapter mRecyclerAdapter;
    private ArrayList<RecyclerModel> itemList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Custom Recycler");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerAdapter = new RecyclerAdapter(itemList,CustomRecyclerActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CustomRecyclerActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mRecyclerAdapter);

        itemList.add(new RecyclerModel(R.drawable.img_sp_1,"Samsung Galaxy J7 Prime","Rs. 16400"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_2,"Samsung Galaxy On7","Rs. 8990"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_3,"Samsung Galaxy On7 pro","Rs. 9900"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_4,"Samsung Galaxy On8","Rs. 14900"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_5,"Samsung Galaxy J7 2016","Rs. 13990"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_6,"Samsung Galaxy J5","Rs. 11990"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_7,"Samsung Galaxy J3","Rs. 9439"));
        itemList.add(new RecyclerModel(R.drawable.img_sp_8,"Samsung Galaxy J2","Rs. 6400"));

        mRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }else
        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }



}
