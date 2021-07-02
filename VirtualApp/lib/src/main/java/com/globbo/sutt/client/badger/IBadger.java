package com.globbo.sutt.client.badger;

import android.content.Intent;

import com.globbo.sutt.remote.BadgerInfo;

/**
 * @author Lody
 */
public interface IBadger {

    String getAction();

    BadgerInfo handleBadger(Intent intent);

}
