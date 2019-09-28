package photos;

public class Photo {
	static int count = 0;
	
	int photoId;
	String address;
	String name;
	
	public Photo(String address, String name) {
		this.address = address;
		this.photoId = count++;
		this.name = name;
		
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getPhotoID() {
		return this.photoId;
	}
	
	public String getFileName() {
		return name;
	}
}
