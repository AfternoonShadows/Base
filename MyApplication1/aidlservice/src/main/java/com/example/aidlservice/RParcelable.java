package com.example.aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

public class RParcelable implements Parcelable {
    protected RParcelable(Parcel in) {
    }

    public static final Creator<RParcelable> CREATOR = new Creator<RParcelable>() {
        @Override
        public RParcelable createFromParcel(Parcel in) {
            return new RParcelable(in);
        }

        @Override
        public RParcelable[] newArray(int size) {
            return new RParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
