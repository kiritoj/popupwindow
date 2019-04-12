package com.example.mifans.popupwindow;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mifans.popupwindow.Fragment.EatFragment;
import com.example.mifans.popupwindow.Fragment.GameFragment;
import com.example.mifans.popupwindow.Fragment.SheepFragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ViewPager viewPager;
    RadioGroup radioGroup;
    ViewPagerAdapter adapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = findViewById(R.id.viewpager);
        radioGroup = findViewById(R.id.radio_group);
        EatFragment eatFragment = new EatFragment();
        SheepFragment sheepFragment = new SheepFragment();
        GameFragment gameFragment = new GameFragment();
        fragmentList.add(eatFragment);
        fragmentList.add(sheepFragment);
        fragmentList.add(gameFragment);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        radioGroup.check(R.id.r_button_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.r_button_2);
                        break;
                    case 2:
                        radioGroup.check(R.id.r_button_3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.r_button_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.r_button_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.r_button_3:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
