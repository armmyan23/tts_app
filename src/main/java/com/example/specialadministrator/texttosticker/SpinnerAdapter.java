package com.example.specialadministrator.texttosticker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by User on 24.02.2018.
 */

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private  String[] items;

    public SpinnerAdapter(Context context,String[] items){
        this.context = context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_spinner,viewGroup,false);
        }
        TextView text = view.findViewById(R.id.font);
        text.setText(items[i]);

        return view;
    }
}
