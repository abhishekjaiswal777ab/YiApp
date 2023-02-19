package com.example.yiapp.courses.modals;

import java.util.ArrayList;

public class CourseRoot {
    ArrayList<ModelCourse> allCourses;
    public CourseRoot() {
    }

    public CourseRoot(ArrayList<ModelCourse> arr) {
        this.allCourses = arr;
    }

    public ArrayList<ModelCourse> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(ArrayList<ModelCourse> arr) {
        this.allCourses = arr;
    }
}
