package com.example.junhee.cordinatorlayoutex;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements OnTouchItemListener, View.OnClickListener {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(Arrays.asList(Cheeses.sCheeseStrings), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void itemTouched(String data) {
        tv.setText(data);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv:
                tv.setBackgroundColor(Color.LTGRAY);

            break;
        }
    }
}
