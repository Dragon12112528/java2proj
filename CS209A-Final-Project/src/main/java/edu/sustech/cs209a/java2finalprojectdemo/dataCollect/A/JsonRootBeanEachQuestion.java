package edu.sustech.cs209a.java2finalprojectdemo.dataCollect.A;
import java.io.Serializable;
import java.util.List;
public class JsonRootBeanEachQuestion implements Serializable {

    private List<Items> items;
    private boolean has_more;
    private int quota_max;
    private int quota_remaining;
    public void setItems(List<Items> items) {
        this.items = items;
    }
    public List<Items> getItems() {
        return items;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }
    public boolean getHas_more() {
        return has_more;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }
    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_remaining(int quota_remaining) {
        this.quota_remaining = quota_remaining;
    }
    public int getQuota_remaining() {
        return quota_remaining;
    }

}
