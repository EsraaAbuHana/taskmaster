package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

//interface
@Dao
public interface DAOsTask {
    @Query("SELECT * FROM task")
    List<Task> getAll();
    @Insert
    void insertAll(Task... tasks);
}
