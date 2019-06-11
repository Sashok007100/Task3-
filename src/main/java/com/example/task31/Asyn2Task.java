package com.example.task31;

import android.os.AsyncTask;

import com.example.myapplication.model.Student;

import java.util.List;

public class Asyn2Task extends AsyncTask<Main2Activity,Void, Void> {

    @Override
    protected Void doInBackground(Main2Activity... splasches) {

        Main2Activity m=splasches[0];
        AppDatabase db= AppDatabase.getDatabace(m);

        switch (m.getEvent_Diskription())
        {
            case 1:
                List<Student> list=db.getStudentDao().getAllStudents();
                m.finisher(list);
                break;

            case 2:
                Student student=new Student();
                student.setFIO(AsynTask.getRandom_name()[(int)(Math.random()*5)]);
                student.setDate(new java.sql.Date(System.currentTimeMillis()));
                db.getStudentDao().insertALL(student);
                break;

            case 3:
                db.getTeansactor().ChangeLast();
                break;
        }
        return null;
    }
}
