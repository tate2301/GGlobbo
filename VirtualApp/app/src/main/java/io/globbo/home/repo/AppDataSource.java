package io.globbo.home.repo;

import android.content.Context;

import com.globbo.sutt.remote.InstallResult;

import org.jdeferred.Promise;

import java.io.File;
import java.util.List;

import io.globbo.home.models.AppData;
import io.globbo.home.models.AppInfo;
import io.globbo.home.models.AppInfoLite;

/**
 * @author Lody
 * @version 1.0
 */
public interface AppDataSource {

    /**
     * @return All the Applications we Virtual.
     */
    Promise<List<AppData>, Throwable, Void> getVirtualApps();

    /**
     * @param context Context
     * @return All the Applications we Installed.
     */
    Promise<List<AppInfo>, Throwable, Void> getInstalledApps(Context context);

    Promise<List<AppInfo>, Throwable, Void> getStorageApps(Context context, File rootDir);

    InstallResult addVirtualApp(AppInfoLite info);

    boolean removeVirtualApp(String packageName, int userId);
}
