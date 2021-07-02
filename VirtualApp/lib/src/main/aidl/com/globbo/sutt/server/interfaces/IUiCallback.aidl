// IUiCallback.aidl
package com.globbo.sutt.server.interfaces;

interface IUiCallback {
    void onAppOpened(in String packageName, in int userId);
    void onOpenFailed(in String packageName, in int userId);
}
