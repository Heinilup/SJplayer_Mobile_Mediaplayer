package sjplayer.zousj.zou.sj_player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayerActivity extends BaseActivity {
	/**
	 * 更新进度
	 */
	private static final int PROGRESS = 1;
	private VideoView videoView;
	private Uri uri;
    private TextView tv_title;
	private ImageView iv_battery;
	private TextView tv_system_time;
	private Button btn_voice;
	private SeekBar seekbar_voice;
	private Button switch_player;

	private TextView tv_current_time;
	private SeekBar seekbar_video;
	private TextView tv_duration;

	private Button btn_exit;
	private Button btn_back;
	private Button btn_play_pause;
	private Button btn_forward;
	private Button btn_fullscreen;

	/**
	 * 判断是否是播放状态
	 * true：播放状态
	 * false：暂停状态
	 */
	private boolean isPlaying = false;
	private utils utils;
	/**
	 * 判断当前Activity是否被销毁
	 * true:销毁
	 * false:没有被销毁
	 */
	private boolean isDestoryed = false;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what){
				case PROGRESS:
					//得到视频的当前进度
					int currentPosition =   videoView.getCurrentPosition();
					tv_current_time.setText(utils.stringForTime(currentPosition));
					//2.seekBar进度更新
					seekbar_video.setProgress(PROGRESS);
					//消息死循环
					if(!isDestoryed) {
						handler.sendEmptyMessageDelayed(PROGRESS, 1000);
					}else {

					}
					break;
				default:
					break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitleBar(View.GONE);
		setRightButton(View.GONE);
		utils = new utils();
		initView();

	//得到播放地址
	uri = getIntent().getData();
	videoView.setVideoURI(uri);

		setListener();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		isDestoryed = true;
	}

	private void setListener() {
		//设置拖动视频监听
		seekbar_video.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			/**
			 * 手指离开seekBar空间的时候回调这个方法
			 * 拖动的时候回调progr
			 * 当SeekBar状态发生变化的时候回调这个方法
			 * @param seekBar
			 * @param progress
			 * @param fromUser
			 */
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(fromUser)
					//拖动到具体的视频位置
					videoView.seekTo(progress);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		//设置按钮监听
		btn_play_pause.setOnClickListener(new View.OnClickListener() {



			@Override
			public void onClick(View v) {
				switch (v.getId()){
					case R.id.btn_play_pause://播放和暂停切换

						if(isPlaying){
							//暂停
							videoView.pause();
							//当按暂停之后按钮状态设置为播放
							btn_play_pause.setBackgroundResource(R.drawable.btn_play_selector);
						}else {
							//播放
							videoView.start();
							//当按播放之后按钮状态设置为暂停
							btn_play_pause.setBackgroundResource(R.drawable.btn_pause_selector);
						}
						isPlaying = !isPlaying;
						break;
					default:
						break;
				}
			}
		});
		//监听是否准备就绪
		videoView.setOnPreparedListener(new OnPreparedListener(){

            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
				//开始播放视频
                videoView.start();
				isPlaying = true;
				//得到视频长度
				int duration = videoView.getDuration();
				tv_duration.setText(utils.stringForTime(duration));
				//1.关联SeekBar
				seekbar_video.setMax(duration);

				//开始更新进度
				handler.sendEmptyMessage(PROGRESS);
            }

        });
		//调用系统Media组件
//		videoView.setMediaController(new MediaController(this));
	}
	/**
	 * 初始化View
	 */
	protected void initView() {
		videoView = (VideoView) findViewById(R.id.ac_video_play);
		tv_title = (TextView) findViewById(R.id.tv_title);
		iv_battery = (ImageView) findViewById(R.id.iv_battery);
		tv_system_time = (TextView) findViewById(R.id.tv_system_time);
		btn_voice = (Button) findViewById(R.id.btn_voice);
		seekbar_voice = (SeekBar) findViewById(R.id.seekbar_voice);
		switch_player = (Button) findViewById(R.id.switch_player);
		tv_current_time = (TextView) findViewById(R.id.tv_current_time);
		seekbar_video = (SeekBar) findViewById(R.id.seekbar_video);
		tv_duration = (TextView) findViewById(R.id.tv_duration);
		btn_exit = (Button) findViewById(R.id.btn_exit);
		btn_back = (Button) findViewById(R.id.btn_back);
		btn_play_pause = (Button) findViewById(R.id.btn_play_pause);
		btn_forward = (Button) findViewById(R.id.btn_forward);
		btn_fullscreen = (Button) findViewById(R.id.btn_fullscreen);
	}

	@Override
	public View setContentView() {
    return View.inflate(this, R.layout.activity_videoplay, null);
	}
	@Override
	public void rightButtonClick(){
		Toast.makeText(this, getString(R.string.right_button_click), Toast.LENGTH_SHORT).show();
	}
	@Override
	public void leftButtonClick(){
		finish();
	}

}
