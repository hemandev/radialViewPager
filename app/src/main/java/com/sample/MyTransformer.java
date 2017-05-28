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
//         TextView tv = (TextView) page.findViewById(R.id.text);
//         float prev_pos;
//         Log.d("POS2", tv.getText().toString() + "  " + String.valueOf(position) + " Y: " + String.valueOf(page.getY()));
//         if (position <=  .10f){
//             page.setScaleY(.7f);
//             page.setScaleX(.7f);
//             page.setTranslationY(150f);
//         }
//         else  if (position >= .60f){
//             page.setScaleY(.7f);
//             page.setScaleX(.7f);
//             page.setTranslationY(150f);
//         }
//         else{

//             page.setScaleY(1f);
//             page.setScaleX(1f);
//             page.setTranslationY(0f);
//         }

        float left = -0.3333f;
        if(position < left) {
            page.setTranslationY(0);
            return;
        }
        final float bottomWidth = 250;
        float positivePosition = (position - left) / (1.3333f), x, c = 50;
        if(positivePosition <= 0.5f) {
            x = positivePosition * bottomWidth;
        } else {
            x = (1 - positivePosition ) * bottomWidth;
        }
        float fourA = 100f;
        float y = c - (float)Math.pow(x, 2) / fourA ;
        page.setTranslationY(y - page.getTop());

        // Change the scale of the page for positivePosition [.30, .70]
        if(positivePosition  >= 0.30 && positivePosition <= 0.70) {
            double actualScalingFactor = 0, maxScaleFactor = 0.25;
            if(positivePosition >= 0.50) {
                actualScalingFactor = ((0.70 - positivePosition)/.2) * maxScaleFactor;
            } else {
                actualScalingFactor = maxScaleFactor - ((0.50 - positivePosition)/.2) * maxScaleFactor;
            }
            page.setScaleX(1 + (float)actualScalingFactor);
            page.setScaleY(1 + (float)actualScalingFactor);
        } else {
            page.setScaleX(1);
            page.setScaleY(1);
        }

    }
}
