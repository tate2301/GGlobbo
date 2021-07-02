package io.globbo.delegate;

import android.app.Application;

import com.globbo.sutt.client.core.VirtualCore;

/**
 * @author weishu
 * @date 2019/2/25.
 */
public class MyVirtualInitializer extends BaseVirtualInitializer {
    public MyVirtualInitializer(Application application, VirtualCore core) {
        super(application, core);
    }
}
