package sunny.example.openimageloaderviews;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.Window;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		Button listView_btn = (Button)findViewById(R.id.listView);
		listView_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
				startActivity(intent);
				
			}
			
		});
		
		Button gridView_btn = (Button)findViewById(R.id.gridView);
		gridView_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GridViewActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button gallery_btn = (Button)findViewById(R.id.galleryB);
		gallery_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
				startActivity(intent);
			}
			
		});
		
		Button viewPager_btn = (Button)findViewById(R.id.viewPager);
		viewPager_btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ViewPagerActivity.class);
				startActivity(intent);
			}
			
		});
	
	}

	
}
