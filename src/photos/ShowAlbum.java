package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAlbum
 */
@WebServlet("/photos/ShowAlbum")
public class ShowAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Album getAlbum(int id) {
		
		// Get a reference to the guest book
		ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
		
		// Find the entry who's id matches the id passed in
		for(Album entry : allAlbums) {
			if (entry.getId() == id)
				return entry;
		}
		
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Album album = getAlbum(id);
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>" +album.getName() + "</title>");
		out.println("<style>");
		
		
		out.println("div.gallery{");
		out.println("margin: 5px;");
		out.println("border: 1px solid #ccc;");
		out.println("float: left;");
		out.println("width: auto;");
		out.println("}");
		
		out.println("div.gallery: hover{");
		out.println("border: 1px solid #777;");
		out.println("}");
	
		out.println("div.gallery img{");
		out.println("width: 250px;");
		out.println("height: 200px;");
		out.println("}");
		
		out.println("div.desc{");
		out.println("padding: 5px;");
		out.println("text-align: center;");
		out.println("}");
		
		
		
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1 style=\"text-align: center; color: white; padding: 10px 10px; background-color: #0A376B\">"+ album.getName() + "</h1>");
		
		out.println("<div>");
		out.println("<a href=\"Upload?id=" + album.getId() + "\" class=\"btn btn-primary\">Add Photo</a>");
		out.println("<a href=\"albums\" style=\"margin: 10px;\" class=\"btn btn-primary\">Back to Albums</a>");
		out.println("</div>");
		
		ArrayList<Photo> allPhotos = album.getPhotos();	
		
		
		for(Photo photo : allPhotos ) {
			if(photo != null) {
				out.println("<div class=\"gallery\">");
				
				
				
				out.println("  <img src=\"ImgSource?photoid=" + photo.getPhotoID() + "&id=" + album.getId() + "\" class=\"img-thumbnail\">");
				
				out.println("<div class=\"desc\">");
				out.println("		<a href=\"ImgSource?photoid=" + photo.getPhotoID() + "&id=" + album.getId() + "\">Source Photo</a>");
				out.println("<hr>");
				out.println("		<a href=\"DownloadImg?photoid=" + photo.getPhotoID() + "&id=" + album.getId() + "\">Download Photo</a>");
				out.println("<hr>");
				out.println("       <a href=\"DeletePhoto?photoid=" + photo.getPhotoID() + "&id=" + album.getId() + "\">Delete Photo</a>");
				out.println("</div>");
				out.println("</div>");
				//System.out.println(photo.getAddress());
				
			}
		}
		

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
