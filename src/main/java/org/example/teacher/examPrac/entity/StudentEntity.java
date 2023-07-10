package org.example.teacher.examPrac.entity;

public class StudentEntity {

    Student[] stuArr;

    int nextArrIdx;

    int stuNextNo;

    // 현재 DB의 가용 공간 상태.
    boolean stuArrStatus = false;

    // Sample 데이터의 수. => 배열에 저장시 실제 insert 되는 기준.
    static int SAMPLE_DATA_COUNT = 5;

    // 현재 DB의 가용 공간 상태 : 여유가 있는 경우
    static boolean ARRAY_STATUS_FULL = true;

    // 현재 DB의 가용 공간 상태 : 여유가 없는 경우
    static boolean ARRAY_STATUS_NO_FULL = false;

    // 현재 DB의 가용 공간 상태 : 여유가 없는 경우의 에러
    public static int ERR_ARRAY_Full = 2;

    public Student[] getStuArr() {
        return stuArr;
    }

    public int getNextArrIdx() {
        return nextArrIdx;
    }

    public int initStudentEntity(int arrLength, boolean sampleDataInsert) {
        stuArr = new Student[arrLength];

        if (sampleDataInsert && arrLength > SAMPLE_DATA_COUNT) {
            for (int i = 0; i < StudentEntity.SAMPLE_DATA_COUNT; i++) {
                Student student = new Student();
                student.stuNo = i + 1;
                student.stuName = "Student" + student.stuNo;
                student.korScore = 100 - (i * 10);
                student.engScore = 100 - (i * 10);
                student.mathScore = 100 - (i * 10);

                stuArr[i] = student;

                nextArrIdx = i + 1;
                stuNextNo = student.stuNo + 1;
            }
            return arrLength;
        } else {
            return 0;
        }
    }

    public int insertStudent(Student student) {
        // DB에 저장 가능한지 확인.
        if (stuArrStatus) return ERR_ARRAY_Full;

        // (가능하면) 배열에 학생정보 저장.
        student.setStuNo(stuNextNo);
        student.setStuName(student.getStuName() + stuNextNo);
        stuArr[nextArrIdx] = student;

        // 다음 데이터를 위해서 DB 관리정보 갱신.
        stuNextNo++;
        nextArrIdx++;

        // 다음 데이터를 DB에 저장할 수 있는 상태인지 Check
        if (stuArr.length == nextArrIdx) {
            stuArrStatus = StudentEntity.ARRAY_STATUS_FULL;
        } else {
            stuArrStatus = StudentEntity.ARRAY_STATUS_NO_FULL;
        }
        return nextArrIdx;
    }
}
