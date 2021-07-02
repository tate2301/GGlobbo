// IServiceFetcher.aidl
package com.globbo.sutt.server.interfaces;

interface IServiceFetcher {
    IBinder getService(String name);
    void addService(String name,in IBinder service);
    void removeService(String name);
}