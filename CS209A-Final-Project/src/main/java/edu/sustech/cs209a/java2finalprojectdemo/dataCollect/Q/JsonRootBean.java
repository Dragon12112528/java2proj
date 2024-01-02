package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.JsonRootBeanEach100;

import java.io.Serializable;
import java.util.List;

public class JsonRootBean implements Serializable {
    private List<JsonRootBeanEach100> itemsOfEach100;

    public List<JsonRootBeanEach100> getItemsOfEach100() {
        return itemsOfEach100;
    }

    public void setItemsOfEach100(List<JsonRootBeanEach100> itemsOfEach100) {
        this.itemsOfEach100 = itemsOfEach100;
    }
}
