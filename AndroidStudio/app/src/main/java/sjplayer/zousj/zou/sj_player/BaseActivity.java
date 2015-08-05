package sjplayer.zousj.zou.sj_player;
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
    private Button btn_left;
    private TextView tv_title;
    private Button btn_right;
    private LinearLayout ll_child_content;
    private FrameLayout title_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE); 载app_theme里面注释了 <item name="android:windowNoTitle">true</item>
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
        title_bar = (FrameLayout) findViewById(R.id.title_bar);
        //添加子类布局文件
        View child = setContentView();
        if (child != null) {
            //导入父类包文件
            LayoutParams params = new LayoutParams(-1, -1);
            ll_child_content.addView(child , params );
        }

    }
    /**
     * 这个方法由孩子实现
     * @return
     */
    public abstract View setContentView();
    /**
     * 设置左边按钮状态
     * @param visibility
     */
    public void setLeftButton(int visibility){
        btn_left.setVisibility(visibility);
    }
    /**
     * 设置标题
     * @param title 要设置的标题内容
     */
    public void setTitle(String title) {
        tv_title.setText(title);
    }

    /**
     * 设置右边按钮状态
     * @param visibility
     */
    public void setRightButton(int visibility){
        btn_right.setVisibility(visibility);
    }

    /**
     * 设置标题栏是否隐藏
     * @param visibility
     */
    public void setTitleBar(int visibility){
      title_bar.setVisibility(visibility);
    }
    public void rightButtonClick() {

    }

    public void leftButtonClick() {

    }

}
