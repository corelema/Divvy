package com.cocorporation.divvy.graphicstructure;

import android.content.Context;

import com.cocorporation.divvy.data.Station;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Corentin on 5/3/2015.
 */
public class StationLab {
    private ArrayList<Station> mStations;

    private static StationLab sLevelLab;
    private Context mAppContext;

    private StationLab(Context appContext) {
        mAppContext = appContext;
        mStations = new ArrayList<Station>();

        Station stat1 = new Station();
        stat1.setStationName("First station");
        stat1.setTotalDocks(30);
        stat1.setAvailableDocks(10);
        stat1.setAvailableBikes(20);
        stat1.setLastCommunicationTime(new Date(1989, 01, 15));
        stat1.setId(UUID.randomUUID());
        mStations.add(stat1);

        Station stat2 = new Station();
        stat2.setStationName("Second station");
        stat2.setTotalDocks(25);
        stat2.setAvailableDocks(20);
        stat2.setAvailableBikes(5);
        stat2.setLastCommunicationTime(new Date(2015, 07, 26));
        stat2.setId(UUID.randomUUID());
        mStations.add(stat2);

        /*WS CALL*/
    }

    public static StationLab get(Context c) {
        if (sLevelLab == null) {
            sLevelLab= new StationLab(c.getApplicationContext());
        }
        return sLevelLab;
    }

    public Station getStation(UUID id) {
        for (Station s : mStations) {
            if (s.getId().equals(id))
                return s;
        }
        return null;
    }

    public ArrayList<Station> getStations() {
        return mStations;
    }
}
