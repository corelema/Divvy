package com.cocorporation.divvy.graphicstructure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cocorporation.divvy.R;
import com.cocorporation.divvy.data.Station;

import java.util.UUID;

/**
 * Created by Corentin on 5/2/2015.
 */
public class StationFragment extends Fragment {
    public static final String EXTRA_LEVEL_ID = "androidman.LEVEL_ID";

    Station mStation;

    /*Layout elements*/
    TextView mTitleField;
    TextView mNumbDocksAvail;
    TextView mNumbBikesAvail;
    TextView mNumbTotalDock;

    public static StationFragment newInstance(UUID levelId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_LEVEL_ID, levelId);

        StationFragment fragment = new StationFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID levelId = (UUID)getArguments().getSerializable(EXTRA_LEVEL_ID);
        mStation = StationLab.get(getActivity()).getStation(levelId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_station, parent, false);

        mTitleField = (TextView)v.findViewById(R.id.station_title);
        mTitleField.setText(mStation.getStationName());

        mNumbDocksAvail = (TextView)v.findViewById(R.id.number_docks_available);
        mNumbDocksAvail.setText(String.valueOf(mStation.getAvailableDocks()));

        mNumbBikesAvail = (TextView)v.findViewById(R.id.number_bikes_available);
        mNumbBikesAvail.setText(String.valueOf(mStation.getAvailableBikes()));

        mNumbTotalDock = (TextView)v.findViewById(R.id.number_total_docks);
        mNumbTotalDock.setText(String.valueOf(mStation.getTotalDocks()));


        return v;
    }
}
