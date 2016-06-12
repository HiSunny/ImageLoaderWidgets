package sunny.example.openimageloaderviews;


public class GridViewItem {
	
	 String imgUrl;
	
	public GridViewItem(String imgUrl){
		super();
		this.imgUrl = imgUrl;
	}

	public void setImg(String imgUrl){
		this.imgUrl = imgUrl;
	}
	public String getImg(){
		return imgUrl;
	}
}
