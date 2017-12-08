package com.hawk.recovery.test;

import android.app.Application;
import android.util.Log;

import com.hawk.recovery.callback.RecoveryCallback;
import com.hawk.recovery.core.Recovery;

/**
 * Created by zhengxiaoyong on 16/8/26.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("zxy", "Recovery: init");
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .mainPage(MainActivity.class)
                .callback(new MyCrashCallback())
                .silent(Recovery.SilentMode.RECOVER_ACTIVITY_STACK)
                .init(this);
    }

    static final class MyCrashCallback implements RecoveryCallback {
        @Override
        public void stackTrace(String exceptionMessage) {
            Log.e("zxy", "exceptionMessage:" + exceptionMessage);
        }

        @Override
        public void cause(String cause) {
            Log.e("zxy", "cause:" + cause);
        }

        @Override
        public void exception(String exceptionType, String throwClassName, String throwMethodName, int throwLineNumber) {
            Log.e("zxy", "exceptionClassName:" + exceptionType);
            Log.e("zxy", "throwClassName:" + throwClassName);
            Log.e("zxy", "throwMethodName:" + throwMethodName);
            Log.e("zxy", "throwLineNumber:" + throwLineNumber);
        }

        @Override
        public void throwable(Throwable throwable) {

        }
    }
}
