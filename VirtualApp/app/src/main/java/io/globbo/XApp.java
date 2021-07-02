package io.globbo;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.globbo.sutt.client.NativeEngine;
import com.globbo.sutt.client.core.VirtualCore;
import com.globbo.sutt.client.stub.VASettings;

import io.globbo.delegate.MyVirtualInitializer;

/**
 * @author Lody
 */
public class XApp extends Application {

    private static final String TAG = "XApp";

    public static final String XPOSED_INSTALLER_PACKAGE = "de.robv.android.xposed.installer";

    private static XApp gApp;

    public static XApp getApp() {
        return gApp;
    }

    @Override
    protected void attachBaseContext(Context base) {
        gApp = this;
        super.attachBaseContext(base);
        MultiDex.install(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NativeEngine.disableJit(Build.VERSION.SDK_INT);
        }
        VASettings.ENABLE_IO_REDIRECT = true;
        VASettings.ENABLE_INNER_SHORTCUT = false;
        try {
            VirtualCore.get().startup(base);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        VirtualCore virtualCore = VirtualCore.get();
        virtualCore.initialize(new MyVirtualInitializer(this, virtualCore));
    }

}
