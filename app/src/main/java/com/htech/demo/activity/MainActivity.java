package com.htech.demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.andoblib.util.AppSetting;
import com.htech.demo.R;
import com.htech.demo.adapter.SimpleTabAdapter;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    ViewPager pager;
    SimpleTabAdapter adapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        setAppTheme();
        super.onCreate(savedInstanceState);

        int[] image = {R.drawable.user24, R.drawable.money24,
                R.drawable.ic_book_black_24dp, R.drawable.github_circle};
        int[] color = {ContextCompat.getColor(this, R.color.primary_dark_purple), ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.thirdColor), ContextCompat.getColor(this, R.color.fourthColor)};
        adapter = new SimpleTabAdapter(getSupportFragmentManager());
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        pager = (ViewPager) findViewById(R.id.viewPager);
        /*if you use tablet mode uncomment this*/
        /*RelativeLayout.LayoutParams pagerParams = (RelativeLayout.LayoutParams)pager.getLayoutParams();
        pagerParams.setMargins(BottomNavigationUtils.getActionbarSize(this),pagerParams.topMargin,
                pagerParams.rightMargin,pagerParams.bottomMargin);
        pager.setLayoutParams(pagerParams);*/
        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(false);
            //bottomNavigationView.activateTabletMode();
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));
        }
        pager.setAdapter(adapter);
        bottomNavigationView.setUpWithViewPager(pager, color, image);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            AppSetting.clearPreference(mContext);
        } catch (Exception e) {
            //failure
        }
    }
    private void setAppTheme()
    {
        if (!AppSetting.getString(mContext, "AppliedTheme", "").equals(""))
        {
            if (AppSetting.getString(mContext, "AppliedTheme", "").equals("Green"))
            {
                setTheme(R.style.ThemeApp_Green);
            }
            else if (AppSetting.getString(mContext,"AppliedTheme","").equals("Green_Dark"))
            {
                setTheme(R.style.ThemeApp_Green_Dark);
            }
            else if (AppSetting.getString(mContext,"AppliedTheme","").equals("Purple_Dark"))
            {
                setTheme(R.style.ThemeApp_Purple_Dark);
            }
            else if (AppSetting.getString(mContext,"AppliedTheme","").equals("Purple"))
            {
                setTheme(R.style.ThemeApp_Purple);
            }
        }
        else
        {
            setTheme(R.style.ThemeApp_Purple_Dark);
        }
    }

}

