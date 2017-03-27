package com.example.hppc.mood.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.example.hppc.mood.LoginActivity;
import com.example.hppc.mood.R;
import com.example.hppc.mood.storage.PreferenceManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Activity_Tabs extends AppCompatActivity{

private Toolbar toolbar;
private TabLayout tabLayout;
private ViewPager viewPager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.menu_changecity){
            PreferenceManager.getInstance().setLatLong("","");
            PreferenceManager.getInstance().setCityName("");
            startActivity(new Intent(Activity_Tabs.this, LocationActivity.class));
            finish();
            return true;
        }else if(id == R.id.menu_signout) {
            performLogout();
            return true;
        }else if(id == R.id.menu_deleteacc) {
            // // TODO: delete account code
            performLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
private void performLogout(){
    FirebaseAuth.getInstance().signOut();
    startActivity(new Intent(Activity_Tabs.this, LoginActivity.class));
    // open login activty here
    finish();
    PreferenceManager.getInstance().clearSession();
}
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        }

private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(Fragment_NearBy.getInstance(Fragment_NearBy.ChildFragments.RESTAURENTS), "Restaurants");
        adapter.addFragment(Fragment_NearBy.getInstance(Fragment_NearBy.ChildFragments.SHOPS), "Shops");
        adapter.addFragment(Fragment_NearBy.getInstance(Fragment_NearBy.ChildFragments.ARTS_ENTERTAINMENT),"Arts & Entertainment");
        adapter.addFragment(Fragment_NearBy.getInstance(Fragment_NearBy.ChildFragments.EVENTS), "Events");
        adapter.addFragment(Fragment_NearBy.getInstance(Fragment_NearBy.ChildFragments.PLACES), "Places");
        viewPager.setAdapter(adapter);
        }

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
}