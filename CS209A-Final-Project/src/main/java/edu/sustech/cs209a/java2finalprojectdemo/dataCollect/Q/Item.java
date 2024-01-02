package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q;

import edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A.JsonRootBeanEachQuestion;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2023-12-27 15:20:50
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Item implements Serializable {

    private List<String> tags;
    private Owner owner;
    private boolean is_answered;
    private long view_count;
    private long accepted_answer_id;
    private int answer_count;
    private int score;
//    data要加3个0
    private long last_activity_date;
    private long creation_date;
    private long question_id;
    private String content_license;
    private String link;
    private String title;
    private String body;
    private JsonRootBeanEachQuestion answer;

    public JsonRootBeanEachQuestion getAnswer() {
        return answer;
    }

    public void setAnswer(JsonRootBeanEachQuestion answer) {
        this.answer = answer;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public List<String> getTags() {
        return tags;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }
    public boolean getIs_answered() {
        return is_answered;
    }

    public void setView_count(long view_count) {
        this.view_count = view_count;
    }
    public long getView_count() {
        return view_count;
    }

    public void setAccepted_answer_id(long accepted_answer_id) {
        this.accepted_answer_id = accepted_answer_id;
    }
    public long getAccepted_answer_id() {
        return accepted_answer_id;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }
    public int getAnswer_count() {
        return answer_count;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public void setLast_activity_date(long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }
    public long getLast_activity_date() {
        return last_activity_date;
    }

    public void setCreation_date(long creation_date) {
        this.creation_date = creation_date;
    }
    public long getCreation_date() {
        return creation_date;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }
    public long getQuestion_id() {
        return question_id;
    }

    public void setContent_license(String content_license) {
        this.content_license = content_license;
    }
    public String getContent_license() {
        return content_license;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public boolean isIs_answered() {
        return is_answered;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}