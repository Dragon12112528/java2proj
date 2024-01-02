package edu.sustech.cs209a.java2finalprojectdemo.Analyzer;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A.Items;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.Item;
import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q.JsonRootBean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    private JsonRootBean questions_ser;
    private int tot_num;
    private List<Topic> topics;
    public int getTot_num()
    {
        return tot_num;
    }

    public List<Topic> getList()
    {
        return topics;
    }

    private static boolean checkRegexInStringIgnoreCase(String input, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public void test()
    {
        Topic top = new Topic("1");
        top.key.add("exception");
        for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++)
        {
            List<Item> items = questions_ser.getItemsOfEach100().get(i).getItems();
            for (Item question : items)
            {
                checkin(top,question);
            }
        }
    }
    private void initialSyntaxerrorsList()//初始化Syntaxerrors
    {
        Topic topic;
        topic = new Topic("cannot resolve symbol ***");
        topic.key.add("cannot resolve symbol");
        topics.add(topic);
        topic = new Topic("cannot resolve method ***");
        topic.key.add("cannot resolve method");
        topics.add(topic);
        topic = new Topic("cannot find symbol ***");
        topic.key.add("cannot find symbol");
        topics.add(topic);
        topic = new Topic("*** cannot be applied to ***");
        topic.key.add("cannot be applied to");
        topics.add(topic);
        topic = new Topic("incompatible type");
        topic.key.add("incompatible type");
        topics.add(topic);
        topic = new Topic("type arugument");
        topic.key.add("type arugument");
        topics.add(topic);
        topic = new Topic("cannot access ***");
        topic.key.add("cannot access");
        topics.add(topic);
        topic = new Topic("*** expected");
        topic.key.add("expected");
        topics.add(topic);
    }
    private void initialFatalerrorsList()//初始化fatalerrors
    {
        Topic topic;
        topic = new Topic("Internal Error");
        topic.key.add("Internal Error");
        topics.add(topic);
        topic = new Topic("OutOfMemoryError");
        topic.key.add("OutOfMemoryError");
        topics.add(topic);
        topic = new Topic("StackOverflowError");
        topic.key.add("StackOverflowError");
        topics.add(topic);
        topic = new Topic("NoClassDefFoundError");
        topic.key.add("NoClassDefFoundError");
        topics.add(topic);
        topic = new Topic("UnsatisfiedLinkError");
        topic.key.add("UnsatisfiedLinkError");
        topics.add(topic);
    }
    private void initialExceptionsList()//初始化exception
    {
        Topic topic;
        topic = new Topic("beancreationexception");
        topic.key.add("beancreationexception");
        topics.add(topic);
        topic = new Topic("classnotfoundexception");
        topic.key.add("classnotfoundexception");
        topics.add(topic);
        topic = new Topic("illegalargumentexception");
        topic.key.add("illegalargumentexception");
        topics.add(topic);
        topic = new Topic("illegalstateexception");
        topic.key.add("illegalstateexception");
        topics.add(topic);
        topic = new Topic("interruptedexception");
        topic.key.add("interruptedexception");
        topics.add(topic);
        topic = new Topic("ioexception");
        topic.key.add("ioexception");
        topics.add(topic);
        topic = new Topic("nullpointerexception");
        topic.key.add("nullpointerexception");
        topics.add(topic);
        topic = new Topic("runtimeexception");
        topic.key.add("runtimeexception");
        topics.add(topic);
        topic = new Topic("servletexception");
        topic.key.add("servletexception");
        topics.add(topic);
        topic = new Topic("sqlexception");
        topic.key.add("sqlexception");
        topics.add(topic);
    }
    private void initialBugsList()//初始化BUG关键字
    {
        Topic topic = new Topic("syntax error");
        topic.key.add("cannot resolve symbol");
        topic.key.add("cannot resolve method");
        topic.key.add("cannot find symbol");
        topic.key.add("cannot be applied to");
        topic.key.add("cannot access");
        topic.key.add("incompatible type");
        topic.key.add("compiler-error");
        topic.key.add("compiler error");
        topic.key.add("type arugument");
        topic.key.add("syntax error");
        topic.key.add("expected");
        topics.add(topic);

        topic = new Topic("Fatal errors");
        topic.key.add("Internal Error");
        topic.key.add("OutOfMemoryError");
        topic.key.add("StackOverflowError");
        topic.key.add("NoClassDefFoundError");
        topic.key.add("UnsatisfiedLinkError");
        topic.key.add("fatal error");
        topics.add(topic);

        topic = new Topic("Exceptions");
        topic.key.add("exception");
        topics.add(topic);
    }

    private void initialTopicList()//初始化主题 关键字
    {
        Topic topic = new Topic("lambda");
        topic.key.add("lambda");
        topics.add(topic);

        topic = new Topic("stream");
        topic.key.add("stream");
        topics.add(topic);

        topic = new Topic("io");
        topic.key.add("io");
        topic.key.add("input");
        topic.key.add("output");
        topic.key.add("FileNotFoundException");
        topic.key.add("read");
        topic.key.add("write");
        topics.add(topic);

        topic = new Topic("exception");
        topic.key.add("exception");
        topics.add(topic);

        topic = new Topic("concurrency");
        topic.key.add("thread");
        topic.key.add("runnable");
        topic.key.add("concurrency");
        topic.key.add("parallel");
        topic.key.add("Callable");
        topic.key.add("Future");
        topic.key.add("concurrent");
        topic.key.add("ExecutorService");
        topics.add(topic);

        topic = new Topic("socket");
        topic.key.add("socket");
        topic.key.add("server");
        topic.key.add("client");
        topics.add(topic);

        topic = new Topic("javaFX");
        topic.key.add("javafx");
        topics.add(topic);

        topic = new Topic("reflection");
        topic.key.add("reflection");
        topics.add(topic);

        topic = new Topic("spring");
        topic.key.add("spring");
        topics.add(topic);

        topic = new Topic("javaEE");
        topic.key.add("javaee");
        topic.key.add("java-ee");
        topic.key.add("jakarta-ee");
        topic.key.add("jakartaee");
        topics.add(topic);
    }
    public void resetExceptionsList()
    {
        topics = new ArrayList<Topic>();
        initialExceptionsList();
        bugWorker();
    }
    public void resetFatalerrorsList()
    {
        topics = new ArrayList<Topic>();
        initialFatalerrorsList();
        bugWorker();
    }
    public void resetSyntaxerrorsList()
    {
        topics = new ArrayList<Topic>();
        initialSyntaxerrorsList();
        bugWorker();
    }
    public void resetBugsList()
    {
        topics = new ArrayList<Topic>();
        initialBugsList();
        bugWorker();
    }

    private void bugWorker()
    {
        for (Topic top : topics)
        {
            for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++)
            {
                List<Item> items = questions_ser.getItemsOfEach100().get(i).getItems();
                for (Item question : items)
                {
                    if(checkin(top,question))
                    {
                        top.hot += question.getView_count();
                        top.num++;
                    }
                }
            }
        }
    }
    public void resetRelatedList(String str)
    {
        topics = new ArrayList<Topic>();
        initialTopicList();
        Topic KeyTopic = new Topic("Key");
        KeyTopic.key.add(str);

        for (Topic top : topics)
        {
            for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++)
            {
                List<Item> items = questions_ser.getItemsOfEach100().get(i).getItems();
                for (Item question : items)
                {
                    if(checkRelatedin(top,question))
                    {
                        top.num++;
                        if(checkRelatedin(KeyTopic,question))
                            top.hot += 1;
                    }
                }
            }
        }
    }
    private boolean checkRelatedin(Topic topic,Item question)
    {
        List<String> tags = question.getTags();

        for(String tag:tags)
        {
            for(String regex:topic.key)
            {
                if(tag.toLowerCase().startsWith(regex.toLowerCase()) || tag.toLowerCase().endsWith(regex.toLowerCase()))
                {
                    return true;
                }
            }
        }

        String title = question.getTitle();

        for(String regex:topic.key)
        {
            regex = "(?<![a-zA-Z])"+regex+"(?![a-zA-Z])";
            if(checkRegexInStringIgnoreCase(title,regex))
            {
//                System.out.println(title);
                return true;
            }
        }

        String body = question.getBody();

        for(String regex:topic.key)
        {
            regex = "(?<![a-zA-Z])"+regex+"(?![a-zA-Z])";
            if(checkRegexInStringIgnoreCase(body,regex))
            {
//                System.out.println(body);
                return true;
            }
        }

        List<Items> answers = question.getAnswer().getItems();
        for (Items answer : answers)
        {
            body = answer.getBody();

            for(String regex:topic.key)
            {
                regex = "(?<![a-zA-Z])"+regex+"(?![a-zA-Z])";
                if(checkRegexInStringIgnoreCase(body,regex))
                {
//                    System.out.println(body);
                    return true;
                }
            }
        }

        return false;
    }

    public void resetList(Calculator cal)
    {
        topics = new ArrayList<Topic>();
        initialTopicList();

        for (Topic top : topics)
        {
            for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++)
            {
                List<Item> items = questions_ser.getItemsOfEach100().get(i).getItems();
                for (Item question : items)
                {
                    if(checkRelatedin(top,question))
                    {
                        top.num++;
                        top.hot += cal.calculate(question);
                    }
                }
            }
        }
    }
    private boolean checkin(Topic topic,Item question)
    {
        List<String> tags = question.getTags();

        for(String tag:tags)
        {
            for(String regex:topic.key)
            {
                if(checkRegexInStringIgnoreCase(tag,regex))
                {
//                    System.out.println(tag);
                    return true;
                }
            }
        }

        String title = question.getTitle();

        for(String regex:topic.key)
        {
            if(checkRegexInStringIgnoreCase(title,regex))
            {
//                System.out.println(title);
                return true;
            }
        }

        String body = question.getBody();

        for(String regex:topic.key)
        {
            if(checkRegexInStringIgnoreCase(body,regex))
            {
//                System.out.println(body);
                return true;
            }
        }

        List<Items> answers = question.getAnswer().getItems();
        for (Items answer : answers)
        {
            body = answer.getBody();

            for(String regex:topic.key)
            {
                if(checkRegexInStringIgnoreCase(body,regex))
                {
//                    System.out.println(body);
                    return true;
                }
            }
        }

        return false;
    }
    public Analyzer() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("src/main/resources/data/QuestionWithAnswer.ser");
        // 创建一个对象输入流，用于从文件中读取对象
        ObjectInputStream in = new ObjectInputStream(fileIn);
        // 从对象输入流中读取对象
        questions_ser = (JsonRootBean) in.readObject();
        // 关闭对象输入流和文件输入流
        in.close();
        fileIn.close();
        // 输出反序列化后的对象信息
        for (int i = 0; i < questions_ser.getItemsOfEach100().size(); i++) {
            tot_num += questions_ser.getItemsOfEach100().get(i).getItems().size();
        }
    }
}
