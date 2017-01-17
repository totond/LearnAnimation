package scut.com.learnanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {
    private Button btn_startFrame,btn_stopFrame;
    private ImageView iv;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        iv = (ImageView) findViewById(R.id.iv);
        btn_startFrame = (Button) findViewById(R.id.btn_startFrame);
        btn_stopFrame = (Button) findViewById(R.id.btn_stopFrame);

        iv.setImageResource(R.drawable.knight_attack);
        //获取资源
//        animationDrawable = new AnimationDrawable();
//        for (int i = 0; i <= 25; i++) {
//            int id = getResources().getIdentifier("a" + i, "drawable", getPackageName());
//            Drawable drawable = getResources().getDrawable(id);
//            animationDrawable.addFrame(drawable, 100);
//        }



        //开始动画
        btn_startFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationDrawable = (AnimationDrawable) iv.getDrawable();
//                animationDrawable.setOneShot(false);
//                iv.setImageDrawable(animationDrawable);
                //在动画start()之前要先stop()，不然在第一次动画之后会停在最后一帧，这样动画就只会触发一次
                animationDrawable.stop();
                animationDrawable.start();
            }
        });

        //停止动画
        btn_stopFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationDrawable = (AnimationDrawable) iv.getDrawable();
//                animationDrawable.setOneShot(true);
//                iv.setImageDrawable(animationDrawable);
                animationDrawable.stop();
            }
        });


    }
}
