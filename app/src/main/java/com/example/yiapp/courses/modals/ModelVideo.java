package com.example.yiapp.courses.modals;

import java.io.Serializable;

public class ModelVideo implements Serializable {
    String title;
    String desc;
    String vdoSrc;

    public ModelVideo() {
    }

    public ModelVideo(String title, String desc, String vdoSrc) {
        this.title = title;
        this.desc = desc;
        this.vdoSrc = vdoSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVdoSrc() {
        return vdoSrc;
    }

    public void setVdoSrc(String vdoSrc) {
        this.vdoSrc = vdoSrc;
    }
}
