package com.example.antonurivskiy.myswipelistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MyActivity extends Activity {
    ArrayList<MySomeItem> itemsList;
    SwipeListView slv;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        slv = (SwipeListView)findViewById(R.id.list_view);

        slv.setSwipeListViewListener(new BaseSwipeListViewListener(){
            @Override
            public void onClickFrontView(int position) {
                super.onClickFrontView(position);
                if(itemsList.get(position).getType() == 1)
                    itemsList.get(position).setType(0);
                else
                    itemsList.get(position).setType(1);

                adapter.notifyDataSetChanged();
            }
        });

        init();
    }

    public void init(){

        itemsList = new ArrayList<MySomeItem>();
        MySomeItem item = new MySomeItem();
        item.setTitle("Title 1");
        item.setText("Some text 1");
        itemsList.add(item);

        item = new MySomeItem();
        item.setTitle("Title 2");
        item.setText("Some text 2");
        itemsList.add(item);

        item = new MySomeItem();
        item.setTitle("Title 3");
        item.setText("Some text 3");
        itemsList.add(item);

        item = new MySomeItem();
        item.setTitle("Title 4");
        item.setText("Some text 4");
        itemsList.add(item);

        adapter = new MyAdapter(this, itemsList);

        slv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
