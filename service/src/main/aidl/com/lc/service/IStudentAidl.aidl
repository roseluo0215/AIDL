// IStudentAidl.aidl
package com.lc.service;

// Declare any non-default types here with import statements

import com.lc.service.StudentInfo;
import java.util.List;


interface IStudentAidl {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void addStudentInfo(in StudentInfo student);

    List<StudentInfo> getStudentList();

    String getName();
}
