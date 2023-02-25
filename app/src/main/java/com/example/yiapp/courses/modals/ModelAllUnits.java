package com.example.yiapp.courses.modals;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelAllUnits implements Serializable {
    ModelVideo video;
    String text;
    ArrayList<String> activities;
    ArrayList<ModelQuestions> quiz;
    String _id;

    public ModelAllUnits() {
    }

    public ModelAllUnits(ModelVideo video, String text, ArrayList<String> activities, ArrayList<ModelQuestions> quiz, String _id) {
        this.video = video;
        this.text = text;
        this.activities = activities;
        this.quiz = quiz;
        this._id = _id;
    }

    public ModelVideo getVideo() {
        return video;
    }

    public void setVideo(ModelVideo video) {
        this.video = video;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<String> activities) {
        this.activities = activities;
    }

    public ArrayList<ModelQuestions> getQuiz() {
        return quiz;
    }

    public void setQuiz(ArrayList<ModelQuestions> quiz) {
        this.quiz = quiz;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
