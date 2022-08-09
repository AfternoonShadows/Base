// IMyAidlInterface.aidl
//包名和实体类的包名一致
package com.example.myapplication1.Service.AIDL;
import com.example.myapplication1.Service.AIDL.ParcelableAIDL;

//parcelable化的实体
//创建方法类型的AIDL
parcelable ParcelableAIDL;

// Declare any non-default types here with import statements
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}