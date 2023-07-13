package org.example.me.verFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStudentRepo {

    private static Map<Integer, StudentInfo> store = new HashMap<>();
    private static int id = 1;

    public void save(StudentInfo studentInfo) {
        store.put(id++, studentInfo);
    }

    public StudentInfo findById(int id) {
        return store.get(id);
    }

    public StudentInfo findByName(String name) {
        for (int i = 1; i <= id; i++) {
            StudentInfo studentInfo = store.get(i);
            if (studentInfo.getName().equals(name)) {
                return studentInfo;
            }
        }
        return null;
    }

    public List<StudentInfo> findAll() {
        List<StudentInfo> studentInfoList = new ArrayList<>();
        for (int i = 1; i < id; i++) {
            StudentInfo studentInfo = store.get(i); // findById(i);  // store.get(id);
            studentInfoList.add(studentInfo);
        }
        return studentInfoList;
    }
}
