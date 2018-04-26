package com.example.along.classroomtogo;

/**
 * Created by Long on 3/10/2018.
 */

public class Professor {
    private int mId;
    private String mLastName;
    private String mFirstName;
    private String mEmail;
    private String mPassword;

    public Professor(int mId, String mLastName, String mFirstName, String mEmail, String mPassword) {
        this.mId = mId;
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public Professor(String mLastName, String mFirstName, String mEmail, String mPassword) {
        this.mId = -1;
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
