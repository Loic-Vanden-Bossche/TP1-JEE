package fr.esgi.rent.servlets;

import fr.esgi.rent.beans.RentalProperty;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        request.getRequestDispatcher("/error.jsp").forward(request,
                response);
    }

}
