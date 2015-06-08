package com.zzt.circle.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.zzt.circle.app.Config;
import com.zzt.circle.app.R;
import com.zzt.circle.app.adapter.ContactAdapter;

/**
 * Created by zzt on 15-6-6.
 */
public class ContactFragment extends Fragment {
    private ListView lvContact;
    private ContactAdapter adapter;
    private String token;
    private String account;

    public ContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        account = Config.getCachedAccount(getActivity());
        token = Config.getCachedToken(getActivity());
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        lvContact = (ListView) rootView.findViewById(R.id.lvContact);
        adapter = new ContactAdapter(getActivity());
        lvContact.setAdapter(adapter);
        loadContact();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void loadContact() {

    }
}
