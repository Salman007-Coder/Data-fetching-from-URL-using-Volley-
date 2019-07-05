package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class itemAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<item> items;
    AppController appController=AppController.getmInstance();

     public itemAdapter(Activity activity,List<item>items) {
         this.activity=activity;
         this.items=items;
     }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom_layout,null);
        }

            TextView description=convertView.findViewById(R.id.description);
            TextView id=convertView.findViewById(R.id.ID);
            TextView name=convertView.findViewById(R.id.name);
            TextView punishment=convertView.findViewById(R.id.punishment);
            TextView reward=convertView.findViewById(R.id.reward);
            item item1=items.get(position);
            description.setText(item1.getDescription());
            id.setText(item1.getId());
            name.setText(item1.getName());
            punishment.setText(item1.getPunishment());
            reward.setText(item1.getReward());
        return convertView;
    }
}
