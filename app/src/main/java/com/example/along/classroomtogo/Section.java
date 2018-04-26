package com.example.along.classroomtogo;

/**
 * Created by Long on 3/13/2018.
 */

public class Section {
    private int mId;
    private int mCourseId;
    private int mProfessorId;

    public Section(int mId, int mCourseId, int mProfessorId) {
        this.mId = mId;
        this.mCourseId = mCourseId;
        this.mProfessorId = mProfessorId;
    }

    public Section(int mCourseId, int mProfessorId) {
        this.mId = -1;
        this.mCourseId = mCourseId;
        this.mProfessorId = mProfessorId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(int mCourseId) {
        this.mCourseId = mCourseId;
    }

    public int getmProfessorId() {
        return mProfessorId;
    }

    public void setmProfessorId(int mProfessorId) {
        this.mProfessorId = mProfessorId;
    }
}
