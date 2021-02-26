package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RacecarItem;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RacecarItemHelper helper = new RacecarItemHelper(); 
		
		String make = request.getParameter("make"); 
		String model = request.getParameter("model"); 
		String arrangement = request.getParameter("arrangement"); 
		String displacement = request.getParameter("displacement"); 
		Integer hp = Integer.parseInt(request.getParameter("horsepower")); 
		Integer id = Integer.parseInt(request.getParameter("id"));
		String series = request.getParameter("series"); 
		RacecarItem car = helper.searchByID(id); 
		car.setMake(make);
		car.setModel(model);
		car.setArrangement(arrangement);
		car.setDisplacement(displacement);
		car.setHorsePower(hp);
		car.setSeries(series);
		helper.updateItem(car);
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}
