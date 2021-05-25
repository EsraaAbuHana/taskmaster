package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

//interface
@Dao
public interface DAOsTask {
    @Query("SELECT * FROM task")
    List<Task> getAll();

//    @Query("SELECT * FROM task WHERE taskId =:taskId")
//    Task findById(int userIds);

    @Insert
    void insertAll(Task task);
    //    @Query("SELECT * FROM task WHERE title LIKE :first AND " +
//            "body LIKE :last LIMIT 1")
//
//
//    @Delete
//    void delete(Task user);

}
