package com.domain.ryan.chapter5;

/**
 * Created by user on 2/14/18.
 */

public class TaskHolder {
        private Task t;
        private static TaskHolder instance = null;

        protected TaskHolder(){

        }


        public Task getTask() {return t;}

        public void setTask(Task t) {this.t = t;}

        public static TaskHolder getInstance() {
            if(instance == null)
            {
                instance = new TaskHolder();
            }
            return instance;
        }
}
