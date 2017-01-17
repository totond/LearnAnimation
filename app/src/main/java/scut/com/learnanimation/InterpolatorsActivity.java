package scut.com.learnanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import static android.R.anim.accelerate_decelerate_interpolator;
import static android.R.anim.accelerate_interpolator;
import static android.R.anim.anticipate_interpolator;
import static android.R.anim.anticipate_overshoot_interpolator;
import static android.R.anim.bounce_interpolator;
import static android.R.anim.cycle_interpolator;
import static android.R.anim.decelerate_interpolator;
import static android.R.anim.linear_interpolator;
import static android.R.anim.overshoot_interpolator;

public class InterpolatorsActivity extends AppCompatActivity {
    private Button btn_start;
    private TextView tv_AccelerateDecelerate,tv_Accelerate,tv_Anticipate,tv_AnticipateOvershoot,tv_Bounce,
    tv_Cycle,tv_Decelerate,tv_Linear,tv_Overshoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolators);
        btn_start = (Button) findViewById(R.id.btn_start);
        tv_AccelerateDecelerate = (TextView) findViewById(R.id.tv_AccelerateDecelerate);
        tv_Accelerate = (TextView) findViewById(R.id.tv_Accelerate);
        tv_Anticipate = (TextView) findViewById(R.id.tv_Anticipate);
        tv_AnticipateOvershoot = (TextView) findViewById(R.id.tv_AnticipateOvershoot);
        tv_Bounce = (TextView) findViewById(R.id.tv_Bounce);
        tv_Cycle = (TextView) findViewById(R.id.tv_Cycle);
        tv_Decelerate = (TextView) findViewById(R.id.tv_Decelerate);
        tv_Linear = (TextView) findViewById(R.id.tv_Linear);
        tv_Overshoot = (TextView) findViewById(R.id.tv_Overshoot);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation1.setDuration(3000);
                animation1.setFillAfter(true);
                animation1.setInterpolator(InterpolatorsActivity.this,accelerate_decelerate_interpolator);
                tv_AccelerateDecelerate.startAnimation(animation1);

                Animation animation2 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation2.setDuration(3000);
                animation2.setFillAfter(true);
                animation2.setInterpolator(InterpolatorsActivity.this,accelerate_interpolator);
                tv_Accelerate.startAnimation(animation2);

                Animation animation3 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation3.setDuration(3000);
                animation3.setFillAfter(true);
                animation3.setInterpolator(InterpolatorsActivity.this,anticipate_interpolator);
                tv_Anticipate.startAnimation(animation3);

                Animation animation4 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation4.setDuration(3000);
                animation4.setFillAfter(true);
                animation4.setInterpolator(InterpolatorsActivity.this,anticipate_overshoot_interpolator);
                tv_AnticipateOvershoot.startAnimation(animation4);

                Animation animation5 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation5.setDuration(3000);
                animation5.setFillAfter(true);
                animation5.setInterpolator(InterpolatorsActivity.this,bounce_interpolator);
                tv_Bounce.startAnimation(animation5);

                Animation animation6 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation6.setDuration(3000);
                animation6.setFillAfter(true);
                animation6.setInterpolator(InterpolatorsActivity.this,cycle_interpolator);
                tv_Cycle.startAnimation(animation6);

                Animation animation7 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation7.setDuration(3000);
                animation7.setFillAfter(true);
                animation7.setInterpolator(InterpolatorsActivity.this,decelerate_interpolator);
                tv_Decelerate.startAnimation(animation7);

                Animation animation8 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation8.setDuration(3000);
                animation8.setFillAfter(true);
                animation8.setInterpolator(InterpolatorsActivity.this,linear_interpolator);
                tv_Linear.startAnimation(animation8);

                Animation animation9 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,
                        Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0);
                animation9.setDuration(3000);
                animation9.setFillAfter(true);
                animation9.setInterpolator(InterpolatorsActivity.this,overshoot_interpolator);

                tv_Overshoot.startAnimation(animation9);


        }
    });



}
}

