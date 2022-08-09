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
        Log.e(getPackageName()+".AIDLService","onCreate");
    }
    IMyAidlInterface iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.e("iMyAidlInterface","basicTypes");
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(getPackageName()+".AIDLService","onBind");
//        new onBind()
        return iMyAidlInterface.asBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(getPackageName()+".AIDLService","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e(getPackageName()+".AIDLService","onDestroy");
        super.onDestroy();
    }
    class onBind extends Binder{
       onBind(){
           Log.e(getPackageName()+".onBind","onBind");
       }
    }
}
