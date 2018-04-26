package com.example.along.classroomtogo;

/**
 * Created by Long on 3/13/2018.
 */

public class ClassRegister {
    private int mId;
    private int mStudentId;
    private int mSectionId;

    public ClassRegister(int mId, int mStudentId, int mSectionId) {
        this.mId = mId;
        this.mStudentId = mStudentId;
        this.mSectionId = mSectionId;
    }

    public ClassRegister(int mStudentId, int mSectionId) {
        this.mId = -1;
        this.mStudentId = mStudentId;
        this.mSectionId = mSectionId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmStudentId() {
        return mStudentId;
    }

    public void setmStudentId(int mStudentId) {
        this.mStudentId = mStudentId;
    }

    public int getmSectionId() {
        return mSectionId;
    }

    public void setmSectionId(int mSectionId) {
        this.mSectionId = mSectionId;
    }
}
