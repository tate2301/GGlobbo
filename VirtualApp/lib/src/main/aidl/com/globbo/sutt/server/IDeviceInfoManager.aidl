// IDeviceInfoManager.aidl
package com.globbo.sutt.server;

import com.globbo.sutt.remote.VDeviceInfo;

interface IDeviceInfoManager {

    VDeviceInfo getDeviceInfo(int userId);

    void updateDeviceInfo(int userId, in VDeviceInfo info);

}
