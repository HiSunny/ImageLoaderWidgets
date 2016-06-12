package sunny.example.openimageloaderviews;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
//import java.util.ArrayList;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;

public class ViewPagerAdapter extends PagerAdapter{

	String[] mImageUrls;
	//ArrayList<GridViewItem> mArrayList;
	ImageLoader mImageLoader;
	Context mContext;
	DisplayImageOptions mDisplayImageOptions;
	@SuppressWarnings("deprecation")
	public ViewPagerAdapter(Context context,String[] imageUrls,ImageLoader imageLoader){
		this.mContext = context;
		//this.mArrayList = arrayList;
		this.mImageLoader = imageLoader;
		this.mImageUrls = imageUrls;
		mDisplayImageOptions = new DisplayImageOptions.Builder()
		.showImageForEmptyUri(R.drawable.fail)
		.showStubImage(R.drawable.ic_launcher)
		.build();
		
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImageUrls.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	 @Override  
     public void destroyItem(ViewGroup container, int position, Object object) {  
         ((ViewPager) container).removeView((View) object);  
     }  
	 @Override  
     public Object instantiateItem(ViewGroup view, int position) { 
		 //View imageLayout = inflater.inflate(R.layout.item_pager_image, view, false); 
          View imageLayout = LayoutInflater.from(this.mContext).inflate(R.layout.gridview_item, null);
          ImageView img = (ImageView)view.findViewById(R.id.gridviewImg);
         // GridViewItem mGridViewItem = this.mArrayList.get(position);
          try{
				////ImageLoader.displayImage(String uri, ImageView imageView, DisplayImageOptions options)
				mImageLoader.displayImage(mImageUrls[position],img,mDisplayImageOptions);
				
			}catch(Exception e){
				e.printStackTrace();
			}
          ((ViewPager)view).addView(imageLayout, 0);
         return  imageLayout ;  
     }  

}
