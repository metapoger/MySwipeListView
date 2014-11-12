package com.example.antonurivskiy.myswipelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by antonurivskiy on 12/11/14.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<MySomeItem> items;

    public MyAdapter(Context context, ArrayList list) {
        mContext = context;
        items = list;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return (items.get(position).getType() == MySomeItem.EXTENDED_ITEM_TYPE)? 1 : 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(type == 1)
                convertView = inflater.inflate(R.layout.extended_item_layout, parent, false);
            else
                convertView = inflater.inflate(R.layout.item_layout, parent, false);

        }

        MySomeItem item = items.get(position);

        TextView titleTV = (TextView)convertView.findViewById(R.id.item_title);
        Button backButton = (Button)convertView.findViewById(R.id.item_back_button);

        titleTV.setText(item.getTitle());
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "back button " + (position+1) + " pressed", Toast.LENGTH_SHORT).show();
            }
        });

        if(type == 1) {
            TextView textTV = (TextView) convertView.findViewById(R.id.item_text);
            textTV.setText(item.getText());
            Button frontButton = (Button) convertView.findViewById(R.id.item_front_button);

            frontButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "front button "+(position+1)+" pressed", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}
