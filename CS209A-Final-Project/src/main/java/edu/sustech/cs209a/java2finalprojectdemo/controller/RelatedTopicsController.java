package edu.sustech.cs209a.java2finalprojectdemo.controller;

import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.Analyzer;
import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/related-topics")
public class RelatedTopicsController {
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
                return (1.0*o2.hot/o2.num-1.0*o1.hot/o1.num)>0?1:(1.0*o2.hot/o2.num-1.0*o1.hot/o1.num==0?0:-1);
            }
        });

        str.append("{");
        //n 1-10
        for (int i = 1; i<=(Math.min(n, size)); i++){
            Topic topic=topicArr[i-1];
            str.append("\"").append(topic.name).append("\"").append(":").append(1.0*topic.hot/topic.num);
            if(i!=Math.min(n,10)) {
                str.append(",");
            }
        }
        str.append("}");
        return String.valueOf(str);
    }

//    http://localhost:8090/related-topics/thread
    // 查询特定输入的相关主题
    @GetMapping("/{input}")
    public ResponseEntity<String> getRelatedTopics(@PathVariable String input) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetRelatedList(input);
        List<Topic> topicList = a.getList();
        UserService.logOk("REST related:"+input);
        return ResponseEntity.ok(handleTopN(topicList, topicList.size()));
    }
}
