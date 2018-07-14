package com.example.ptwitchapon.burgest.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptwitchapon.burgest.R;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class fm_myorder_driver extends Fragment {


    public static fm_myorder_driver newInstance() {
        return new fm_myorder_driver();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }




}