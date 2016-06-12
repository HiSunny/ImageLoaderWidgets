package sunny.example.openimageloaderviews;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import java.util.ArrayList;

import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ListViewActivity extends Activity{

	private ListView mListView;
	private ImageLoader mImageLoader;
	private Context mContext;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listview);
		
		initView();
		initImageLoader(this);
	}
	public void initView(){
		mContext = this;
		mImageLoader = ImageLoader.getInstance();
		// ImageSize mImageSize = new ImageSize(50, 50);  
		mListView = (ListView)findViewById(R.id.listView);
		ArrayList<ListViewItem> arrayList = new ArrayList<ListViewItem>();
		String[] imageUrl = ImageUrlConstants.imgUrl;
		ListViewItem listViewItem = null;
	
		//sunny.example.openimageloaderviews.ListViewItem.ListViewItem(String content, String imageUrl)
		//Ìî³älistViewItem
		for(int i = 0;i < imageUrl.length;i++){
			listViewItem = new ListViewItem("item" + i,imageUrl[i]);
			arrayList.add(listViewItem);
		}
		//ÊÊÅäÆ÷
		ListViewAdapter adapter = new ListViewAdapter(mContext,arrayList,mImageLoader);
		mListView.setAdapter(adapter);
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

	