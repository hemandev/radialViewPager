
package com.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MyAdapter myAdapter;
    private Button button;
    private HashMap<Integer, PagerFragment> fragMap;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(0);
        final Integer pos = viewPager.getCurrentItem();
        Log.d("posit", pos.toString());
        viewPager.setClipToPadding(false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setPageMargin(0);
        viewPager.setPageTransformer(false,new MyTransformer());





        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                Log.d("Pos", String.valueOf(position));


            }

            @Override
            public void onPageSelected(int position) {

                Log.d("lll", String.valueOf(position));
                View v = myAdapter.getRegisteredFragment(viewPager.getCurrentItem()).getView();
                //Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);
                //v.startAnimation(animation);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.scrollTo(36, 36);
            }
        });
    }


    public class MyAdapter extends FragmentStatePagerAdapter {

        SparseArray<Fragment> registeredFragments = new SparseArray<>();



        public MyAdapter(FragmentManager manager) {

            super(manager);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            registeredFragments.put(position, fragment);
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            registeredFragments.remove(position);
            super.destroyItem(container, position, object);
        }

        public Fragment getRegisteredFragment(int position) {
            return registeredFragments.get(position);
        }


        @Override
        public float getPageWidth(int position) {
            return 1.0f / 3;
        }

        @Override
        public Fragment getItem(int position) {
            return PagerFragment.newInstance(position);


        }


        @Override
        public int getCount() {
            return 15;
        }
    }


}
