package sunny.example.openimageloaderviews;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter{
	private Context mContext;
	private ArrayList<GridViewItem> mArrayList;
	private ImageLoader mImageLoader;
	private DisplayImageOptions mDisplayImageOptions;
	String[] imgUrls ;
	
	@SuppressWarnings("deprecation")
	public GridViewAdapter(Context context,ArrayList<GridViewItem> arrayList,ImageLoader imageLoader){
		this.mContext = context;
		this.mArrayList = arrayList;
		this.mImageLoader = imageLoader;
		
		mDisplayImageOptions = new DisplayImageOptions.Builder()
		.showImageForEmptyUri(R.drawable.fail)//空Url时显示R.drawable.fail
		.showImageOnLoading(R.drawable.loading)
		.showStubImage(R.drawable.ic_launcher) //默认显示ic_launcher
		.build();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mArrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			//convertView = LayoutInflater.from(this.mContext).inflate(R.layout.listview_item, null);
			convertView = LayoutInflater.from(this.mContext).inflate(R.layout.gridview_item, null);
			viewHolder.imageView = (ImageView)convertView.findViewById(R.id.gridviewImg);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		if(this.mArrayList != null){
			GridViewItem mGridViewItem = this.mArrayList.get(position);
			try{
				////ImageLoader.displayImage(String uri, ImageView imageView, DisplayImageOptions options)
				mImageLoader.displayImage(mGridViewItem.imgUrl, viewHolder.imageView,mDisplayImageOptions);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return convertView;
	}

	private class ViewHolder{
	    ImageView imageView;
	  }
}
