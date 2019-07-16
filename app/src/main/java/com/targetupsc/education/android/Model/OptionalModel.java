package com.targetupsc.education.android.Model;

public class OptionalModel {

    String Title;
    boolean IsSelected;

    public boolean isSelected() {
        return IsSelected;
    }

    public void setSelected(boolean selected) {
        IsSelected = selected;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
