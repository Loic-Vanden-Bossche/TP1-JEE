package fr.esgi.rent.servlets;

import fr.esgi.rent.beans.RentalProperty;
import fr.esgi.rent.services.RentalPropertiesFileParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/details")
public class DetailServlet extends HttpServlet {

    private final RentalPropertiesFileParser rentalPropertiesFileParser;

    public DetailServlet() {
        this.rentalPropertiesFileParser = new RentalPropertiesFileParser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        //get the id of the rental property
        String id = request.getParameter("id");

        //get the rental property
        List<RentalProperty> rentalProperties =
                rentalPropertiesFileParser.parse("rentalProperties.csv");
        RentalProperty rentalProperty = rentalProperties.stream()
                .filter(rentalProperty1 -> rentalProperty1.referenceId() == (Integer.parseInt(id)))
                .findFirst()
                .orElse(null);

        request.setAttribute("rentalProperty", rentalProperty);
        request.getRequestDispatcher("/detail.jsp").forward(request,
                response);
    }


}
