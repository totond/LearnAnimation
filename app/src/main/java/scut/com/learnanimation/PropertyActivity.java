package scut.com.learnanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener{
    private RelativeLayout btLayout;
    private Button btn_test,btn_testValue,btn_testObject,btn_testSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        btLayout = (RelativeLayout) findViewById(R.id.activity_property);
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_testValue = (Button) findViewById(R.id.btn_testValue);
        btn_testObject = (Button) findViewById(R.id.btn_testObject);
        btn_testSet = (Button) findViewById(R.id.btn_testSet);

        btLayout.setOnClickListener(this);
        btn_test.setOnClickListener(this);
        btn_testValue.setOnClickListener(this);
        btn_testObject.setOnClickListener(this);
        btn_testSet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_property:
                displayToast("点击了底部的Layout");
                break;
            case R.id.btn_test:
                displayToast("点击了test按钮");
                //用Tween动画做出位移
                Animation translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,0,
                        TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
                        TranslateAnimation.RELATIVE_TO_SELF,0
                        ,TranslateAnimation.RELATIVE_TO_PARENT,0.5f);
//                translateAnimation.setFillEnabled(true);
//                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(5000);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        System.out.println("动画完成");
                        updateParams();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                btn_test.startAnimation(translateAnimation);
                break;
            case R.id.btn_testValue:
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1,5,3,10);

                valueAnimator.setDuration(5000);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        System.out.println(animation.getAnimatedValue().toString());
                        btn_testValue.setText(animation.getAnimatedValue().toString());
                    }
                });
                valueAnimator.start();
                break;

            case R.id.btn_testObject:

//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn_testObject,"scaleX",1,2);
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn_testObject,"RotationX",0,360);
                objectAnimator.setDuration(5000);
                objectAnimator.start();
                break;
            case R.id.btn_testSet:
                float width = btLayout.getWidth()/2;
                float heigth = btLayout.getHeight()/2;
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(btn_testSet,"scaleX",1,2,1);
                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(btn_testSet,"rotation",0,360);
                ObjectAnimator TranslationXAnimator = ObjectAnimator.ofFloat(btn_testSet,"TranslationX",width);
                ObjectAnimator TranslationYAnimator = ObjectAnimator.ofFloat(btn_testSet,"TranslationY",-heigth);
                AnimatorSet animatorSet1 = new AnimatorSet();
                //这三个动画同时执行
                animatorSet1.playTogether(scaleXAnimator,rotationAnimator,TranslationYAnimator);
//                animatorSet1.setDuration(1000);
                AnimatorSet animatorSet2 = new AnimatorSet();
                //先执行完位移动画，再执行同时的三个动画
                animatorSet2.play(TranslationXAnimator).before(animatorSet1);
//                animatorSet2.play(scaleXAnimator).with(rotationAnimator).with(TranslationYAnimator).after(TranslationXAnimator);
                animatorSet2.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        //动画开始时执行
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        //动画结束时执行
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        //动画取消时执行
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        //动画重放时执行
                    }
                });
                animatorSet2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                    }
                });
                animatorSet2.setDuration(3000);
//                animatorSet2.start();
                Animator animator = AnimatorInflater.loadAnimator(PropertyActivity.this,R.animator.animator_set);
                animator.setTarget(btn_testSet);
                animator.start();
                break;
        }
    }

    private void updateParams(){
        int left = btLayout.getWidth()/2;
        int top = btLayout.getHeight()/2;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) btn_test.getLayoutParams();
        params.leftMargin = left;
        params.topMargin = top;
        btn_test.setLayoutParams(params);
    }

    //用于展示Toast
    private void displayToast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
