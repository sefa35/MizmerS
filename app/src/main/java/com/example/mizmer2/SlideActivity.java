package com.example.mizmer2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mNextButton, mBackButton;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_activity);

        mSlideViewPager = (ViewPager)findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout)findViewById(R.id.dotsLayout);

        mNextButton = (Button)findViewById(R.id.nextBtn);
        mBackButton = (Button) findViewById(R.id.backBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

    }

    public void addDotsIndicator(int position){

        mDots = new TextView[3];

        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);


        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            //these are for next and back button
            mCurrentPage = position;

            if (position == 0){

                mNextButton.setEnabled(true);
                mBackButton.setEnabled(false);
                mBackButton.setVisibility(View.INVISIBLE);

                mNextButton.setText("İleri");
                mBackButton.setText("");

            }else if (position == mDots.length-1){

                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("SON");
                mBackButton.setText("Geri");

            }else {

                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mNextButton.setText("İleri");
                mBackButton.setText("Geri");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void finishClicked(View view){
        if (mNextButton.getText().toString().equals("SON")){

            Intent goToNDM = new Intent(this,NavigationDrawerMenu.class);
            startActivity(goToNDM);

        }
    }

}
