package com.akin.mysqlite.model;

public class Student {
    String firstName, lastName;
    int count, rate;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = 0;
        this.rate = 10;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getRate()
    {
        return rate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return rate;
    }

    public void setPrice(int price) {
        this.rate = price;
    }
}
