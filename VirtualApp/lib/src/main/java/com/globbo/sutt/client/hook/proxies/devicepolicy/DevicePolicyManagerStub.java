package com.globbo.sutt.client.hook.proxies.devicepolicy;

import android.content.Context;

import com.globbo.sutt.client.core.VirtualCore;
import com.globbo.sutt.client.hook.base.BinderInvocationProxy;
import com.globbo.sutt.client.hook.base.MethodProxy;

import java.lang.reflect.Method;

import mirror.android.app.admin.IDevicePolicyManager;

/**
 * Created by wy on 2017/10/20.
 */

public class DevicePolicyManagerStub extends BinderInvocationProxy{
    public DevicePolicyManagerStub() {
        super(IDevicePolicyManager.Stub.asInterface, Context.DEVICE_POLICY_SERVICE);
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
        addMethodProxy(new GetStorageEncryptionStatus());
    }

    private static class GetStorageEncryptionStatus extends MethodProxy {

        @Override
        public String getMethodName() {
            return "getStorageEncryptionStatus";
        }

        @Override
        public Object call(Object who, Method method, Object... args) throws Throwable {
            args[0] = VirtualCore.get().getHostPkg();
            return method.invoke(who, args);
        }
    }
}
