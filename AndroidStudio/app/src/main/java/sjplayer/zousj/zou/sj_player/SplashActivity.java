package sjplayer.zousj.zou.sj_player;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;


public class SplashActivity extends Activity {
    private boolean isEnterMained = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isEnterMained = false;
        //延迟2秒进入主页面
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                enterMain();
            }
        }, 2000);

    }

    protected void enterMain(){

        if (!isEnterMained) {
            isEnterMained = true;
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }



    //点击打断延迟，提前进入主页面
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        enterMain();
        return super.onTouchEvent(event);
    }

}
