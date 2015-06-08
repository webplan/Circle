package com.zzt.circle.app.entity;

/**
 * Created by zzt on 15-5-31.
 */
public class Hotspot {
    private int hotspotID;
    private double x;
    private double y;

    public Hotspot(int hotspotID, double x, double y) {
        this.hotspotID = hotspotID;
        this.x = x;
        this.y = y;
    }

    public int getHotspotID() {
        return hotspotID;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
