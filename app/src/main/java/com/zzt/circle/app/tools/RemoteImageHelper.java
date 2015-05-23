package com.zzt.circle.app.tools;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzt on 15-5-18.
 */
public class RemoteImageHelper {
    private InputStream download(String urlString) throws MalformedURLException, IOException {
        InputStream inputStream = (InputStream) new URL(urlString).getContent();
        return inputStream;
    }

    private final Map<String, Drawable> cache = new HashMap<String, Drawable>();

    public void loadImage(final ImageView imageView, final String urlString, boolean useCache) {
        if (useCache&&cache.containsKey(urlString)) {
            imageView.setImageDrawable(cache.get(urlString));
        }

//        imageView.setImageResource();
    }
}
