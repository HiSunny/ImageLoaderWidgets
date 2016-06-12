package sunny.example.openimageloaderviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.GridView;
import java.util.ArrayList;
import android.content.Context;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
public class GridViewActivity extends Activity{
	
	private Context mContext;
	private ImageLoader mImageLoader;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.gridview);
		
		initView();
		initImageLoader(this);
	}
	
	protected void initView(){
		mContext = this;
		mImageLoader = ImageLoader.getInstance();
		GridView mGridView = (GridView)findViewById(R.id.gridView);
		ArrayList<GridViewItem> mArrayList = new ArrayList<GridViewItem>();
		 String[] imgUrls = ImageUrlConstants.imgUrl;
		 GridViewItem mGridViewItem = null;
		 
		 for(int i = 0;i < imgUrls.length;i++){
			 mGridViewItem = new GridViewItem(imgUrls[i]);
			 mArrayList.add(mGridViewItem);
		 }
		 GridViewAdapter gridViewAdapter = new GridViewAdapter(mContext, mArrayList, mImageLoader);
		 mGridView.setAdapter(gridViewAdapter);
	}
	
public static void initImageLoader(Context context){
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
		.build();
		
		ImageLoader.getInstance().init(config);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mImageLoader!=null) {
			mImageLoader.clearMemoryCache();
			mImageLoader.clearDiscCache();
  }
}
}
