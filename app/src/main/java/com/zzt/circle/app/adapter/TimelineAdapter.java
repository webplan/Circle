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
import com.zzt.circle.app.tools.RemoteImageHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzt on 15-5-18.
 */
public class TimelineAdapter extends BaseAdapter {
    private List<ImageMessage> msgLists = new ArrayList<ImageMessage>();
    private Context context;
    private LinearLayout layout;
    private RemoteImageHelper remoteImageHelper = new RemoteImageHelper();

    public TimelineAdapter(Context context) {
        this.context = context;
    }

    public void addAll(List<ImageMessage> data) {
        msgLists.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        msgLists.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return msgLists.size();
    }

    @Override
    public ImageMessage getItem(int position) {
        return msgLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        int parentWidth = parent.getWidth();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_message, null);
            holder = new ViewHolder();
            holder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
            holder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            holder.tvNickname = (TextView) convertView.findViewById(R.id.tvNickname);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);

            convertView.setTag(holder);
        }

        holder = (ViewHolder) convertView.getTag();
        ViewGroup.LayoutParams lp = holder.ivImage.getLayoutParams();
        lp.width = parentWidth;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        holder.ivImage.setLayoutParams(lp);

        holder.ivImage.setMaxWidth(parentWidth);
        holder.ivImage.setMaxHeight(parentWidth * 5);

        ImageMessage msg = getItem(position);

        holder.tvNickname.setText(msg.getNickname());
        holder.tvDescription.setText(msg.getTextDescription());

        remoteImageHelper.loadImage(holder.ivImage, msg.getPhotoURL(), true);
        remoteImageHelper.loadImage(holder.ivAvatar, msg.getAvatarURL(), true);

//        holder.ivImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(context, LargeImageActivity.class);
//                i.pu
//            }
//        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView ivAvatar;
        ImageView ivImage;
        TextView tvNickname;
        TextView tvDescription;
    }
}
