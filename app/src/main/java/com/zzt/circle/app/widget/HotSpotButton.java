package com.zzt.circle.app.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import at.markushi.ui.CircleButton;

/**
 * Created by zzt on 15-6-8.
 */
public class HotSpotButton extends CircleButton {
    private int hotspotID;

    public HotSpotButton(Context context, int hotspotID) {
        super(context);
        this.hotspotID = hotspotID;
        setColor(Color.argb(200, 200, 200, 200));
        setLayoutParams(new ViewGroup.LayoutParams(50, 50));
    }

    public HotSpotButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HotSpotButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public int getHotspotID() {
        return hotspotID;
    }
}
