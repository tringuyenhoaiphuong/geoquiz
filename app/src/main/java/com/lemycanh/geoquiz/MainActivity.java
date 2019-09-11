package com.lemycanh.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnTraLoiDung;
    Button mBtnTraLoiSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTraLoiDung  = (Button) findViewById(R.id.traloidung);
        mBtnTraLoiSai   = (Button) findViewById(R.id.traloisai);

        mBtnTraLoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.traloidung, Toast.LENGTH_SHORT).show();
            }
        });


        mBtnTraLoiSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.traloisai, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
