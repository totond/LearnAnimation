package scut.com.learnanimation;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_activty_Tween,btn_activty_Interpolators,btn_activty_Frame, btn_activty_Property;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_activty_Tween = (Button) findViewById(R.id.btn_activty_Tween);
        btn_activty_Interpolators = (Button) findViewById(R.id.btn_activty_Interpolators);
        btn_activty_Frame = (Button) findViewById(R.id.btn_activty_Frame);
        btn_activty_Property = (Button) findViewById(R.id.btn_activty_Property);

        btn_activty_Tween.setOnClickListener(this);
        btn_activty_Interpolators.setOnClickListener(this);
        btn_activty_Frame.setOnClickListener(this);
        btn_activty_Property.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activty_Tween:
                Intent intentTween = new Intent(MainActivity.this,TweenActivity.class);
                startActivity(intentTween);
                break;
            case R.id.btn_activty_Interpolators:
                Intent intentInter = new Intent(MainActivity.this,InterpolatorsActivity.class);
                startActivity(intentInter);
                break;
            case R.id.btn_activty_Frame:
                Intent intentFrame = new Intent(MainActivity.this,FrameActivity.class);
                startActivity(intentFrame);
                break;
            case R.id.btn_activty_Property:
                Intent intentProperty = new Intent(MainActivity.this,PropertyActivity.class);
                startActivity(intentProperty);
                break;
        }
    }
}
