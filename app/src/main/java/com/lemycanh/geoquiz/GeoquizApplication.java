package com.lemycanh.geoquiz;

import android.app.Application;

/**
 * Created by lemycanh on 16/10/2019.
 */

public class GeoquizApplication extends Application {
    private static GeoquizApplication _intance;

    @Override
    public void onCreate() {
        super.onCreate();
        _intance = this;
    }

    public static GeoquizApplication Intance() {
        return _intance;
    }
}
