package com.aszqsc.friendsr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private int id;
    //avatar
    private String name;
    private int age;
    private boolean male;

    private int ava_id; //if have id in drawable
    private String ava_name;// if dont have id, get image from storage camera captured

    private String description;

    private List<VoteUser> listVote;

    public User() {
        id=-1;
        listVote=new ArrayList<>();
    }

    public User(int id, String name, int age, boolean male, int ava_id, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.male = male;
        this.ava_id = ava_id;
        this.description = description;
        ava_name=null;
        listVote=new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public List<VoteUser> getListVote() {
        return listVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListVote(List<VoteUser> listVote) {
        this.listVote = listVote;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User(int id, String name, int age, boolean male, String ava_name, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.male = male;
        this.ava_name = ava_name;
        this.description = description;
        this.ava_id=-1;
        listVote=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAva_id() {
        return ava_id;
    }

    public void setAva_id(int ava_id) {
        this.ava_id = ava_id;
    }

    public String getAva_name() {
        return ava_name;
    }

    public void setAva_name(String ava_name) {
        this.ava_name = ava_name;
    }
}
