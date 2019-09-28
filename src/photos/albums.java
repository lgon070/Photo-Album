package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab3.GuestBookEntry;




/**
 * Servlet implementation class PhotoAlbum
 */
@WebServlet(urlPatterns= {"/photos/albums"})
public class albums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Created a local, empty array list of type Guest Book Entry
		ArrayList<Album> allAlbums = new ArrayList<Album>();
		
		// Pre-populate my guest book with some entries
		allAlbums.add( new Album("My First Album", "Welcome!"));
		
		// Add the array list to the application scope (Servlet Context)
		getServletContext().setAttribute("allAlbums", allAlbums);
			
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Album> allAlbums = (ArrayList<Album>) getServletContext().getAttribute("allAlbums");
		response.setContentType("text/html");
		
		// Get a reference to the output stream
		PrintWriter out = response.getWriter();
		
		// Generate our HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("	 <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("    <title>My Scrappy Album</title>");
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
		out.println("height: 300px;");
		out.println("}");
		
		out.println("div.desc{");
		out.println("padding: 5px;");
		out.println("text-align: center;");
		out.println("}");
		
		out.println("div.aName{");
		out.println("padding: 5px;");
		out.println("text-align: center;");
		out.println("}");
		
		
		out.println("th{");
		out.println("background-color:#0A376B;");
		out.println("color: white;");
		out.println("}");
		out.println("");
		out.println("");
		out.println("");
		
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Page-Specific Content Goes Here...
		out.println("<h1 style=\"text-align: center; color: white; padding: 10px 10px; background-color: #0A376B\">My Scrappy Album</h1>");
		out.println("<hr>");		
		
		out.println("<div>");
		out.println("<a style=\"margin: 10px; \" class=\"btn btn-primary\" href=\"AddAlbum\">Add an Album!</a>");
		out.println("</div>");
		
		for( Album entry : allAlbums ) {
			if(entry != null) {
			
			out.println("<div class=\"gallery\">");
			
			out.println("<div class=\"aName\">");
			out.println("<p>" + entry.getName() + "</p>");
			out.println("</div>");
			
			
			
			if(entry.getFirstImage() == null) {
				out.println("  <img src=\"https://soundover.com/images/no_image_available.jpg\">");
			}
			else {
				Photo photo = entry.getFirstImage();
				
				out.println("  <img src=\"ImgSource?photoid=" + photo.getPhotoID() + "&id=" + entry.getId() + "\" class=\"img-thumbnail\">");
				
			}
			
			
			out.println("<div class=\"desc\">");
			out.println("<p>" + entry.getDescription() + "</p>");
			out.println("<hr>");
			out.println("       <a href=\"ShowAlbum?id=" + entry.getId() + "\">Show</a>");
			out.println("		|");
			out.println("		<a href=\"DeleteAlbum?id=" + entry.getId() + "\">Delete</a>");
			out.println("</div>");
			
			out.println("</div>");
			}
		}
		
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
