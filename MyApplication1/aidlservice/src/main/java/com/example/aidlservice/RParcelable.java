package com.example.aidlservice;

import android.os.Parcel;
import android.os.Parcelable;

public class RParcelable implements Parcelable {
    public String name;
    public int age;
    public RParcelable(){};
    protected RParcelable(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Creator<RParcelable> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "RParcelable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void readFromParcel(Parcel reply) {
    }
}
