package edu.sustech.cs209a.java2finalprojectdemo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.sustech.cs209a.java2finalprojectdemo.Analyzer.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Controller
public class DemoController {
    static StringBuilder ac=new StringBuilder();
    static StringBuilder vc=new StringBuilder();
    static StringBuilder at=new StringBuilder();
    static StringBuilder bu=new StringBuilder();
    static StringBuilder sy=new StringBuilder();
    static StringBuilder ex=new StringBuilder();
    static StringBuilder fa=new StringBuilder();
    public static void transData(List<Topic> topicList, StringBuilder str){
        str.append("{");
        for (int i=0;i<topicList.size();i++){
            Topic topic=topicList.get(i);
            str.append("\"").append(topic.name).append("\"").append(":").append(topic.hot);
            if(i!=topicList.size()-1) {
                str.append(",");
            }
        }
        str.append("}");
    }
    @GetMapping({"/", "/myPage"})
    public String myPage(Model model, Request request) throws IOException, ClassNotFoundException {
        UserService.logOk("into the page");
        ac=new StringBuilder();
        vc=new StringBuilder();
        at=new StringBuilder();
        bu=new StringBuilder();
        sy=new StringBuilder();
        ex=new StringBuilder();
        fa=new StringBuilder();
        Analyzer a = new Analyzer();
        //根据平均浏览量
        a.resetList(new ViewCountCalculator());
        List<Topic> topicList = a.getList();
        transData(topicList,vc);
        //根据活跃时间
        a.resetList(new ActivityCalculator());
        topicList = a.getList();
        transData(topicList,at);
        //根据平均回答量
        a.resetList(new AnswerCountCalculator());
        topicList = a.getList();
        transData(topicList,ac);

        //bug
        a.resetBugsList();
        topicList = a.getList();
        transData(topicList,bu);

        //syntax
        a.resetSyntaxerrorsList();
        topicList = a.getList();
        transData(topicList,sy);

        //fatal
        a.resetFatalerrorsList();
        topicList = a.getList();
        transData(topicList,fa);

        //exception
        a.resetExceptionsList();
        topicList = a.getList();
        transData(topicList,ex);

        model.addAttribute("ac",ac);
        model.addAttribute("vc",vc);
        model.addAttribute("at",at);
        model.addAttribute("bu",bu);
        model.addAttribute("sy",sy);
        model.addAttribute("fa",fa);
        model.addAttribute("ex",ex);
        model.addAttribute("sea","{}");
        return "myPage";
    }
    @PostMapping("/submit")
    public String submit(@RequestParam("search") String search,Model model) throws IOException, ClassNotFoundException {
        UserService.logOk("search: "+search);
        Analyzer a=new Analyzer();
        a.resetRelatedList(search);
        List<Topic> topicList=a.getList();
        StringBuilder sea=new StringBuilder();

        sea.append("{");
        for (int i=0;i<topicList.size();i++){
            Topic topic=topicList.get(i);
            sea.append("\"").append(topic.name).append("\"").append(":").append((1.0*topic.hot/ topic.num));
            if(i!=topicList.size()-1) {
                sea.append(",");
            }
        }
        sea.append("}");
        model.addAttribute("sea",sea);

        model.addAttribute("ac",ac);
        model.addAttribute("vc",vc);
        model.addAttribute("at",at);
        model.addAttribute("bu",bu);
        model.addAttribute("sy",sy);
        model.addAttribute("fa",fa);
        model.addAttribute("ex",ex);
        return "myPage";
    }
}
