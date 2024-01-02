package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A;

import java.io.Serializable;

public class Items implements Serializable {

    private Owner owner;
    private boolean is_accepted;
    private int score;
    private long last_activity_date;
    private long creation_date;
    private long answer_id;
    private long question_id;
    private String content_license;
    private String body;
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }
    public boolean getIs_accepted() {
        return is_accepted;
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

    public void setAnswer_id(long answer_id) {
        this.answer_id = answer_id;
    }
    public long getAnswer_id() {
        return answer_id;
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

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

}