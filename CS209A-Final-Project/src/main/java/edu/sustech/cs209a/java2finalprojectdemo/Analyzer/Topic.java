package edu.sustech.cs209a.java2finalprojectdemo.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    public String name;
    public List<String> key;
    public long hot;
    public int num;
    public Topic(String name)
    {
        this.name = name;
        num = 0;
        hot = 0;
        key = new ArrayList<String>();
    }

    public String toString()
    {
        return "Name:"+name+" Hot:"+hot+" Number:"+num;
    }
}
