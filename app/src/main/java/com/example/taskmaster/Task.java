//package com.example.taskmaster;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//
//@Entity(tableName = "task")
//public class Task {
//    @PrimaryKey(autoGenerate = true)
//    public int taskId;
//    @ColumnInfo(name = "title")
//    private String title;
//    @ColumnInfo(name = "body")
//    private String body;
//    @ColumnInfo(name = "state")
//    private String state;
//public Task(){}
//    public Task(String title, String body, String state) {
//        this.title = title;
//        this.body = body;
//        this.state = state;
//    }
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "taskId=" + taskId +
//                ", title='" + title + '\'' +
//                ", body='" + body + '\'' +
//                ", state='" + state + '\'' +
//                '}';
//    }
//}
