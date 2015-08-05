package sjplayer.zousj.zou.sj_player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayerActivity extends BaseActivity {
	
    private VideoView videoView;
	private Uri uri;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRightButton(View.GONE);
		videoView = (VideoView) findViewById(R.id.ac_video);
	//�õ����ŵ�ַ
	uri = getIntent().getData();
	videoView.setVideoURI(uri);
	//�����Ƿ�׼���ú���-��ʼ����
	videoView.setOnPreparedListener(new OnPreparedListener(){

		@Override
		public void onPrepared(MediaPlayer mp) {
			// TODO Auto-generated method stub
			videoView.start();
		}
		
	});
	}
	@Override
	public View setContentView() {
    return View.inflate(this, R.layout.activity_videoplay, null);
	}
	@Override
	public void rightButtonClick(){
		Toast.makeText(this, "�ұߵ�������ɹ�", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void leftButtonClick(){
		finish();
	}

}