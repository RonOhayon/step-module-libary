package com.example.stepsmodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.example.stepsmodule.fregment_Steps.adapter.StepAdapter;
import com.example.stepsmodule.fregment_Steps.StepFour;
import com.example.stepsmodule.fregment_Steps.StepOne;
import com.example.stepsmodule.fregment_Steps.StepThree;
import com.example.stepsmodule.fregment_Steps.StepTwo;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class StepsActivity extends AppCompatActivity {
    ViewPager viewPager;
    PageIndicatorView pageIndicatorView;
    Button BTN_Start;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        initView();
        fragments = new ArrayList<Fragment>();
        setList();
        setUpSteps();
    }
    private void setUpSteps() {
        StepAdapter stepAdapter = new StepAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(stepAdapter);
    }
    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
        BTN_Start = findViewById(R.id.BTN_Start);
        pageIndicatorView.setCount(4); // specify total count of indicators
        pageIndicatorView.setSelection(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updatePageIndicatorColors(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }
    private void setList(){
        fragments.add(new StepOne());
        fragments.add(new StepTwo());
        fragments.add(new StepThree());
        fragments.add(new StepFour());
    }
    private void updatePageIndicatorColors(int position) {
        int selectedColor;
        if(position+1==1){
             selectedColor = getResources().getColor(R.color.one);
        }
        else if(position+1 == 2){
             selectedColor = getResources().getColor(R.color.two);
        }
        else if(position+1 == 3){
            selectedColor = getResources().getColor(R.color.three);
        }
        else{
            selectedColor = getResources().getColor(R.color.four);
        }

        int unselectedColor = Color.GRAY;

        pageIndicatorView.setSelectedColor(selectedColor);
        pageIndicatorView.setUnselectedColor(unselectedColor);
    }



}