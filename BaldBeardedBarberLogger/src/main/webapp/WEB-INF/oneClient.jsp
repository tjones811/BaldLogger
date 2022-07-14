<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container "> <!-- Beginning of Container -->
    
    <h1>Bald Bearded Barber Logger</h1>
    
    <h1>Showing B&B Client ${client.name}</h1>
    
    
    <div class="card" style="width: 18rem;">
  
  <div class="card-body">
    <h2 class="card-title">${client.name}</h2>
    
    <p>(Barber: <c:out value="${client.user.firstName} ${client.user.lastName }"></c:out>)</p>
    <p class="card-text">${client.month}.${client.day} @ ${client.hour}:${client.minute}:${client.ampm}</p>
    <p class ="card-text">${client.type}</p>
    <p class ="card-text">$ ${client.price}</p>
    <h3 class = "card-text">**${client.notes}**</h3>
    
  </div>
</div>

<a href="/editClient/${client.id}"><button type="button" class="btn btn-primary">Edit</button></a>
<a href="/deleteClient/${client.id}"><button type="button" class="btn btn-danger">Delete</button></a>
<a href="/dashboard"><button type="button" class="btn btn-info">Dashboard</button></a>
    
    
        
    </div> <!-- End of Container -->
</body>
</html>