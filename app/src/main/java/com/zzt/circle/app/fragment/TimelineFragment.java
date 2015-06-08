package com.zzt.circle.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.zzt.circle.app.Config;
import com.zzt.circle.app.R;
import com.zzt.circle.app.adapter.TimelineAdapter;
import com.zzt.circle.app.entity.ImageMessage;
import com.zzt.circle.app.net.Timeline;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {

    private ListView lvTimeline;
    private TimelineAdapter timelineAdapter;
    private String account;
    private String token;


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        account = Config.getCachedAccount(getActivity());
        token = Config.getCachedToken(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);
        lvTimeline = (ListView) rootView.findViewById(R.id.lvTimeline);
        timelineAdapter = new TimelineAdapter(getActivity());
        lvTimeline.setAdapter(timelineAdapter);
        loadMessage();
        return rootView;
    }

    private void loadMessage() {
        new Timeline(account, token, 1, 20,
                new Timeline.SuccessCallback() {
                    @Override
                    public void onSuccess(int page, int perpage, List<ImageMessage> timeline) {
                        timelineAdapter.addAll(timeline);
                    }
                },
                new Timeline.FailCallback() {
                    @Override
                    public void onFail() {

                    }
                });
    }


}
