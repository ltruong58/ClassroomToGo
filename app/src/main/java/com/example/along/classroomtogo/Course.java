package com.example.along.classroomtogo;

/**
 * Created by Long on 3/13/2018.
 */

public class Course {
    private int mId;
    private String mCourseName;
    private String mCourseCode;
    private String mTerm;
    private String mImageName;

    public Course(int mId, String mCourseName, String mCourseCode, String mTerm, String mImageName) {
        this.mId = mId;
        this.mCourseName = mCourseName;
        this.mCourseCode = mCourseCode;
        this.mTerm = mTerm;
        this.mImageName = mImageName;
    }

    public Course(String mCourseName, String mCourseCode, String mTerm, String mImageName) {
        this.mId = -1;
        this.mCourseName = mCourseName;
        this.mCourseCode = mCourseCode;
        this.mTerm = mTerm;
        this.mImageName = mImageName;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmCourseCode() {
        return mCourseCode;
    }

    public void setmCourseCode(String mCourseCode) {
        this.mCourseCode = mCourseCode;
    }

    public String getmTerm() {
        return mTerm;
    }

    public void setmTerm(String mTerm) {
        this.mTerm = mTerm;
    }

    public String getmImageName() {
        return mImageName;
    }

    public void setmImageName(String mImageName) {
        this.mImageName = mImageName;
    }
}
