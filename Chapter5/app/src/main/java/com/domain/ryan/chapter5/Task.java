package com.domain.ryan.chapter5;

import java.util.Date;

/**
 * Created by user on 2/13/18.
 */

public class Task {
    private int ID;
    private String Message;
    private Date Deadline;
    private Boolean Complete;
    private Date Date_Complete;

    public int getID() {
        return ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public void setDeadline(Date deadline) {
        Deadline = deadline;
    }

    public Boolean getComplete() {
        return Complete;
    }

    public void setComplete(Boolean complete) {
        Complete = complete;
    }

    public Task(String m, Date d) {
        this.Message = m;
        this.Deadline = d;
        this.Complete = false;
    }

    public Task(int ID, String m, Date d, int c) {
        this.ID = ID;
        this.Message = m;
        this.Deadline = d;
        if(c == 1)
        {
            this.Complete = true;
        }
        else{
            this.Complete = false;
        }
    }

    public Task(String m, Date d, int c) {
        this.Message = m;
        this.Deadline = d;
        this.Complete = false;
        if(c == 1)
        {
            this.Complete = true;
        }
    }

    public void setCompleted(){
        this.Date_Complete = new Date();
    }


}
