package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class GetInformationByJson {


    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "src/main/resources/data/question.json";
        StringBuilder content=new StringBuilder();
        try(Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                content.append(line);
            }
        }
//        System.out.println(content);
        Gson gson = new Gson();
        // 将JSON字符串解析为Java对象
        JsonRootBean questions = gson.fromJson(String.valueOf(content), JsonRootBean.class);
//      questions有个list ItemsOfEach100 装的每一页内100条问题记录，每页有个list Items 装的每个问题记录
        System.out.println(questions.getItemsOfEach100().get(24).getItems().get(97).getBody());
//        序列化
        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/data/JsonRootBean.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(questions);
            out.close();
            fileOut.close();
            System.out.println("序列化成功，已将对象保存到 JsonRootBean.ser 文件中");
        } catch (IOException i) {
            i.printStackTrace();
        }
//        反序列化
        try {
            // 创建一个文件输入流，用于读取序列化的对象文件
            FileInputStream fileIn = new FileInputStream("src/main/resources/data/JsonRootBean.ser");
            // 创建一个对象输入流，用于从文件中读取对象
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 从对象输入流中读取对象
            JsonRootBean questions_ser = (JsonRootBean) in.readObject();
            // 关闭对象输入流和文件输入流
            in.close();
            fileIn.close();
            // 输出反序列化后的对象信息
            System.out.println("反序列化后的对象信息：");
            System.out.println(questions_ser.getItemsOfEach100().get(24).getItems().get(97).getBody());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("找不到指定的类");
            c.printStackTrace();
        }

    }
}
