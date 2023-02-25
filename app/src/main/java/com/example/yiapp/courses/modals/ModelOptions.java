package com.example.yiapp.courses.modals;

import java.io.Serializable;

public class ModelOptions implements Serializable {
    String text;
    Boolean isChecked;

    public ModelOptions() {
    }

    public ModelOptions(String text, Boolean isChecked) {
        this.text = text;
        this.isChecked = isChecked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
