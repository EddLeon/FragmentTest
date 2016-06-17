package com.testing.radika.fragtests;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TestFragment.OnArticleSelectedListener{

    MainActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container,testFragment);
        fragmentTransaction.commit();*/


    }

    @Override
    protected void onStart() {

        //calling fixed (in xml) framents method
        fragment = (MainActivityFragment) getFragmentManager().findFragmentById(R.id.fragment);
        fragment.fromActivity(2);

        TestFragment testFragment = new TestFragment();

        //Compact way
        FragmentTransaction fragTran = getFragmentManager().beginTransaction().add(R.id.container, testFragment);
        fragTran.commit();
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback from TestFragment via implemented method
     * @param id
     */
    @Override
    public void onArticleSelected(int id) {
        Toast.makeText(this, Integer.toString(id), Toast.LENGTH_SHORT).show();
    }

   /* TestFragment.OnArticleSelectedListener tFragListener = new TestFragment.OnArticleSelectedListener() {
        @Override
        public void onArticleSelected(int id) {
            Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
        }
    };*/

}
