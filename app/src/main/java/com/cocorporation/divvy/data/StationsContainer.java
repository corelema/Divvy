package com.cocorporation.divvy.data;

import java.util.Date;
import java.util.List;

/**
 * Created by Corentin on 7/25/2015.
 */
public class StationsContainer {
    private Date executionTime;
    private List<Station> stationBeanList;

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public void setStationBeanList(List<Station> stationBeanList) {
        this.stationBeanList = stationBeanList;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public List<Station> getStationBeanList() {
        return stationBeanList;
    }
}
