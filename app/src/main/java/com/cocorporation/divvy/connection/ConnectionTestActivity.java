package com.cocorporation.divvy.connection;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cocorporation.divvy.data.Station;
import com.cocorporation.divvy.data.StationsContainer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ConnectionTestActivity{

    // json array response url
    private static String urlJsonArry = "https://www.divvybikes.com/stations/json";
    private static String urlJsonObj = "https://www.divvybikes.com/stations/json";

    private static String TAG = ConnectionTestActivity.class.getSimpleName();

    private static ArrayList<Station> mStations;
    private static ArrayAdapter<Station> mAdapter;



    /**
     * Method to make json array request where response starts with [
     */
    public static void makeJsonArrayRequest(ArrayList<Station> stations, ArrayAdapter<Station> adapter) {

        mStations = stations;
        mAdapter = adapter;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                urlJsonObj, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    /*JACKSON:*/
                    /*ObjectMapper mapper=new ObjectMapper();
                    userData=mapper.readValue(jsonResponse,ContactPojo.class);*/

                    /*
                    JSONArray jArr = jObj.getJSONArray("list");
                    for (int i=0; i < jArr.length(); i++) {
                        JSONObject obj = jArr.getJSONObject(i);
                        ....
                    }

                    JSONObject subObj = jObj.getJSONObject("address");
                    String city = subObj.getString("city");
                    ...
                    */

                    // Parsing json object response
                    // response will be a json object
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");

                    Date executionTime = format.parse(response.getString("executionTime"));

                    StationsContainer stationsContainer = new StationsContainer();
                    stationsContainer.setExecutionTime(executionTime);

                    List<Station> stationBeanList = new ArrayList<Station>();
                    stationsContainer.setStationBeanList(stationBeanList);


                    JSONArray jArr = response.getJSONArray("stationBeanList");
                    for (int i=0; i < jArr.length(); i++) {
                        JSONObject data = jArr.getJSONObject(i);

                        UUID id = UUID.randomUUID();
                        int idOrigin = data.getInt("id");
                        String stationName = data.getString("stationName");
                        int totalDocks = data.getInt("totalDocks");
                        int availableDocks = data.getInt("availableDocks");
                        int availableBikes = data.getInt("availableBikes");

                        Station station = new Station();
                        station.setId(id);
                        station.setIdOrigin(idOrigin);
                        station.setStationName(stationName);
                        station.setTotalDocks(totalDocks);
                        station.setAvailableDocks(availableDocks);
                        station.setAvailableBikes(availableBikes);

                        mStations.add(station);
                    }


                    mAdapter.notifyDataSetChanged();
                    Log.d(TAG, "Import completed");



                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
}