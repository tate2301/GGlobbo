package com.globbo.sutt.client.hook.secondary;

import com.globbo.sutt.helper.utils.Reflect;
import com.globbo.sutt.helper.utils.ReflectException;

/**
 * @author Lody
 */

public class HackAppUtils {

    /**
     * Enable the Log output of QQ.
     *
     * @param packageName package name
     * @param classLoader class loader
     */
    public static void enableQQLogOutput(String packageName, ClassLoader classLoader) {
        if ("com.tencent.mobileqq".equals(packageName)) {
            try {
                Reflect.on("com.tencent.qphone.base.util.QLog", classLoader).set("UIN_REPORTLOG_LEVEL", 100);
            } catch (ReflectException e) {
                // ignore
            }
        }
    }
}
