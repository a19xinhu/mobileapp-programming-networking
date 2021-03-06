package com.example.networking;

public class Mountain {
    private String name;
    private String location;
    private int height;

    public Mountain(String inName,String inLocation,int inHeight){
        name=inName;
        location=inLocation;
        height=inHeight;
    }

    public Mountain(String inName){
        name=inName;
        location="";
        height=-1;
    }

    public String info(){
        String str=name;
        str+=" is located in ";
        str+=location;
        str+=" and has en height of ";
        str+=Integer.toString(height);
        str+="m.";
        return str;
    }

    public void setHeight(int newHeight){
        height=newHeight;
    }
}
