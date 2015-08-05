package com.zousj.sjplayer;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class SplashActivity extends Activity {
	private boolean isEnterMained = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		isEnterMained = false;
		//等待2秒进入主界面
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
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
	
//点击提前进入主程序
@Override
public boolean onTouchEvent(MotionEvent event) {
	enterMain();
	return super.onTouchEvent(event);
}

}
