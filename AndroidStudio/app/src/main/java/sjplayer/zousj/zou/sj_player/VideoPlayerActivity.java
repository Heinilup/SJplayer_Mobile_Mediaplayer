package sjplayer.zousj.zou.sj_player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayerActivity extends BaseActivity {
	
    private VideoView videoView;
	private Uri uri;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitleBar(View.GONE);
		setRightButton(View.GONE);
		videoView = (VideoView) findViewById(R.id.ac_video_play);
	//得到播放地址
	uri = getIntent().getData();
	videoView.setVideoURI(uri);
	//监听是否准备好好了-开始播放
	videoView.setOnPreparedListener(new OnPreparedListener(){

		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			videoView.start();
		}
		
	});
		//添系统集成加控制栏
		videoView.setMediaController(new MediaController(this));
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
