package edu.sustech.cs209a.java2finalprojectdemo.Analyzer;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A.Items;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.Item;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.JsonRootBean;

import java.beans.PropertyEditorSupport;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    static List<String> result = new ArrayList<>();
    public static void findExceptionSubstrings(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (i + 8 < input.length() && input.substring(i, i + 9).equalsIgnoreCase("exception")) {
                int ind = i;
                while(ind>0 && Character.isLetter(input.charAt(ind)))
                {
                    ind--;
                }
                if(!Character.isLetter(input.charAt(ind))) ind++;
                result.add(input.substring(ind,i+9).toLowerCase());
            }
        }
    }
    private static boolean checkRegexInStringIgnoreCase(String input, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    private static boolean checkin(Item question)
    {
        List<String> tags = question.getTags();

        for(String tag:tags)
        {
            findExceptionSubstrings(tag);
        }

        String title = question.getTitle();

        findExceptionSubstrings(title);
        String body = question.getBody();
        findExceptionSubstrings(body);

        List<Items> answers = question.getAnswer().getItems();
        for (Items answer : answers)
        {
            body = answer.getBody();

            findExceptionSubstrings(body);
        }

        return false;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Analyzer a = new Analyzer();
//        a.resetRelatedList("Parallel");
        a.resetBugsList();
//        a.resetList(new ViewCountCalculator());
        List<Topic> topicList = a.getList();
        for(Topic topic:topicList)
        {
            System.out.println(topic.toString());
        }
        System.out.println();


        a.resetSyntaxerrorsList();
        topicList = a.getList();
        for(Topic topic:topicList)
        {
            System.out.println(topic.toString());
        }
        System.out.println();



        a.resetFatalerrorsList();
        topicList = a.getList();
        for(Topic topic:topicList)
        {
            System.out.println(topic.toString());
        }
        System.out.println();



        a.resetExceptionsList();
        topicList = a.getList();
        for(Topic topic:topicList)
        {
            System.out.println(topic.toString());
        }

        a.resetRelatedList("stream");
        for(Topic topic:a.getList())
        {
            System.out.println(topic.toString());
        }
//        JsonRootBean questions_ser;
//        FileInputStream fileIn = new FileInputStream("src/main/resources/data/QuestionWithAnswer.ser");
//        // 创建一个对象输入流，用于从文件中读取对象
//        ObjectInputStream in = new ObjectInputStream(fileIn);
//        // 从对象输入流中读取对象
//        questions_ser = (JsonRootBean) in.readObject();
//        // 关闭对象输入流和文件输入流
//        in.close();
//        fileIn.close();
//        // 输出反序列化后的对象信息
//            for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++) {
//                List<Item> items = questions_ser.getItemsOfEach100().get(i).getItems();
//                for (Item question : items) {
//                    checkin(question);
//                }
//            }
//        int tot_num = 0;
//        Collections.sort(result);
//        String last = null;
//            for(int i=0; i<result.size(); i++)
//            {
//                if(i!=0)
//                if(!result.get(i).equals(result.get(i-1)))
//                {
//                    if(tot_num>50)
//                    {
//                        System.out.println(last);
//                        System.out.println(tot_num);
//                    }
//                    tot_num = 1;
//                    last = result.get(i);
//                }
//                else
//                {
//                    tot_num++;
//                }
//            }
//        if(tot_num>50)
//        {
//            System.out.println(last);
//            System.out.println(tot_num);
//        }
    }
}
