package com.heshiqi.widget.ninegridview.entity;

import com.heshiqi.widget.ninegrid.ImageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heshiqi on 17/12/13.
 */

public class MainEntity {

    private int id;
    private String content;
    private String create_time;
    private String publish_time_str;
    private long publish_time;
    private int member_id;
    private int author_id;
    private String author_name;
    private String author_head_img;
    private int up_count;
    private int message_state;
    private List<ImageEntity> attachments;
    private String page_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPublish_time_str() {
        return publish_time_str;
    }

    public void setPublish_time_str(String publish_time_str) {
        this.publish_time_str = publish_time_str;
    }

    public long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_head_img() {
        return author_head_img;
    }

    public void setAuthor_head_img(String author_head_img) {
        this.author_head_img = author_head_img;
    }

    public int getUp_count() {
        return up_count;
    }

    public void setUp_count(int up_count) {
        this.up_count = up_count;
    }

    public int getMessage_state() {
        return message_state;
    }

    public void setMessage_state(int message_state) {
        this.message_state = message_state;
    }

    public List<ImageEntity> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        return attachments;
    }

    public void setAttachments(List<ImageEntity> attachments) {
        this.attachments = attachments;
    }

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }
}
