package com.tinashe.tabssample.fragments;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tinashe.tabssample.R;

/**
 * Created by tinashe on 2015/05/29.
 */
public class PlaceHolderFragment extends BaseFragment {

    private static final String ARG_KEY = "arg:param";

    @Override
    protected int getLayoutResource() {
        return R.layout.layout_blank;
    }

    public static PlaceHolderFragment newInstance(String param){
        PlaceHolderFragment fragment = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KEY, param);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    protected void initialize(View view) {
        super.initialize(view);

        if(getArguments() != null){
            TextView textLabel = (TextView) view.findViewById(R.id.txt_label);
            String param = getArguments().getString(ARG_KEY);
            textLabel.setText(param);
        }
    }
}
