package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.Q;

import java.io.Serializable;

/**
 * Auto-generated: 2023-12-27 15:20:50
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Owner implements Serializable {

    private long account_id;
    private int reputation;
    private long user_id;
    private String user_type;
    private int accept_rate;
    private String profile_image;
    private String display_name;
    private String link;
    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }
    public long getAccount_id() {
        return account_id;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
    public int getReputation() {
        return reputation;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public long getUser_id() {
        return user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    public String getUser_type() {
        return user_type;
    }

    public void setAccept_rate(int accept_rate) {
        this.accept_rate = accept_rate;
    }
    public int getAccept_rate() {
        return accept_rate;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    public String getProfile_image() {
        return profile_image;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
    public String getDisplay_name() {
        return display_name;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

}