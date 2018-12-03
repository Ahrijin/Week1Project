package com.example.jinyuanyuan1203;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.jinyuanyuan1203.dao.MyDao;
import com.example.jinyuanyuan1203.weight.HeaderView;
import com.example.jinyuanyuan1203.weight.MyFloatLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] list = new String[]{"考拉三周年人气热销榜", "电动牙刷", "尤妮佳", "豆豆鞋", "沐浴露", "日东红茶", "榴莲", "电动牙刷", "尤妮佳", "雅诗兰黛", "豆豆鞋"};
    private ArrayList<String> historylist = new ArrayList<>();
    private ArrayList<String> lists = new ArrayList<>();
    private HeaderView header_view;
    private TextView dele;
    private MyFloatLayout my_history_view;
    private MyFloatLayout my_view;
    private MyDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new MyDao(MainActivity.this);
        //初始化数据
        initData();
        //查找控件
        initView();
    }

    private void initData() {
        for (int i = 0; i < list.length; i++) {
            lists.add(list[i]);//搜索发现
        }
    }

    private void initView() {
        header_view = (HeaderView) findViewById(R.id.header_view);
        header_view.setOnClickListener(this);
        dele = (TextView) findViewById(R.id.dele);
        dele.setOnClickListener(this);
        my_history_view = (MyFloatLayout) findViewById(R.id.my_history_view);
        my_view = (MyFloatLayout) findViewById(R.id.my_view);
        my_view.setData(lists);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quxiao:
                my_history_view.removeAllViews();//移除控件
                //先获取搜索框中的值
                String seachData = header_view.getSeachData().trim();
                //添加到dao层
                dao.addData(seachData);
                historylist.add(seachData);
                my_history_view.setData(historylist);
                break;
            case R.id.dele:
                my_history_view.removeAllViews();//移除控件
                dao.del();//dao层删除
                historylist.clear();//清空集合数据
                break;
        }
    }
}
