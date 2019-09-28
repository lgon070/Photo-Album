package photos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadPhoto
 */
@WebServlet("/photos/DownloadImg")
public class DownloadImg extends HttpServlet {
	
private Album getAlbum(int id) {
		
		ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
		
		for(Album album : allAlbums) {
			if(album.getId() == id) {
				return album;
			}
		}
		return null;
	}
	
    private Photo getPhoto(int photoId, Album albumToSearch) {
    	ArrayList<Photo> allPhotos = albumToSearch.getPhotos();
    	
    	for(Photo photo : allPhotos) {
    		if(photo.getPhotoID() == photoId) {
    			return photo;
    		}
    	}
    	return null;
    }
 
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int photoid = Integer.parseInt(request.getParameter("photoid"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Album album = getAlbum(id);
		
		Photo photo = getPhoto(photoid, album);
		
		// Get the path to the file and create a java.io.File object
        
		//String path = getServletContext().getRealPath( "/WEB-INF/uploads/" + photo.getFileName());
        
        File file = new File( photo.getAddress() );

        // Set the response headers. File.length() returns the size of the file
        // as a long, which we need to convert to a String.
        response.setContentType( "image/jpg" );
        response.setHeader( "Content-Length", "" + file.length() );
        response.setHeader( "Content-Disposition",
            "attachment; filename=download.jpg" );

        // Binary files need to read/written in bytes.
        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();
    
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
