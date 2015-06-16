package com.tinashe.tabssample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


/**
 * Created by tinashe on 2015/04/06.
 *
 * This is a BaseActivity that all Activities can extend.
 * It makes it easy to implement common tasks through out all activities
 * eg (setting up the toolbar and switching between fragments)
 * common methods can be added inhere
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResource();

    private Toolbar mToolBar;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(getLayoutResource());

        mToolBar = (Toolbar) findViewById(R.id.app_action_bar);
        if (mToolBar != null) {

            setSupportActionBar(mToolBar);

            mTabLayout = (TabLayout) findViewById(R.id.tabs);

            View appBarLayout = findViewById(R.id.app_bar_layout);
            if (appBarLayout != null) {
                ViewCompat.setElevation(appBarLayout, getResources().getDimension(R.dimen.toolbar_elevation));
                ViewCompat.setTranslationZ(appBarLayout, getResources().getDimension(R.dimen.toolbar_elevation));
            }


        }
    }


    public Toolbar getToolBar() {
        return mToolBar;
    }

    public TabLayout getTabLayout() {
        return mTabLayout;
    }

    /**
     * Child activities can use this method when switching between fragments
     *
     * @param fragment
     * @param containerResId
     */
    protected void switchToFragment(Fragment fragment, int containerResId) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(containerResId, fragment, fragment.getClass().getName());
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }


}
