package com.example.jinyuanyuan1203.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinyuanyuan1203.R;

public class HeaderView extends LinearLayout {
    private EditText searchData;
    private TextView quxiao;
    private Context context;

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_view,this);
        searchData = findViewById(R.id.searchData);
        quxiao = findViewById(R.id.quxiao);
        this.context = context;
    }


    public String getSeachData(){
        return searchData.toString();
    }

    public String add(){
        Toast.makeText(context,"插入成功",Toast.LENGTH_LONG).show();
        return quxiao.toString();
    }



}
