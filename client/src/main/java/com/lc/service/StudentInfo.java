package com.lc.service;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentInfo implements Parcelable {

  private int age;

  private String name;

  public StudentInfo(String name, int age) {
    this.name = name;
    this.age = age;
  }

  protected StudentInfo(Parcel in) {
    age = in.readInt();
    name = in.readString();
  }

  public static final Creator<StudentInfo> CREATOR = new Creator<StudentInfo>() {
    @Override
    public StudentInfo createFromParcel(Parcel in) {
      return new StudentInfo(in);
    }

    @Override
    public StudentInfo[] newArray(int size) {
      return new StudentInfo[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(age);
    parcel.writeString(name);
  }

  @Override
  public String toString() {
    return "StudentInfo{" +
        "name='" + name +
        ", age=" + age + "}";
  }
}
