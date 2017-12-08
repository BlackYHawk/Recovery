package com.hawk.recovery.tools;


import com.hawk.recovery.exception.RecoveryException;

/**
 * Created by zgxiaoyong on 16/8/28.
 */
public class DefaultHandlerUtil {

    private DefaultHandlerUtil() {
        throw new RecoveryException("Stub!");
    }

    private static Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() throws Exception {
        Object object = Reflect.on("com.android.internal.os.RuntimeInit$UncaughtHandler").constructor().newInstance();
        return object == null ? null : (Thread.UncaughtExceptionHandler) object;
    }

    public static boolean isSystemDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler handler) {
        try {
            Thread.UncaughtExceptionHandler defHandler = getDefaultUncaughtExceptionHandler();
            return defHandler != null && defHandler.getClass().isInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

}
