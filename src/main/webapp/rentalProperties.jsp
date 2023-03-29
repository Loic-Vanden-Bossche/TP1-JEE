<%@ page import="fr.esgi.rent.beans.RentalProperty" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Liste des locations</title>
</head>
<body>
<h1>Liste des locations</h1>
<p>
        <%
List<RentalProperty> rentalProperties = (List<RentalProperty>)
request.getAttribute("rentalProperties");
for (RentalProperty rentalProperty : rentalProperties) {
%>
    <a href="/rent-web/details?id=<%=rentalProperty.referenceId()%>">
        <%=rentalProperty.referenceId()%><br>
    <%
    }
%>
</p>
</body>
</html>
