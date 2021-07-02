package com.globbo.sutt.client.hook.proxies.wifi_scanner;

import com.globbo.sutt.client.hook.base.BinderInvocationProxy;

/**
 * @author Lody
 */

public class WifiScannerStub extends BinderInvocationProxy {

    public WifiScannerStub() {
        super(new GhostWifiScannerImpl(), "wifiscanner");
    }

}
