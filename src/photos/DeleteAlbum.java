package photos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAlbum
 */
@WebServlet("/photos/DeleteAlbum")
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Album> allAlbums = (ArrayList<Album>)getServletContext().getAttribute("allAlbums");
		
		for(Album album: allAlbums) {
			if(album.getId() == id) {
				allAlbums.remove(album);
				break;
			}
		}
		response.sendRedirect("albums");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
