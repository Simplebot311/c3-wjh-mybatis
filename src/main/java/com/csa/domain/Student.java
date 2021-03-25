package com.csa.domain;

import java.io.Serializable;

/**
 * @author yufeng1900
 * @create 2021-03-24 22:39
 */
public class Student implements Serializable {
    private String sNo;
    private String name;
    private Integer age;
    private String college;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    @Override
    public String toString() {
        return "Student{" +
                "sNo='" + sNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                '}';
    }
}
