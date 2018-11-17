package com.lc.aidl;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lc.service.IStudentAidl;
import com.lc.service.StudentInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  private IStudentAidl mIStudentAidl;
  private ServiceConnection mServiceConnection = new ServiceConnection() {
    @SuppressLint("ShowToast")
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
      mIStudentAidl = IStudentAidl.Stub.asInterface(iBinder);
      Toast.makeText(MainActivity.this, "conn successful", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
      Toast.makeText(MainActivity.this, "disconn successful", Toast.LENGTH_LONG).show();

      mIStudentAidl = null;
    }
  };

  private int mAge = 23;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Intent intent = new Intent();
    intent.setComponent(new ComponentName("com.lc.service", "com.lc.service.StudentService"));
    bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
      @SuppressLint("ShowToast")
      @Override
      public void onClick(View view) {
        if (mIStudentAidl == null) {
          return;
        }
        try {
          mIStudentAidl.addStudentInfo(new StudentInfo("张三", mAge));
          mAge++;
          List<StudentInfo> studentList = mIStudentAidl.getStudentList();
          int size = studentList.size();
          String name = mIStudentAidl.getName();
          Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();

        } catch (RemoteException e) {
          e.printStackTrace();
        }
      }
    });



  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    unbindService(mServiceConnection);
  }
}
