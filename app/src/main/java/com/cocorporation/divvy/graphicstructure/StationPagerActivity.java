package com.cocorporation.divvy.graphicstructure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.cocorporation.divvy.R;
import com.cocorporation.divvy.data.Station;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Corentin on 5/2/2015.
 */
public class StationPagerActivity extends FragmentActivity {
    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        final ArrayList<Station> stations = StationLab.get(this).getStations();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public int getCount() {
                return stations.size();
            }
            @Override
            public Fragment getItem(int pos) {
                UUID crimeId =  stations.get(pos).getId();
                return StationFragment.newInstance(crimeId);
            }
        });

        UUID crimeId = (UUID)getIntent().getSerializableExtra(StationFragment.EXTRA_LEVEL_ID);
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
