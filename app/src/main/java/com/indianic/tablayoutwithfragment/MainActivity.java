package com.indianic.tablayoutwithfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout,new MainFragment()).commit();
    }

    /**
     * Hide current fragment and add new fragment to container
     *
     * @param currentFragment
     * @param newFragment
     */
    public void addFragment(final Fragment currentFragment, final Fragment newFragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .add(R.id.main_framelayout, newFragment, newFragment.getClass().getSimpleName())
                .hide(currentFragment)
                .addToBackStack(currentFragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }



}

