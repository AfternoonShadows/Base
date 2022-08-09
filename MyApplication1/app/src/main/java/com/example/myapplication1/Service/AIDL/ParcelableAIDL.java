package com.example.myapplication1.Service.AIDL;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableAIDL implements Parcelable {
    private String ma;
    private int mb;
    private float mc;
    protected ParcelableAIDL(Parcel in) {
        ma = in.readString();
        mb = in.readInt();
        mc = in.readFloat();
    }
    //        负责反序列化
    public static final Creator<ParcelableAIDL> CREATOR = new Creator<ParcelableAIDL>() {
        //        从序列化对象中，获取原始对象
        @Override
        public ParcelableAIDL createFromParcel(Parcel in) {
            return new ParcelableAIDL(in);
        }
        //        创建指定长度的原始对象数组
        @Override
        public ParcelableAIDL[] newArray(int size) {
            return new ParcelableAIDL[size];
        }
    };

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getMb() {
        return mb;
    }

    public void setMb(int mb) {
        this.mb = mb;
    }

    public float getMc() {
        return mc;
    }

    public void setMc(float mc) {
        this.mc = mc;
    }

    public static Creator<ParcelableAIDL> getCREATOR() {
        return CREATOR;
    }

    //         描述返回的是内容的描述信息，只针对一些特殊的需要描述信息的对象，需要返回1，其他情况返回0就可以。
    @Override
    public int describeContents() {
        return 0;
    }
    //         序列化
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ma);
        dest.writeInt(mb);
        dest.writeFloat(mc);
    }
}

