package com.cocorporation.divvy.data;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Corentin on 7/25/2015.
 */
public class Station {
    private UUID id;
    private String stationName;
    private int availableDocks;
    private int totalDocks;
    private float latitude;
    private float longitude;
    private String statusValue;
    private int statusKey;
    private int availableBikes;
    private String stAddress1;
    private String stAddress2;
    private String city;
    private int postalCode;
    private float location;
    private float altitude;
    private boolean testStation;

    /*SETTERS*/

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setAvailableDocks(int availableDocks) {
        this.availableDocks = availableDocks;
    }

    public void setTotalDocks(int totalDocks) {
        this.totalDocks = totalDocks;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public void setStatusKey(int statusKey) {
        this.statusKey = statusKey;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    public void setStAddress1(String stAddress1) {
        this.stAddress1 = stAddress1;
    }

    public void setStAddress2(String stAddress2) {
        this.stAddress2 = stAddress2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setLocation(float location) {
        this.location = location;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public void setTestStation(boolean testStation) {
        this.testStation = testStation;
    }

    public void setLastCommunicationTime(Date lastCommunicationTime) {
        this.lastCommunicationTime = lastCommunicationTime;
    }

    public void setLandMark(int landMark) {
        this.landMark = landMark;
    }

    /*GETTERS*/

    public UUID getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public int getAvailableDocks() {
        return availableDocks;
    }

    public int getTotalDocks() {
        return totalDocks;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public int getStatusKey() {
        return statusKey;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public String getStAddress1() {
        return stAddress1;
    }

    public String getStAddress2() {
        return stAddress2;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public float getLocation() {
        return location;
    }

    public float getAltitude() {
        return altitude;
    }

    public boolean isTestStation() {
        return testStation;
    }

    public Date getLastCommunicationTime() {
        return lastCommunicationTime;
    }

    public int getLandMark() {
        return landMark;
    }

    private Date lastCommunicationTime;
    private int landMark;
}
