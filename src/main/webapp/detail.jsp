<%@ page import="fr.esgi.rent.beans.RentalProperty" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.esgi.rent.services.RentalPropertiesFileParser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<p>
    <%
        RentalProperty rentalProperty = (RentalProperty) request.getAttribute("rentalProperty");

            out.println(String.format("%s à louer", rentalProperty.propertyType().getDesignation()));
        %>
        <br>
        <%
            out.println(String.format("Loyer mensuel : %s €", rentalProperty.rentAmount()));
        %>
        <br>
        <%
            out.println(String.format("Surface : %s m²", rentalProperty.area()));
        %>
        <br>
        <%
            out.println(String.format("Nombre de chambres : %s", rentalProperty.bedroomsCount()));

    %>

</p>
</body>
</html>
