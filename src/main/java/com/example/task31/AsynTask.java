package com.example.task31;

import android.os.AsyncTask;

import com.example.myapplication.model.Student;

import java.sql.Date;

public class AsynTask extends AsyncTask<MainActivity,Void, Void>
{
   private final static String[] random_name={"Васильев Василий Васильевич", "Гудков Анатолий Ильич", "Путин Владимир Владимирович", "Песнячевкская Полина Николаевна", "Коватьев Иван Михайлович"};

    public static String[] getRandom_name() {
        return random_name;
    }

    @Override
    protected Void doInBackground(MainActivity... splasches) {

        MainActivity m=splasches[0];
        AppDatabase db= AppDatabase.getDatabace(m);
        db.getStudentDao().deleteAllStudents();
        Student[] students=new Student[5];
        for(int i=0;i<5;i++)
            students[i]=new Student();
        for(int i=0;i<5;i++)
        {
            students[i].setFIO(random_name[i]);
            students[i].setDate(new Date(System.currentTimeMillis()));

            db.getStudentDao().insertALL(students[i]);
        }
        m.CallMainAndDie();
        return null;
    }

    @Override
    protected void onPostExecute(Void v)
    {

    }
}
