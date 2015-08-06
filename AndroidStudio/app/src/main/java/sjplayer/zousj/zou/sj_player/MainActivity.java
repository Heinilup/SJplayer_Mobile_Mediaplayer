package sjplayer.zousj.zou.sj_player;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.BaseAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;
        import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private GridView gridView;
    private int[] ids = {R.drawable.video,R.drawable.auto, R.drawable.networ, R.drawable.all};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//执行父类
        //隐藏左侧按钮
        setLeftButton(View.GONE);
        //设置主页面标题
        setTitle(getString(R.string.sj_main_title));
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyMainAdapter());
        //
        gridView.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0://视频播放器
                        Intent intent = new Intent(MainActivity.this,VideoLisActivity.class);
                        startActivity(intent);
                        break;
                    case 1://音乐播放器
                        Toast.makeText(getApplicationContext(), "You Click The Right Button", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }

            }

        });

    }

    private class MyMainAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return ids.length;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder holder;
            if(convertView !=null){
                view = convertView;
                holder = (ViewHolder) view.getTag();
            }
            else {
                view= View.inflate(MainActivity.this,R.layout.main_item, null);
                holder = new ViewHolder();//容器
                holder.iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
                //容器和View对应保存起来
                view.setTag(holder);
            }
            holder.iv_icon.setImageResource(ids[position]);
            return view;
        }
        @Override
        public Object getItem(int position) {
            /* TODO Auto-generated method stub */
            return null;
        }

        @Override
        public long getItemId(int position) {
            /* TODO Auto-generated method stub */
            return 0;
        }

    }

    static class ViewHolder{
        ImageView iv_icon;
    }
    @Override
    public void rightButtonClick(){
        Toast.makeText(this,  getString(R.string.right_button_click), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void leftButtonClick(){
        Toast.makeText(this, getString(R.string.clicktopleft), Toast.LENGTH_SHORT).show();

    }
    @Override
    public View setContentView() {
        return View.inflate(this, R.layout.activity_main, null);
    }
}

