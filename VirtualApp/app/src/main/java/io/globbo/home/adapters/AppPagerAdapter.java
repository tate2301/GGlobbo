package io.globbo.home.adapters;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.globbo.sutt.helper.utils.DeviceUtil;
import com.globbo.sutt.helper.utils.Reflect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.globbo.XApp;
import io.globbo.R;
import io.globbo.home.ListAppFragment;

/**
 * @author Lody
 */
public class AppPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles = new ArrayList<>();
    private List<File> dirs = new ArrayList<>();

    public AppPagerAdapter(FragmentManager fm) {
        super(fm);
        titles.add(XApp.getApp().getResources().getString(R.string.clone_apps));
        dirs.add(null);
    }

    @Override
    public Fragment getItem(int position) {
        return ListAppFragment.newInstance(dirs.get(position));
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
