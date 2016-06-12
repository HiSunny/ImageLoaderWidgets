package sunny.example.openimageloaderviews;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Gallery;
import java.util.ArrayList;
public class GalleryActivity extends Activity{

	String[] imageUrls = ImageUrlConstants.imgUrl;
	//Context mContext;
	GridViewItem mGridViewItem = null;
	ImageLoader mImageLoader;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gallery);
		
		//mContext = this;
		mImageLoader = ImageLoader.getInstance();
		@SuppressWarnings("deprecation")
		Gallery mGallery = (Gallery)findViewById(R.id.gallery);
		
		ArrayList<GridViewItem> galleryList = new ArrayList<GridViewItem>();
		
		for(int i = 0;i < imageUrls.length;i++){
			mGridViewItem = new GridViewItem(imageUrls[i]);
			galleryList.add(mGridViewItem);
		}
		GalleryAdapter adapter = new GalleryAdapter(this,galleryList,mImageLoader);
		mGallery.setAdapter(adapter);
		
		
		
		initImageLoader(this);
	}
	
	
public static void initImageLoader(Context context){
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
		.build();
		
		ImageLoader.getInstance().init(config);
	}
	
}
