package edu.sustech.cs209a.java2finalprojectdemo.Analyzer;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.Item;

public class AnswerCountCalculator implements Calculator{

    @Override
    public long calculate(Item item) {
        return item.getAnswer_count();
    }
}
