package com.aszqsc.friendsr;

import java.io.Serializable;

public class VoteUser implements Serializable {
    private int userid;
    private  int vote;

    public VoteUser() {
    }

    public int getVote() {
        return vote;
    }

    public VoteUser(int userid, int vote) {
        this.userid = userid;
        this.vote = vote;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
