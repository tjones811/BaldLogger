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
    <div class="container"> <!-- Beginning of Container -->
    
    <h1>Bald Bearded Barber Logger</h1>
    
    <h1>Welcome to shop DashBoard ${user.firstName}. Below are shop clients.</h1>
    
    <table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date/Time</th>
      <th scope="col">Cut</th>
      <th scope="col">Price</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    
    <c:forEach var = "client" items = "${allClients}">
    
    	<tr>
	      <th scope="row"><a href = "/showClient/${client.id}"><button type="button" class="btn btn-info"><c:out value="${client.name}"></c:out></button></a></th>
	      <td><c:out value="${client.month}.${client.day} @ ${client.hour}:${client.minute}:${client.ampm}"></c:out></td>
	      <td><c:out value = "${client.type}"></c:out></td>
	      <td><c:out value = "$ ${client.price}"></c:out></td>
	      <td>
	      	<a href="/editClient/${client.id}"><button type="button" class="btn btn-primary">Edit</button></a>
	      	<a href="/deleteClient/${client.id}"><button type="button" class="btn btn-danger">Delete</button></a>
	      </td>
    	</tr>
    </c:forEach>
    
  </tbody>
</table>
  
    
    <a href="/newClient"><button type="button" class="btn btn-warning">New Client</button></a>
    <a href="/logout"><button type="button" class="btn btn-secondary">Logout</button></a>
    
        
    </div> <!-- End of Container -->
</body>
</html>