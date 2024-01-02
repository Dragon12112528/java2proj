package edu.sustech.cs209a.java2finalprojectdemo.controller;

import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.Analyzer;
import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {
//    http://localhost:8090/bugs/popularity/syntax
    // 查询特定错误的流行度

    @GetMapping("/popularity")
    public ResponseEntity<String> getPopularity() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetBugsList();
        List<Topic> topicList=a.getList();
        StringBuilder str=new StringBuilder();
        str.append("{");
        for (int i=0;i<topicList.size();i++){
            str.append("\"").append(topicList.get(i).name).append("\"").append(":").append(topicList.get(i).hot);
            if(i!= topicList.size()-1){
                str.append(",");
            }
        }
        str.append("}");
        UserService.logOk("REST bugs by viewCount");
        return ResponseEntity.ok(String.valueOf(str));
    }

    @GetMapping("/popularity/syntax")
    public ResponseEntity<String> getPopularitySyntax() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetBugsList();
        List<Topic> topicList=a.getList();
        int index=0;
        for (int i=0;i<topicList.size();i++){
            if (topicList.get(i).name.equals("syntax error")){
                index=i;
            }
        }
        StringBuilder str=new StringBuilder();
        str.append("{").append("\"").append("syntax error").append("\"").append(":").append(topicList.get(index).hot).append("}");
        UserService.logOk("REST bugs_syntax by viewCount");
        return ResponseEntity.ok(String.valueOf(str));
    }
    // 查询特定错误的流行度
    @GetMapping("/popularity/fatal")
    public ResponseEntity<String> getPopularityFatal() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetBugsList();
        List<Topic> topicList=a.getList();
        int index=0;
        for (int i=0;i<topicList.size();i++){
            if (topicList.get(i).name.equals("Fatal errors")){
                index=i;
            }
        }
        StringBuilder str=new StringBuilder();
        str.append("{").append("\"").append("Fatal errors").append("\"").append(":").append(topicList.get(index).hot).append("}");
        UserService.logOk("REST bugs_fatal by viewCount");
        return ResponseEntity.ok(String.valueOf(str));
    }


    // 查询特定错误的流行度
    @GetMapping("/popularity/exceptions")
    public ResponseEntity<String> getPopularityExceptions() throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetBugsList();
        List<Topic> topicList=a.getList();
        int index=0;
        for (int i=0;i<topicList.size();i++){
            if (topicList.get(i).name.equals("Exceptions")){
                index=i;
            }
        }
        StringBuilder str=new StringBuilder();
        str.append("{").append("\"").append("Exceptions").append("\"").append(":").append(topicList.get(index).hot).append("}");
        UserService.logOk("REST bugs_exceptions by viewCount");
        return ResponseEntity.ok(String.valueOf(str));
    }

    public static String handleBug(List<Topic> topicList,String bug){
        if(bug.equals("all")){
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
        }else {
            StringBuilder re=new StringBuilder();
            boolean exit=false;
            for (Topic t:topicList){
                if(t.name.equals(bug)){
                    exit=true;
                    re.append("{").append("\"").append(bug).append("\"").append(":").append(t.hot).append("}");
                }
            }
            if (exit){
                return String.valueOf(re);
            }else{
                UserService.logWarn("REST bugs :invalidkey"+" "+bug);
                return "{\"invalidTopic\": 0}";
            }
        }
    }

//    http://localhost:8090/bugs/popularity/syntax/all
    // 查询特定错误的流行度
    @GetMapping("/popularity/syntax/{bug}")
    public ResponseEntity<String> getBugPopularitySyntax(@PathVariable String bug) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetSyntaxerrorsList();
        List<Topic> topicList = a.getList();
        UserService.logOk("REST bugs_syntax "+bug+" by viewCount");
        return ResponseEntity.ok(handleBug(topicList,bug));
    }
    // 查询特定错误的流行度
    @GetMapping("/popularity/fatal/{bug}")
    public ResponseEntity<String> getBugPopularityFatal(@PathVariable String bug) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetFatalerrorsList();
        List<Topic> topicList = a.getList();
        UserService.logOk("REST bugs_fatal "+bug+" by viewCount");
        return ResponseEntity.ok(handleBug(topicList,bug));
    }
    // 查询特定错误的流行度
    @GetMapping("/popularity/exceptions/{bug}")
    public ResponseEntity<String> getBugPopularityExceptions(@PathVariable String bug) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetExceptionsList();
        List<Topic> topicList = a.getList();

        UserService.logOk("REST bugs_exceptions "+bug+" by viewCount");
        return ResponseEntity.ok(handleBug(topicList,bug));
    }

//    http://localhost:8090/bugs/top/syntax/1
    // 查询前N个热门错误或异常
    @GetMapping("/top/syntax/{n}")
    public ResponseEntity<String> getTopNBugsSyntax(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetSyntaxerrorsList();
        List<Topic> topicList = a.getList();
        UserService.logOk("REST bugs_syntax top n:"+n+" by viewCount");
        return ResponseEntity.ok(TopicController.handleTopN(topicList,n));
    }

    // 查询前N个热门错误或异常
    @GetMapping("/top/fatal/{n}")
    public ResponseEntity<String> getTopNBugsFatal(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetFatalerrorsList();
        List<Topic> topicList = a.getList();
        UserService.logOk("REST bugs_fatal top n:"+n+" by viewCount");
        return ResponseEntity.ok(TopicController.handleTopN(topicList,n));
    }

    // 查询前N个热门错误或异常
    @GetMapping("/top/exceptions/{n}")
    public ResponseEntity<String> getTopNBugsExceptions(@PathVariable int n) throws IOException, ClassNotFoundException {
        Analyzer a=new Analyzer();
        a.resetExceptionsList();
        List<Topic> topicList = a.getList();
        UserService.logOk("REST bugs_exceptions top n:"+n+" by viewCount");
        return ResponseEntity.ok(TopicController.handleTopN(topicList,n));
    }
}
