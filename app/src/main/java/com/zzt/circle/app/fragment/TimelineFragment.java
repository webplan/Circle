package com.zzt.circle.app.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.zzt.circle.app.R;
import com.zzt.circle.app.adapter.TimelineAdapter;
import com.zzt.circle.app.entity.ImageMessage;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {

    private ListView lvTimeline;
    private TimelineAdapter timelineAdapter;


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timeline,container,false);
        lvTimeline = (ListView) rootView.findViewById(R.id.lvTimeline);
        timelineAdapter = new TimelineAdapter(new ArrayList<ImageMessage>(), getActivity());
        return rootView;
    }


}
