package com.skripsi.yudha.choloc.model;

/**
 * Created by yudha on 28/06/2016.
 */

import java.io.Serializable;

/**
 * Created by Lincoln on 07/01/16.
 */
public class ObjekWisata implements Serializable {
    String id, name, lastMessage, timestamp;
    int unreadCount; double lat,lng;

    public ObjekWisata() {
    }

    public ObjekWisata(String id, String name, String lastMessage, String timestamp, int unreadCount, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
        this.unreadCount = unreadCount;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
