package com.zousj.sjplayer;

import com.zousj.sjplayer.video.VideoLisActivity;

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
		super.onCreate(savedInstanceState);//ִ�и���onCreate
		//������ť
		setLeftButton(View.GONE);
        //������ҳ��ı���
		setTitle("SJӰ��");
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new MyMainAdapter());
        //
        gridView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0://��Ƶ������
					Intent intent = new Intent(MainActivity.this,VideoLisActivity.class);
					startActivity(intent); 
					break;
				case 1://��Ƶ������
					Toast.makeText(getApplicationContext(), "���������", Toast.LENGTH_SHORT).show();
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
				holder = new ViewHolder();//����
				holder.iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            //������View��Ӧ��ϵ��������
				view.setTag(holder);
			}
			holder.iv_icon.setImageResource(ids[position]);
				return view;
			}
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}
 	
	    }
	    
	    static class ViewHolder{
	    	ImageView iv_icon;
	    }
		@Override
		public void rightButtonClick(){
			Toast.makeText(this, "�ұߵ�������ɹ�", Toast.LENGTH_SHORT).show();
		}
		@Override
		public void leftButtonClick(){
			Toast.makeText(this, "�󣡵�ɹ�", Toast.LENGTH_SHORT).show();
			
		}
		@Override
		public View setContentView() {
	   return View.inflate(this, R.layout.activity_main, null);
		}
	}

