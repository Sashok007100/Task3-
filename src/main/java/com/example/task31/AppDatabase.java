package com.example.task31;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.myapplication.model.Student;
import com.example.myapplication.modelinterface.StudentDao;
import com.example.myapplication.modelinterface.Transactor;

@Database(entities = {Student.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();
    public abstract Transactor getTeansactor();
    private static AppDatabase db;

    public static AppDatabase getDatabace(Context context)
    {
        if(db==null)
        {
            db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "databace").build();
        }
        return db;
    }
}
