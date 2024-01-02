package edu.sustech.cs209a.java2finalprojectdemo.Analyzer;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.Item;

public class ActivityCalculator implements Calculator{
    @Override
    public long calculate(Item item) {
        return (1703758402 - item.getLast_activity_date()) < 604800?1:0;
    }

}
