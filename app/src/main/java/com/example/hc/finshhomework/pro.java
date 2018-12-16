package com.example.hc.finshhomework;

/**
 * Created by hc on 2018/12/14.
 */
public class pro {
    private int img;
    private String name;
    private String text;
    private int img2;

    public pro(int img, String name, String text,int img2) {
        this.img = img;
        this.name = name;
        this.text = text;
        this.img2 = img2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public int getImg2(){
        return img2;
    }
    public void setImg2(int img2){
        this.img2=img2;
    }
}
