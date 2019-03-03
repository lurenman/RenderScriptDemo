package com.example.dell.renderscriptdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button btn_hello;
    private Button btn_sketch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        setContentView(R.layout.activity_main);
        initViews();
        initListener();

    }

    private void initViews() {
        btn_hello = (Button) findViewById(R.id.btn_hello);
        btn_sketch = (Button) findViewById(R.id.btn_sketch);
    }

    private void initListener() {
        btn_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HelloRenderScriptActivity.class);
                startActivity(intent);
            }
        });
        btn_sketch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SketchActivity.class);
                startActivity(intent);
            }
        });
    }
}
