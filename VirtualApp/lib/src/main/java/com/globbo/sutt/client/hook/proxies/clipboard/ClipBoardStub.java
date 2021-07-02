package com.globbo.sutt.client.hook.proxies.clipboard;

import android.content.Context;
import android.os.Build;
import android.os.IInterface;

import com.globbo.sutt.client.core.VirtualCore;
import com.globbo.sutt.client.hook.base.BinderInvocationProxy;
import com.globbo.sutt.client.hook.base.ReplaceLastPkgMethodProxy;
import com.globbo.sutt.helper.compat.BuildCompat;
import com.globbo.sutt.helper.utils.DeviceUtil;

import mirror.android.content.ClipboardManager;
import mirror.android.content.ClipboardManagerOreo;

/**
 * @author Lody
 * @see ClipboardManager
 */
public class ClipBoardStub extends BinderInvocationProxy {

    public ClipBoardStub() {
        super(getInterface(), Context.CLIPBOARD_SERVICE);
    }

    private static IInterface getInterface() {
        if (isOreo()) {
            android.content.ClipboardManager cm = (android.content.ClipboardManager)
                    VirtualCore.get().getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            return ClipboardManagerOreo.mService.get(cm);
        } else {
            return ClipboardManager.getService.call();
        }
    }

    @Override
    protected void onBindMethods() {
        super.onBindMethods();
        addMethodProxy(new ReplaceLastPkgMethodProxy("getPrimaryClip"));
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
            addMethodProxy(new ReplaceLastPkgMethodProxy("setPrimaryClip"));
            addMethodProxy(new ReplaceLastPkgMethodProxy("getPrimaryClipDescription"));
            addMethodProxy(new ReplaceLastPkgMethodProxy("hasPrimaryClip"));
            addMethodProxy(new ReplaceLastPkgMethodProxy("addPrimaryClipChangedListener"));
            addMethodProxy(new ReplaceLastPkgMethodProxy("removePrimaryClipChangedListener"));
            addMethodProxy(new ReplaceLastPkgMethodProxy("hasClipboardText"));
        }
    }

    @Override
    public void inject() throws Throwable {
        super.inject();
        if (isOreo()) {
            android.content.ClipboardManager cm = (android.content.ClipboardManager)
                    VirtualCore.get().getContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipboardManagerOreo.mService.set(cm, getInvocationStub().getProxyInterface());
        } else {
            ClipboardManager.sService.set(getInvocationStub().getProxyInterface());
        }
    }

    private static boolean isOreo() {
        return BuildCompat.isOreo() &&
                !DeviceUtil.isSamsung()
                || ClipboardManager.getService == null;
    }
}
