package com.globbo.sutt.client.hook.proxies.bluetooth;

import android.os.Build;

import com.globbo.sutt.client.hook.base.BinderInvocationProxy;
import com.globbo.sutt.client.hook.base.StaticMethodProxy;
import com.globbo.sutt.helper.utils.marks.FakeDeviceMark;

import java.lang.reflect.Method;

import mirror.android.bluetooth.IBluetooth;

/**
 * @see android.bluetooth.BluetoothManager
 */
public class BluetoothStub extends BinderInvocationProxy {
    public static final String SERVICE_NAME = Build.VERSION.SDK_INT >= 17 ?
            "bluetooth_manager" :
            "bluetooth";

    public BluetoothStub() {
        super(IBluetooth.Stub.asInterface, SERVICE_NAME);
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
        addMethodProxy(new GetAddress());
    }

    @FakeDeviceMark("fake MAC")
    private static class GetAddress extends StaticMethodProxy {

        GetAddress() {
            super("getAddress");
        }

        @Override
        public Object call(Object who, Method method, Object... args) throws Throwable {
            return getDeviceInfo().bluetoothMac;
        }
    }
}
