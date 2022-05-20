package com.example.NationInfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import NationInfo.R;

public class NationAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Nation> nationList;

    public NationAdapter(Context context, int layout, ArrayList<Nation> nationList) {
        this.context = context;
        this.layout = layout;
        this.nationList = nationList;
    }

    @Override
    public int getCount() {
        return nationList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Bitmap image = null;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();

            //ánh xạ view
            holder.txtName = convertView.findViewById(R.id.row_text);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//       gán giá trị
        Nation nation = nationList.get(position);

        //Set giá trị trong list cho view
        holder.txtName.setText(nation.getName());


        return convertView;
    }

    private class ViewHolder {
        TextView txtName;
    }


}