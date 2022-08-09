package com.example.myapplication1.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Album implements Parcelable {
    private String ma;
    private int mb;
    private float mc;
    protected Album(Parcel in) {
        ma = in.readString();
        mb = in.readInt();
        mc = in.readFloat();
    }
//        负责反序列化
    public static final Creator<Album> CREATOR = new Creator<Album>() {
//        从序列化对象中，获取原始对象
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }
//        创建指定长度的原始对象数组
        @Override
        public Album[] newArray(int size) {
            return new Album[size];
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

    public static Creator<Album> getCREATOR() {
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
