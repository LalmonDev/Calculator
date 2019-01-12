package com.example.mycalculator;


/*
    该类为自定义适配器类，需要继承BaseAdapter类
    主要是重写几个方法，如getView等
 */

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CalculatorAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mStrs=null;

//    自定义适配器构造函数   context为 上下文  strs为 数据源
    public CalculatorAdapter(Context context,String[] strs)
    {
        this.mContext=context;
        this.mStrs=strs;
    }

    @Override
//    返回已定义数据源总数量
    public int getCount()
    {
        return mStrs.length;
    }

    @Override
//    告诉适配器取得目前容器中的数据对象
    public Object getItem(int position)
    {
        return mStrs[position];
    }

    @Override
//    告诉适配器取得目前容器中的数据ID
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
//        利用View的inflate方法实例化一个View出来
        View view=View.inflate(mContext, R.layout.item_button,null);
//        通过view找到按钮对应的控件TextView
        TextView textView=view.findViewById(R.id.text_button);
//        根据position获取按钮应该设置的内容，并设置
        String str=mStrs[position];
        textView.setText(str);
//        此处主要是为了给Back和CE两个按钮单独的按下效果，根据str的值来判断
        if(str.equals("Back"))
        {
            textView.setBackgroundResource(R.drawable.selector_button_backspace);
            textView.setTextColor(Color.WHITE);
        }
        else if(str.equals("CE"))
        {
            textView.setBackgroundResource(R.drawable.selector_button_backspace);
            textView.setTextColor(Color.WHITE);
        }
        return view;
    }
}
