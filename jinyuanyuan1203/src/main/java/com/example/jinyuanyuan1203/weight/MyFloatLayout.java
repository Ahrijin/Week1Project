package com.example.jinyuanyuan1203.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jinyuanyuan1203.R;

import java.util.List;

public class MyFloatLayout extends LinearLayout{
    private int mScreenWidth;
    private String mColor;

    public MyFloatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取屏幕的宽度
        DisplayMetrics metrics = new DisplayMetrics();
        mScreenWidth = metrics.widthPixels;
        setOrientation(VERTICAL);
       /* TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ColorDemo);
        if (typedArray != null) {
            mColor = (String) typedArray.getText(R.styleable.ColorDemo_textColor);
        }*/

    }

    public void setData(List<String> data) {
        //初始化LinearLayout
        LinearLayout linearLayout = getLin();
        //for循环
        for (int i = 0; i < data.size(); i++) {
            String temp = data.get(i);//获取数据
            int numWidth = 0;
            //得到有多少子控件
            int childCount = linearLayout.getChildCount();
            for (int j = 0; j < childCount; j++) {
                TextView textView = (TextView) linearLayout.getChildAt(j);
                LayoutParams params = (LayoutParams) textView.getLayoutParams();
                int leftMargin = params.leftMargin;
                textView.measure(textView.getMeasuredWidth(), textView.getMeasuredHeight());
                numWidth += textView.getMeasuredWidth() + leftMargin;
            }

            TextView text = getText();
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            params.leftMargin = 15;
            params.topMargin = 10;
            text.setLayoutParams(params);
            text.setText(temp);
            text.measure(getMeasuredWidth(),getMeasuredHeight());
            int textWidth = text.getMeasuredWidth() + text.getPaddingRight() + text.getPaddingLeft();

            //判断文字内容是否超过屏幕宽度
            if(mScreenWidth >= numWidth+textWidth){
                linearLayout.addView(text);
            }else {
                LinearLayout lin = getLin();
                linearLayout.addView(text);
            }
        }
    }

    public void removeChildView(){
        removeAllViews();//清除
    }
    public LinearLayout getLin() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        this.addView(linearLayout);
        return linearLayout;
    }

    public TextView getText() {
        TextView tv = new TextView(getContext());
        tv.setTextSize(20);
        tv.setTextColor(Color.BLACK);
        tv.setBackgroundResource(R.drawable.text_style);
        tv.setPadding(10, 10, 10, 10);
        return tv;
    }


}
