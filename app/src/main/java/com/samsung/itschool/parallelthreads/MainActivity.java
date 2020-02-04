package com.samsung.itschool.parallelthreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number;
    Button startThread;
    TextView res;
    Long id = 0l;
    Integer a = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.number);
        startThread = findViewById(R.id.threads);
        res = findViewById(R.id.result);
    }

    public void startThreads(View v){
        MyThread myThread = new MyThread();
        myThread.start();
        synchronized (number) {
            a = Integer.parseInt(number.getText().toString());
            if(a - 80 > 0)
                a -= 80;
            number.setText(Integer.toString(a));
        }
//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        res.append("Thread " + Long.toString(id)
                + ": " + Integer.toString(a)+"\n");
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (number) {
                a = Integer.parseInt(number.getText().toString());
                if(a - 90 > 0)
                    a -= 90;
                number.setText(Integer.toString(a));
                id = getId();
            }

        }
    }
}
