// IBinderDelegateService.aidl
package com.globbo.sutt.server;

import android.content.ComponentName;

interface IBinderDelegateService {

   ComponentName getComponent();

   IBinder getService();

}
