package com.domain.ryan.chapter5;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by user on 2/13/18.
 */

public class Task {
    private int ID;
    private String Message;
    private long Deadline;
    private Boolean Complete;
    private Date Date_Complete;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return ID;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        Message = message;
    }

    /**
     * Gets deadline.
     *
     * @return the deadline
     */
    public Date getDeadline() {
        return new Date(Deadline);
    }

    /**
     * Sets deadline.
     *
     * @param deadline the deadline
     */
    public void setDeadline(Date deadline) {
        Deadline = deadline.getTime();
    }

    /**
     * Gets complete.
     *
     * @return the complete
     */
    public Boolean getComplete() {
        return Complete;
    }

    /**
     * Sets complete.
     *
     * @param complete the complete
     */
    public void setComplete(Boolean complete) {
        Complete = complete;
    }

    /**
     * Instantiates a new Task.
     *
     * @param m the m
     * @param d the d
     */
    public Task(String m, Date d) {
        this.Message = m;
        this.Deadline = d.getTime();
        this.Complete = false;
    }

    /**
     * Instantiates a new Task.
     *
     * @param ID the id
     * @param m  the m
     * @param d  the d
     * @param c  the c
     */
    public Task(int ID, String m, Date d, int c) {
        this.ID = ID;
        this.Message = m;
        this.Deadline = d.getTime();
        if(c == 1)
        {
            this.Complete = true;
        }
        else{
            this.Complete = false;
        }
    }

    /**
     * Instantiates a new Task.
     *
     * @param m the m
     * @param d the d
     * @param c the c
     */
    public Task(String m, Date d, int c) {
        this.Message = m;
        this.Deadline = d.getTime();
        this.Complete = false;
        if(c == 1)
        {
            this.Complete = true;
        }
    }

    /**
     * Set completed.
     */
    public void setCompleted(){
        this.Date_Complete = new Date(Calendar.getInstance().getTimeInMillis());
    }


}
