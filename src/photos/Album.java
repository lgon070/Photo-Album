package photos;

import java.util.ArrayList;

public class Album {
	static int albumCount = 0;
	
	int id;
	String name;
	String description;
	
	private ArrayList<Photo> photos = new ArrayList<Photo>();

	public Album(String name, String description) {
		this.name = name;
		this.description = description;
		this.id = albumCount++;
	}
	public int getId() {
		return id;
	}
	public void addPhoto(String photoPath, String nameOfFile) {
		photos.add(new Photo(photoPath, nameOfFile));
	
	}
	public ArrayList<Photo> getPhotos() {
		return photos;
	}
	public void deletePhoto(int i){
		
	}
	
	public Photo getFirstImage() {
		if(photos.isEmpty()) {
			return null;
		}
		else {
			return photos.get(0);
		}
		
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	
	
	
	
	
	

}
