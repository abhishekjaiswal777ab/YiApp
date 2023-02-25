package com.example.yiapp.courses.modals;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelQuestions implements Serializable {
    String question;
    ArrayList<ModelOptions> options;

    public ModelQuestions() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<ModelOptions> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<ModelOptions> options) {
        this.options = options;
    }
}
