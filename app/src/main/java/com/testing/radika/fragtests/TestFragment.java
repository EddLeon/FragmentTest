package com.testing.radika.fragtests;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by greenapsis on 13/06/16.
 */
public class TestFragment extends Fragment {
    View rootView;

    public TestFragment() {
        Log.d("TestFrag","si me cree");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("TestFrag","si existo");

        //Keeping reference to view
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
