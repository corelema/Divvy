package com.cocorporation.divvy.graphicstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cocorporation.divvy.R;
import com.cocorporation.divvy.data.Station;

import java.util.ArrayList;

/**
 * Created by Corentin on 7/25/2015.
 */
public class StationListFragment extends ListFragment {
    private ArrayList<Station> mStations;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.menu_station_title);
        mStations = StationLab.get(getActivity()).getStations();
        StationAdapter adapter = new StationAdapter(mStations);
        setListAdapter(adapter);
        StationLab.setAdapter(adapter);
        StationLab.refreshList();
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        // get the Crime from the adapter
        Station s = ((StationAdapter)getListAdapter()).getItem(position);
        // start an instance of CrimePagerActivity
        Intent i = new Intent(getActivity(), StationPagerActivity.class);
        i.putExtra(StationFragment.EXTRA_LEVEL_ID, s.getId());
        startActivityForResult(i, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ((StationAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class StationAdapter extends ArrayAdapter<Station> {
        public StationAdapter(ArrayList<Station> levels) {
            super(getActivity(), android.R.layout.simple_list_item_1, levels);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // if we weren't given a view, inflate one
            if (null == convertView) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_station, null);
            }

            // configure the view for this Level
            Station s = getItem(position);

            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.station_list_item_titleTextView);
            titleTextView.setText(s.getStationName());
            /*TextView dateTextView =
                    (TextView)convertView.findViewById(R.id.station_list_item_dateTextView);
            dateTextView.setText(s.getLastCommunicationTime().toString());*/
            //CheckBox PassedCheckBox =
                    //(CheckBox)convertView.findViewById(R.id.station_list_item_passedCheckBox);
            //PassedCheckBox.setChecked(s.get());

            return convertView;
        }
    }
}
