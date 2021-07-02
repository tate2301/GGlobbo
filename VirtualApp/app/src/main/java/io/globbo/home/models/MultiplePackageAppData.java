package io.globbo.home.models;

import android.graphics.drawable.Drawable;

import com.globbo.sutt.client.core.VirtualCore;
import com.globbo.sutt.remote.InstalledAppInfo;

/**
 * @author Lody
 */

public class MultiplePackageAppData implements AppData {

    public InstalledAppInfo appInfo;
    public int userId;
    public boolean isFirstOpen;
    public boolean isInstalling;
    public boolean isLoading;
    public Drawable icon;
    public String name;

    public MultiplePackageAppData(PackageAppData target, int userId) {
        this.userId = userId;
        this.appInfo = VirtualCore.get().getInstalledAppInfo(target.packageName, 0);
        this.isFirstOpen = !appInfo.isLaunched(userId);
        if (target.icon != null) {
            Drawable.ConstantState state = target.icon.getConstantState();
            if (state != null) {
                icon = state.newDrawable();
            }
        }
        name = target.name;
    }

    @Override
    public boolean isInstalling() {
        return isInstalling;
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public boolean isFirstOpen() {
        return isFirstOpen;
    }

    @Override
    public Drawable getIcon() {
        return icon;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canReorder() {
        return true;
    }

    @Override
    public boolean canLaunch() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return true;
    }

    @Override
    public boolean canCreateShortcut() {
        return true;
    }
}
