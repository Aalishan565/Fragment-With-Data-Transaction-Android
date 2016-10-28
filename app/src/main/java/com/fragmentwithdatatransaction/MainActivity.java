package com.fragmentwithdatatransaction;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        FragmentItemList fragment = (FragmentItemList) FragmentItemList.newInstance();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame_fragment_container, fragment,"List_Fragment");
        ft.commit();

    }

    public void detailFragment(Bundle b) {
        FragmentDetailVIew fragment = (FragmentDetailVIew) FragmentDetailVIew.newInstance();
        fragment.setArguments(b);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_fragment_container, fragment,"List_Fragment");
        transaction.addToBackStack("List_Fragment");
        transaction.commit();
    }
}
