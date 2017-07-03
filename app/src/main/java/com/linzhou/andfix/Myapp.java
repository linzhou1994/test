package com.linzhou.andfix;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;
import java.io.IOException;


/*
 *项目名： Andfix
 *包名：   com.linzhou.andfix
 *创建者:  linzhou
 *创建时间:17/05/28
 *描述:   
 */


public class Myapp extends Application {

    private static final String TAG = "euler";

    /**
     * patch manager
     */
    public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize
        mPatchManager = new PatchManager(this);
        mPatchManager.init("1.0");
        Log.d(TAG, "inited.");

        // load patch
        mPatchManager.loadPatch();


    }
}
