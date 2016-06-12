package sunny.example.openimageloaderviews;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.view.LayoutInflater;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
public class ListViewAdapter extends BaseAdapter{

	private ArrayList<ListViewItem> mArrayList;
	private Context mContext;
	private ImageLoader mImageLoader;
	private DisplayImageOptions mDisplayImageOptions;
	
	@SuppressWarnings("deprecation")
	public ListViewAdapter(Context context,ArrayList<ListViewItem> arrayList,ImageLoader imageLoader){
		super();
		this.mContext = context;
		this.mArrayList = arrayList;
		this.mImageLoader = imageLoader;

		//����ͼƬ��ʾѡ��
		mDisplayImageOptions = new DisplayImageOptions.Builder()
		.showImageForEmptyUri(R.drawable.fail)//��Urlʱ��ʾR.drawable.fail
		.showImageOnLoading(R.drawable.loading)
		.showStubImage(R.drawable.ic_launcher) //Ĭ����ʾic_launcher
		.build();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(mArrayList == null)
			return 0;
		else
			return mArrayList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if(mArrayList == null)
			return null;
		else
			return mArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		
		return position;
	}

//	/Get a View that displays the data at the specified position in the data set. 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		//��ViewHolder����ListViewЧ��
		ViewHolder viewHolder;
		
		if(convertView == null){
			viewHolder = new ViewHolder();
	/*LayoutInflater android.view.LayoutInflater.from(Context context)
Obtains the LayoutInflater from the given context.
*///View android.view.LayoutInflater.inflate(int resource, ViewGroup root)
			convertView = LayoutInflater.from(this.mContext).inflate(R.layout.listview_item, null);
			viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
			
			viewHolder.textView = (TextView)convertView.findViewById(R.id.textView);
			//��ViewHolder����洢��convertView��
			//void android.view.View.setTag(Object tag)
			convertView.setTag(viewHolder);
		}else{
			//���»�ȡviewHolder
			///Object android.view.View.getTag()
			viewHolder = (ViewHolder)convertView.getTag();
		}
		if(this.mArrayList != null){
			//java.util.ArrayList.get(int index)
			ListViewItem listViewItem = this.mArrayList.get(position);
			if(viewHolder.textView != null){
				viewHolder.textView.setText(listViewItem.getContent());
			}if(viewHolder.imageView != null){
				
				try{
					//��ImageLoader��ʾͼƬ
    //ImageLoader.displayImage(String uri, ImageView imageView, DisplayImageOptions options)
					mImageLoader.displayImage(listViewItem.imageUrl, viewHolder.imageView, mDisplayImageOptions);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		}
		
		return convertView;
	}

	 private class ViewHolder{
		    ImageView imageView;
		    TextView textView;
		  }
}
