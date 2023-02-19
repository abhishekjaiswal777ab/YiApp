package com.example.yiapp.ui.home.model;

import java.util.ArrayList;

public class ModelVertical {
    private String _id;
    private String name;
    private String desc;
    private ArrayList<String> courseIds;
    private String imgSrc;

    public ModelVertical() {
    }

    public ModelVertical(String _id, String name, String desc, ArrayList<String> courseIds, String imgSrc) {
        this._id = _id;
        this.name = name;
        this.desc = desc;
        this.courseIds = courseIds;
        this.imgSrc = imgSrc;
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

    public ArrayList<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(ArrayList<String> courseIds) {
        this.courseIds = courseIds;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
