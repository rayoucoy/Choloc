package com.skripsi.yudha.choloc.Tracker;

import java.io.Serializable;

/**
 * Created by affan on 24/05/16.
 */
public class PlaceDetails implements Serializable {

    @Key
    public String status;

    @Key
    public Place result;

    @Override
    public String toString() {
        if (result!=null) {
            return result.toString();
        }
        return super.toString();
    }
}
