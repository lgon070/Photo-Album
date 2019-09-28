package photos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletePhoto
 */
@WebServlet("/photos/DeletePhoto")
public class DeletePhoto extends HttpServlet {
private Album getAlbum(int id) {
		
		ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
		
		for(Album album : allAlbums) {
			if(album.getId() == id) {
				return album;
			}
		}
		return null;
	}

	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int photoid = Integer.parseInt(request.getParameter("photoid"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Album album = getAlbum(id);
		
		ArrayList<Photo> delPhotos = album.getPhotos();
		
		for(Photo photo : delPhotos) {
			if(photo.getPhotoID() == photoid) {
				File deleteFile = new File(photo.getAddress());
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
				delPhotos.remove(photo);
				break;
			}
		}
		response.sendRedirect("albums");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
