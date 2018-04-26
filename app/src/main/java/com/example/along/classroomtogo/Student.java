package com.example.along.classroomtogo;

/**
 * Created by Long on 3/10/2018.
 */
public class Student {
    private int mId;
    private String mLastName;
    private String mFirstName;
    private String mEmail;
    private String mPassword;

    /**
     * default constructor. Initial all member variable with null value.
     */
    public Student() {    }

    /**
     * Overloading constructor create Student with full information
     * @param mId
     * @param mLastName
     * @param mFirstName
     * @param mPassword
     */
    public Student(int mId, String mLastName, String mFirstName, String mEmail, String mPassword) {
        this.mId = mId;
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    /**
     * Overloading constructor with lastname, firstname, password.
     * @param mLastName
     * @param mFirstName
     * @param mPassword
     */
    public Student(String mLastName, String mFirstName, String mEmail, String mPassword) {
        this.mId = -1;
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }

    public int getId() {
        return mId;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword(){
        return mPassword;
    }


    public void setId(int mId) {
        this.mId = mId;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setEmail(String mEmail){
        this.mEmail = mEmail;
    }

    public void setPassword(String mPassword){
        this.mPassword = mPassword;
    }

    @Override
    public String toString(){
        return "Student{" + "Id=" + mId
                + ", LastName= " + mLastName
                + ", FirstName= " + mFirstName
                + ", Email= " + mEmail
                + ", Password= " + mPassword
                + " }";
    }
}
