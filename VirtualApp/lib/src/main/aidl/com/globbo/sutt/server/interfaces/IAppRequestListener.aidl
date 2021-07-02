// IAppRequestListener.aidl
package com.globbo.sutt.server.interfaces;

interface IAppRequestListener {
    void onRequestInstall(in String path);
    void onRequestUninstall(in String pkg);
}
