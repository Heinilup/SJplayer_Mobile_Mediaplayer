package com.zousj.sjplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
	private Button btn_left;
	private TextView tv_title;
	private Button btn_right;
	private LinearLayout ll_child_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE); ��app_theme����ע���� <item name="android:windowNoTitle">true</item>
		setContentView(R.layout.activity_base);
		initView();
		setOnclickListener();
	}

	private void setOnclickListener() {
		btn_left.setOnClickListener(mOnClickListener);
		btn_right.setOnClickListener(mOnClickListener);
		
	}
	OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_left:
				leftButtonClick();
				
				break;
            case R.id.btn_right:
            	rightButtonClick();
				break;

			default:
				break;
			}
			
		}

	};

	private void initView() {
		btn_left = (Button) findViewById(R.id.btn_left);
		tv_title = (TextView) findViewById(R.id.tv_title);
		btn_right = (Button) findViewById(R.id.btn_right);
		ll_child_content = (LinearLayout) findViewById(R.id.ll_child_content);
		//������಼���ļ�
		View child = setContentView();
	    if (child != null) {
	    	//���븸����ļ�
			LayoutParams params = new LayoutParams(-1, -1);
			ll_child_content.addView(child , params );	
		}
		
	}
	/**
	 * ��������ɺ���ʵ��
	 * @return
	 */
	 public abstract View setContentView();
	/**
	 * ������߰�ť״̬
	 * @param zousj
	 */
	public void setLeftButton(int visibility){
		btn_left.setVisibility(visibility);
	}
	/**
	 * ���ñ���
	 * @param title Ҫ���õı�������
	 */
	public void setTitle(String title) {
		tv_title.setText(title);
	}
	
	/**
	 * �����ұ߰�ť״̬
	 * @param zousj
	 */
	public void setRightButton(int visibility){
		btn_right.setVisibility(visibility);
	}
	public void rightButtonClick() {
		// TODO Auto-generated method stub
		
	}

	public void leftButtonClick() {
		// TODO Auto-generated method stub
		
	}

}
