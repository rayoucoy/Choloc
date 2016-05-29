package com.skripsi.yudha.choloc.Tracker;

import java.io.Serializable;
import java.util.List;

/**
 * Created by affan on 24/05/16.
 */
public class PlacesList implements Serializable {
    @Key
    public String status;

    @Key
    public List<Place> results;
}
