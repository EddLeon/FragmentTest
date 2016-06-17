package com.testing.radika.fragtests;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by greenapsis on 13/06/16.
 */
public class TestFragment extends Fragment {
    View rootView;
    Button btn;
    OnArticleSelectedListener mListener;
    int value=0;

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
        Log.d("TestFrag", "si existo");

        //Keeping reference to view
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        btn = (Button)rootView.findViewById(R.id.frag2btn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onArticleSelected(value++);
                Log.e("Frag"," evento click");
            }
        });
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnArticleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    // Container Activity must implement this interface
    public interface OnArticleSelectedListener {
        public void onArticleSelected(int id);
    }

}
