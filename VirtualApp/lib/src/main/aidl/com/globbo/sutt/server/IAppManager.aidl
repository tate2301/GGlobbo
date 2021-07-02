// IAppManager.aidl
package com.globbo.sutt.server;

import com.globbo.sutt.server.interfaces.IPackageObserver;
import com.globbo.sutt.server.interfaces.IAppRequestListener;
import com.globbo.sutt.remote.InstalledAppInfo;
import com.globbo.sutt.remote.InstallResult;

interface IAppManager {
    int[] getPackageInstalledUsers(String packageName);
    void scanApps();
    void addVisibleOutsidePackage(String pkg);
    void removeVisibleOutsidePackage(String pkg);
    boolean isOutsidePackageVisible(String pkg);
    InstalledAppInfo getInstalledAppInfo(String pkg, int flags);
    InstallResult installPackage(String path, int flags);
    boolean isPackageLaunched(int userId, String packageName);
    void setPackageHidden(int userId, String packageName, boolean hidden);
    boolean installPackageAsUser(int userId, String packageName);
    boolean uninstallPackageAsUser(String packageName, int userId);
    boolean uninstallPackage(String packageName);
    boolean clearPackageAsUser(int userId, String packageName);
    boolean clearPackage(String packageName);
    List<InstalledAppInfo> getInstalledApps(int flags);
    List<InstalledAppInfo> getInstalledAppsAsUser(int userId, int flags);
    int getInstalledAppCount();
    boolean isAppInstalled(String packageName);
    boolean isAppInstalledAsUser(int userId, String packageName);

    void registerObserver(IPackageObserver observer);
    void unregisterObserver(IPackageObserver observer);

    void setAppRequestListener(IAppRequestListener listener);
    void clearAppRequestListener();
    IAppRequestListener getAppRequestListener();

}
