package com.example.yiapp.courses.modals;

import java.util.ArrayList;

public class ModelCourse {
    String _id;
    String name;
    String desc;
    ArrayList<Object> unitArr=new ArrayList<>();

    public ModelCourse() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Object> getUnitArr() {
        return unitArr;
    }

    public void setUnitArr(ArrayList<Object> unitArr) {
        this.unitArr = unitArr;
    }
}
