package com.github.hyeyeon2371.archdemo2.data.model;

/**
 * @author Hyeyeon Park
 */
public class ListItem {
    private int position = 0;
    private String text;

    public ListItem(String text) {
        this.text = text;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
