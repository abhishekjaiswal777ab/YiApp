package com.example.yiapp.ui.home.model;

import com.example.yiapp.ui.home.model.ModelVertical;

import java.util.ArrayList;

public class Root {

    public ArrayList<ModelVertical> allVerticals;

    public Root() {
    }

    public Root(ArrayList<ModelVertical> allVerticals) {
        this.allVerticals = allVerticals;
    }

    public ArrayList<ModelVertical> getAllVerticals() {
        return allVerticals;
    }

    public void setAllVerticals(ArrayList<ModelVertical> allVerticals) {
        this.allVerticals = allVerticals;
    }
}
