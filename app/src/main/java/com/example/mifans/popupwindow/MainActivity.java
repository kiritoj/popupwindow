package com.example.mifans.popupwindow;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    PopupWindow popupWindow;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.pop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpopupWindow();
            }
        });
    }
    private void showpopupWindow(){
        View contentview = LayoutInflater.from(MainActivity.this).inflate(R.layout.popupwindow,null);
        View rootview = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main,null);
        popupWindow = new PopupWindow(contentview, (int) (getResources().getDisplayMetrics().widthPixels*0.95),ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView1 = contentview.findViewById(R.id.button1);
        TextView textView2 = contentview.findViewById(R.id.button2);
        TextView textView3 = contentview.findViewById(R.id.button3);
        //设置点击事件
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.popupwindow);
        //弹窗消失时吧透明度改回来
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp1 = getWindow().getAttributes();
                lp1.alpha = 1f;
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp1);
            }
        });
        //弹窗出现时透明度降低，给人一种变暗的感觉
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.4f; //设置透明度
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
        popupWindow.showAtLocation(rootview,Gravity.BOTTOM,0,0);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(MainActivity.this, "pick button1", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "pick button2", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            case R.id.button3:
                Toast.makeText(MainActivity.this, "pick button3", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
                break;
            default:
                break;
        }
    }
}
