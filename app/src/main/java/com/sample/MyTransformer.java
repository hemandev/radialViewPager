package com.sample;

import android.animation.Animator;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/** * Created by Hemand on 5/19/2017.
 */

public class MyTransformer implements ViewPager.PageTransformer {


final Float ORG_POS = 0f;


    @Override
    public void transformPage(View page, float position) {



        TextView tv = (TextView) page.findViewById(R.id.text);

        float prev_pos;

        Log.d("POS2", tv.getText().toString() + "  " + String.valueOf(position) + " Y: " + String.valueOf(page.getY()));



        if (position <=  .10f){

            page.setScaleY(.7f);
            page.setScaleX(.7f);

            page.setTranslationY(150f);
        }

        else  if (position >= .60f){

            page.setScaleY(.7f);
            page.setScaleX(.7f);
            page.setTranslationY(150f);
        }

        else{

            page.setScaleY(1f);
            page.setScaleX(1f);
            page.setTranslationY(0f);




        }



    }
}
