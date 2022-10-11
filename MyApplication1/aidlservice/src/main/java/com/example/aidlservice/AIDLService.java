package com.example.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

public class AIDLService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(getPackageName() + ".AIDLService", "onCreate");
    }

    public String a = null;
    IMyAidlInterface iMyAidlInterface = new IMyAidlInterface.Stub() {
        public IMyAidlInterface I;
//        @Override
//        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
//            Log.e("AIDLService", "basicTypes");
//            a = "adf";
//        }

        @Override
        public void registListener(IMyAidlInterface i) throws RemoteException {
            this.I = i;
        }

        @Override
        public int getname() throws RemoteException {
            Log.e("AIDLService", "getname");
            if (I != null) {
                return 4;
            }
            return 0;
        }

        @Override
        public void setname() throws RemoteException {
            Log.e("a = ", "setname");
        }

        @Override
        public void removetext(RParcelable r) throws RemoteException {
            Log.e("AIDLService", r.toString());
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(getPackageName() + ".AIDLService", "onBind");
        return iMyAidlInterface.asBinder();
//        return new onBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(getPackageName() + ".AIDLService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e(getPackageName() + ".AIDLService", "onDestroy");
        super.onDestroy();
    }

    class onBind extends Binder {
        onBind() {
            Log.e(getPackageName() + ".onBind", "onBind");
        }
    }
}
