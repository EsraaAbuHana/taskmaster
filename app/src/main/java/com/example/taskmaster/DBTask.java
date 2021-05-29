package com.example.taskmaster;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class DBTask extends RoomDatabase {
    public abstract DAOsTask dAOsTask();
    private static volatile DBTask dbTask;
    public static synchronized DBTask getInstance(Context context){
        if(dbTask==null){
           dbTask = Room.databaseBuilder(context.getApplicationContext(),DBTask.class,"dataBaseTask").allowMainThreadQueries().build();
        }
        return dbTask;

    }

}