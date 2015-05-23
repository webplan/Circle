package com.zzt.circle.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zzt.circle.app.R;
import com.zzt.circle.app.entity.ImageMessage;

import java.util.List;

/**
 * Created by zzt on 15-5-18.
 */
public class TimelineAdapter extends BaseAdapter {
    private List<ImageMessage> msgLists;
    private Context context;
    private LinearLayout layout;

    public TimelineAdapter(List<ImageMessage> msgLists, Context context) {
        this.msgLists = msgLists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return msgLists.size();
    }

    @Override
    public Object getItem(int position) {
        return msgLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        layout = (LinearLayout) inflater.inflate(R.layout.cell_message,null);
        TextView tvPostTime = (TextView) layout.findViewById(R.id.tvPostTime);
        ImageView ivAvatar = (ImageView) layout.findViewById(R.id.ivAvatar);
        ImageView ivImage = (ImageView) layout.findViewById(R.id.ivImage);
//        ivAvatar.
        return null;
    }
}
