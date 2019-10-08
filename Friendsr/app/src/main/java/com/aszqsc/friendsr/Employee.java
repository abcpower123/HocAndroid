package com.aszqsc.friendsr;

public class Employee {

    private long mId;

    private String mName;

    public Employee(long id, String name) {
        mId = id;
        mName = name;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
