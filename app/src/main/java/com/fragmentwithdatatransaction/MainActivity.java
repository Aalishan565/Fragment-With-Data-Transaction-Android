package com.fragmentwithdatatransaction;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentItemList fragment = (FragmentItemList) FragmentItemList.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_fragment_container, fragment, "List_Fragment");
        fragmentTransaction.commit();

    }

    public void detailFragment(Bundle b) {
        FragmentDetailVIew fragment = (FragmentDetailVIew) FragmentDetailVIew.newInstance();
        fragment.setArguments(b);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragment_container, fragment, "Detail_Fragment");
       // fragmentTransaction.setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out);
        fragmentTransaction.addToBackStack("List_Fragment");
        fragmentTransaction.commit();
    }
}
