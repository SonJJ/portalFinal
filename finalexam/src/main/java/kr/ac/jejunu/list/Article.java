package kr.ac.jejunu.list;

import java.util.Date;

public class Article {

    private int list_id;
    private String list_title;
    private String list_content;
    private Date occ_time;

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }

    public String getList_content() {
        return list_content;
    }

    public void setList_content(String list_content) {
        this.list_content = list_content;
    }

    public Date getOcc_time() {
        return occ_time;
    }

    public void setOcc_time(Date occ_time) {
        this.occ_time = occ_time;
    }
}
