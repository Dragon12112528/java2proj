package edu.sustech.cs209a.java2finalprojectdemo.controller;

import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    public static String handlePopularity(List<Topic> topicList,String topic){
        StringBuilder re=new StringBuilder();
        boolean exit=false;
        for (Topic t:topicList){
            if(t.name.equals(topic)){
                exit=true;
                re.append("{").append("\"").append(topic).append("\"").append(":").append(t.hot).append("}");
            }
        }
        if (exit){
            return String.valueOf(re);
        }else{
            UserService.logWarn("REST topic: invalid Topic");
            return "{\"invalidTopic\": 0}";
        }
    }
    public static String handlePopularity(List<Topic> topicList){
        StringBuilder str=new StringBuilder();
        str.append("{");
        for (int i=0;i<topicList.size();i++){
            Topic topic=topicList.get(i);
            str.append("\"").append(topic.name).append("\"").append(":").append(topic.hot);
            if(i!=topicList.size()-1) {
                str.append(",");
            }
        }
        str.append("}");
        return String.valueOf(str);
    }
    public static String handleTopN(List<Topic> topicList,int n){
        StringBuilder str=new StringBuilder();
        int size=topicList.size();
        Topic[] topicArr= new Topic[size];
        for (int i=0;i<size;i++){
            topicArr[i]=topicList.get(i);
        }
        Arrays.sort(topicArr, new Comparator<Topic>() {
            @Override
            public int compare(Topic o1, Topic o2) {
                return (o2.hot-o1.hot)>0?1:(o2.hot-o1.hot==0?0:-1);
            }
        });

        str.append("{");
        //n 1-10
        for (int i = 1; i<=(Math.min(n, size)); i++){
            Topic topic=topicArr[i-1];
            str.append("\"").append(topic.name).append("\"").append(":").append(topic.hot);
            if(i!=Math.min(n,10)) {
                str.append(",");
            }
        }
        str.append("}");
        return String.valueOf(str);
    }
//    http://localhost:8090/topics/popularity/viewCount/Java
    // 查询特定主题的流行度
    @GetMapping("/popularity/viewCount/{topic}")
    public ResponseEntity<String> getTopicPopularityViewCount(@PathVariable String topic) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ViewCountCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic: "+topic+" by viewCount");
        return ResponseEntity.ok(handlePopularity(topicList,topic));
    }
    @GetMapping("/popularity/activity/{topic}")
    public ResponseEntity<String> getTopicPopularityActivity(@PathVariable String topic) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ActivityCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic: "+topic+" by activity");
        return ResponseEntity.ok(handlePopularity(topicList,topic));
    }
    @GetMapping("/popularity/answerCount/{topic}")
    public ResponseEntity<String> getTopicPopularityAnswerCount(@PathVariable String topic) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new AnswerCountCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic: "+topic+" by answerCount");
        return ResponseEntity.ok(handlePopularity(topicList,topic));
    }

    @GetMapping("/popularity/viewCount")
    public ResponseEntity<String> getPopularityViewCount() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ViewCountCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST  topics by viewCount");
        return ResponseEntity.ok(handlePopularity(topicList));
    }
    @GetMapping("/popularity/activity")
    public ResponseEntity<String> getPopularityActivity() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ActivityCalculator());
        List<Topic> topicList = a.getList();

        UserService.logOk("REST  topics by activity");
        return ResponseEntity.ok(handlePopularity(topicList));
    }
    @GetMapping("/popularity/answerCount")
    public ResponseEntity<String> getPopularityAnswerCount() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new AnswerCountCalculator());
        List<Topic> topicList = a.getList();

        UserService.logOk("REST  topics by answerCount");
        return ResponseEntity.ok(handlePopularity(topicList));
    }


    //    http://localhost:8090/topics/top/viewCount/1
    // 查询前N个热门主题
    @GetMapping("/top/viewCount/{n}")
    public ResponseEntity<String> getTopNTopicsViewCount(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ViewCountCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic top n: "+n+" by viewCount");
        return ResponseEntity.ok(handleTopN(topicList,n));
    }

    @GetMapping("/top/activity/{n}")
    public ResponseEntity<String> getTopNTopicsActivity(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new ActivityCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic top n: "+n+" by activity");
        return ResponseEntity.ok(handleTopN(topicList,n));
    }

    @GetMapping("/top/answerCount/{n}")
    public ResponseEntity<String> getTopNTopicsAnswerCount(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetList(new AnswerCountCalculator());
        List<Topic> topicList = a.getList();
        UserService.logOk("REST topic top n: "+n+" by answerCount");
        return ResponseEntity.ok(handleTopN(topicList,n));
    }
}

