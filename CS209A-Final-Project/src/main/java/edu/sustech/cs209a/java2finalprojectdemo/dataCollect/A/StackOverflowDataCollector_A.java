package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A;

import com.google.gson.Gson;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.JsonRootBean;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class StackOverflowDataCollector_A {
//    根据获得的问题的id获取每个问题的答案

    public static void main(String[] args) {
//        先获取问题 questions_ser
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
            int size=1;
            // 输出反序列化后的对象信息
            for (int i=0;i<questions_ser.getItemsOfEach100().size();i++){
                JsonRootBeanEach100 jsonRootBeanEach100 = questions_ser.getItemsOfEach100().get(i);
                List<Item> items = jsonRootBeanEach100.getItems();
                for (int j=0;j<items.size();j++){
                    System.out.println(size);
                    size++;
                    Item item=items.get(j);
                    long question_id=item.getQuestion_id();
                    String urlString = "https://api.stackexchange.com/2.3/questions/"+question_id+"/answers"+"?site=stackoverflow&filter=withbody&key=0XN0p41XtKBM9Bsfp2C3nQ((";
                    System.out.println(urlString);
                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in_A = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream()), StandardCharsets.UTF_8));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in_A.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in_A.close();
                    connection.disconnect();
                    try {
                        String fileName="src/main/resources/data/answer.json";
                        FileWriter fileWriter = new FileWriter(fileName,true);  //不覆盖
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(String.valueOf(content)+",");
                        bufferedWriter.close();
                        fileWriter.close();
                        System.out.println("成功将内容写入文件：" + fileName );
                    } catch (IOException e) {
                        System.out.println("发生错误：" + e.getMessage());
                    }
                    //思路：获取每个问题的答案，temp存起来解析 放到问题属性 序列化
                    // 解析JSON响应并提取所需数据
                    Gson gson = new Gson();
                    // 将JSON字符串解析为Java对象
                    JsonRootBeanEachQuestion ans = gson.fromJson(String.valueOf(content), JsonRootBeanEachQuestion.class);
                    item.setAnswer(ans);
                } else {
                    System.out.println("Failed to fetch data: " + responseCode);
                }
                }
            }
            //        序列化
                FileOutputStream fileOut = new FileOutputStream("src/main/resources/data/QuestionWithAnswer.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(questions_ser);
                out.close();
                fileOut.close();
                System.out.println("序列化成功，已将对象保存到 QuestionWithAnswer.ser 文件中");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("找不到指定的类");
            c.printStackTrace();
        }
    }
}

