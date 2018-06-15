package com.example.examtest.web;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "travel_list")
public class ListData<L> {
    @Id
    private Integer list_id;
    private String list_title;
    private String list_content;
    private String occ_time;
    private String start_time;
    private String end_time;
    private String view_count;
    private String point;
    private String password;
    private String user_name;
    private String country;
}

