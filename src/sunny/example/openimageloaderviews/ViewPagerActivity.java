package sunny.example.openimageloaderviews;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.support.v4.view.ViewPager;
public class ViewPagerActivity extends Activity{
	
	String[] mImageUrls = ImageUrlConstants.imgUrl;
	ImageLoader mImageLoader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.viewpager);
		
		initImageLoader(this);
		mImageLoader = ImageLoader.getInstance();
		ViewPager pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(new ViewPagerAdapter(this,mImageUrls,mImageLoader));
		
        pager.setCurrentItem(0);
	}
	
public static void initImageLoader(Context context){
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
		.build();
		
		ImageLoader.getInstance().init(config);
	}
	
}
