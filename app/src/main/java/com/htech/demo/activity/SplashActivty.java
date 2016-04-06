package com.htech.demo.activity;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.andoblib.util.AppSetting;
import com.htech.demo.R;
import com.htech.demo.constant.Constants;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class SplashActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView ivWelcomeLogo = (ImageView) findViewById(R.id.ass_ivWelcomeLogo);
        ivWelcomeLogo.setImageResource(R.drawable.ic_app_logo);

        final TextView tvWelComeUserName = (TextView) findViewById(R.id.ass_tvWelComeUserName);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(

                ObjectAnimator.ofFloat(ivWelcomeLogo, "scaleX", 2, 0.7f),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "scaleY", 2, 0.7f)

        );
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                String userLogin = AppSetting.getString(SplashActivty.this, Constants.PREF_NAME, null);
                boolean isLogin = false;
                if (userLogin != null) {
                    tvWelComeUserName.setText("Welcome! " + (userLogin.length() > 0 ? userLogin : AppSetting.getString(SplashActivty.this, Constants.PREF_USRENAME, null)));
                    isLogin = true;
                } else
                    tvWelComeUserName.setText("Welcome! ");


                callLoginScreen(isLogin);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.setDuration(1000).start();



      /*  ObjectAnimator.ofFloat(ivWelcomeLogo, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "rotation", 0, -90),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "translationX", 0, 90),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "translationY", 0, 90),
                ObjectAnimator.ofFloat(ivWelcomeLogo, "alpha", 1, 0.25f, 1)*/

    }

    private void callLoginScreen(final boolean isLogin) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!isLogin)
                            startActivity(new Intent(SplashActivty.this, LoginActivity.class));
                        else
//                            startActivity(new Intent(SplashScreen.this, CustomerDetailPageActivity.class));
                            startActivity(new Intent(SplashActivty.this, HomeActivity.class));
                        finish();
                    }
                });
            }
        }).start();
    }


}
