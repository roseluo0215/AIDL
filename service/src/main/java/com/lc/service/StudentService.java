package com.lc.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class StudentService extends Service {

  private List<StudentInfo> mStudentInfoList;

  @Override
  public IBinder onBind(Intent intent) {
    mStudentInfoList = new ArrayList<>();
    return mBinder;
  }

  private IStudentAidl.Stub mBinder = new IStudentAidl.Stub() {
    @Override
    public void addStudentInfo(StudentInfo student) throws RemoteException {
      mStudentInfoList.add(student);
    }

    @Override
    public List<StudentInfo> getStudentList() throws RemoteException {
      return mStudentInfoList;
    }

    @Override
    public String getName() throws RemoteException {
      return "我是来自其他app";
    }

  };

  @Override
  public void onCreate() {
    super.onCreate();
  }
}
