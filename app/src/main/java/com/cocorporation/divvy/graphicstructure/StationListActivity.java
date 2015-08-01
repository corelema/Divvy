package com.cocorporation.divvy.graphicstructure;

import android.support.v4.app.Fragment;

public class StationListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new StationListFragment();
    }
}
