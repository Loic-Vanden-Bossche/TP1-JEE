package fr.esgi.rent.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RentalPropertiesConsultationServletTest {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new RentalPropertiesConsultationServlet().doGet(request, response);

        writer.flush(); // it may not have been flushed yet...
        assertFalse(stringWriter.toString().isBlank());
        assertFalse(stringWriter.toString().isEmpty());

    }

    @Test
    public void should_have_same_number_of_location_than_line_in_csv() throws IOException, ServletException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new RentalPropertiesConsultationServlet().doGet(request, response);

        writer.flush(); // it may not have been flushed yet...

        //get number fo line in csv
        Path path = Paths.get("src/main/resources/rentalProperties.csv");
        long numberOfLine = Files.lines(path).count() - 1; //-1 because first line is header

        //get number of location in html
        String html = stringWriter.toString();
        int numberOfLocation = html.split("<ul>").length - 1;

        assertEquals(numberOfLine, numberOfLocation);


    }



}
