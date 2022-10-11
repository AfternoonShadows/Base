// IMyAidlInterface.aidl
package com.example.aidlservice;
import com.example.aidlservice.parcelableone;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    void registListener(IMyAidlInterface i);
    int getname();
    void setname();
    void removetext(inout RParcelable r);
}