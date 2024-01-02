package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class StackOverflowDataCollector_Q {

    private static final String TAG = "java";
    private static final int NUM_THREADS = 30;

    public static void main(String[] args) {
        try {
            for (int i = 26; i <= NUM_THREADS; i++) {
                //2020 1 1 -- 2023 12 1
                String urlString = "https://api.stackexchange.com/2.3/questions?page=" + i + "&pagesize=100&fromdate=1577808000&todate=1701360000&order=desc&sort=activity&tagged=" + TAG + "&site=stackoverflow&filter=withbody";
                System.out.println(urlString);
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();


                int responseCode = connection.getResponseCode();
                System.out.println(connection.getContentType());

                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(connection.getInputStream()), StandardCharsets.UTF_8));
                    String inputLine;

                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    System.out.println(content.toString());
//                    Gson gson = new Gson();
//                    // 将JSON字符串解析为Java对象
//                    JsonRootBean items = gson.fromJson(String.valueOf(content), JsonRootBean.class);
//                    System.out.println(items.getItems().size());
                    in.close();
                    connection.disconnect();
                    try {
                        String fileName="src/main/resources/data/question.json";
                        FileWriter fileWriter = new FileWriter(fileName,true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(String.valueOf(content));
                        bufferedWriter.close();
                        fileWriter.close();
                        System.out.println("成功将内容写入文件：" + fileName);
                    } catch (IOException e) {
                        System.out.println("发生错误：" + e.getMessage());
                    }

                    // 解析JSON响应并提取所需数据
                    // ...
                } else {
                    System.out.println("Failed to fetch data: " + responseCode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

