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
    
    <h1>Edit B&B Client</h1>
    
    <form:form action= "/processEditClient/${client.id }" method = "post" modelAttribute = "client">
	<input type = "hidden" name = "user" value= "${user.id}">
	<input type = "hidden" name = "_method" value= "put">
	
	

	<div class = "form-group">
		<label>Name:</label>
		<form:input path= "name" class = "form-control"/>
		<form:errors path = "name" class = "text-danger"/>
	</div>
	
	<div class = "form-group">
		<label>Cut Type:</label>
		<form:errors path = "type"></form:errors>
		<form:select path ="type" class = "form-control">
		
		<form:option value ="trim">Trim</form:option>
		<form:option value ="stubble">Stubble</form:option>
		<form:option value ="full">Full</form:option>
		<form:option value ="goatee">Goatee</form:option>
		<form:option value ="anchor">Anchor</form:option>
		<form:option value ="shaven">Shaven</form:option>
		
		</form:select>
	</div>
	
	
	

	<div class = "d-flex justify-content-between">

		<div class = "form-group col-md-2">
			<label>Month:</label>
			<form:errors path = "month"></form:errors>
			<form:select path ="month" class = "form-control">
			
			<form:option value ="Jan">Jan</form:option>
			<form:option value ="Feb">Feb</form:option>
			<form:option value ="Mar">Mar</form:option>
			<form:option value ="Apr">Apr</form:option>
			<form:option value ="May">May</form:option>
			<form:option value ="Jun">Jun</form:option>
			<form:option value ="Jul">Jul</form:option>
			<form:option value ="Aug">Aug</form:option>
			<form:option value ="Sep">Sep</form:option>
			<form:option value ="Oct">Oct</form:option>
			<form:option value ="Nov">Nov</form:option>
			<form:option value ="Dec">Dec</form:option>		
			
			</form:select>
		</div>

		<div class = "form-group col-md-2">
			<label>Day:</label>
			<form:errors path = "day"></form:errors>
			<form:select path ="day" class = "form-control">
			
			<form:option value ="1">1</form:option>
			<form:option value ="2">2</form:option>
			<form:option value ="3">3</form:option>
			<form:option value ="4">4</form:option>
			<form:option value ="5">5</form:option>
			<form:option value ="6">6</form:option>
			<form:option value ="7">7</form:option>
			<form:option value ="8">8</form:option>
			<form:option value ="9">9</form:option>
			<form:option value ="10">10</form:option>
			<form:option value ="11">11</form:option>
			<form:option value ="12">12</form:option>
			<form:option value ="13">13</form:option>
			<form:option value="14">14</form:option>
			<form:option value="15">15</form:option>
			<form:option value="16">16</form:option>
			<form:option value="17">17</form:option>
			<form:option value="18">18</form:option>
			<form:option value="19">19</form:option>
			<form:option value="20">20</form:option>
			<form:option value="21">21</form:option>
			<form:option value="22">22</form:option>
			<form:option value="23">23</form:option>
			<form:option value="24">24</form:option>
			<form:option value="25">25</form:option>
			<form:option value="26">26</form:option>
			<form:option value="27">27</form:option>
			<form:option value="28">28</form:option>
			<form:option value="29">29</form:option>
			<form:option value="30">30</form:option>
			<form:option value="31">31</form:option>


			</form:select>
		</div>
		
		

		<div class = "form-group col-md-2">
			<label>Hour:</label>
			<form:errors path = "hour"></form:errors>
			<form:select path ="hour" class = "form-control">
			
			<form:option value ="1">1</form:option>
			<form:option value ="2">2</form:option>
			<form:option value ="3">3</form:option>
			<form:option value ="4">4</form:option>
			<form:option value ="5">5</form:option>
			<form:option value ="6">6</form:option>
			<form:option value ="7">7</form:option>
			<form:option value ="8">8</form:option>
			<form:option value ="9">9</form:option>
			<form:option value ="10">10</form:option>
			<form:option value ="11">11</form:option>
			<form:option value ="12">12</form:option>

			</form:select>
		</div>

		<div class = "form-group col-md-2">
			<label>Minute:</label>
			<form:errors path = "minute"></form:errors>
			<form:select path ="minute" class = "form-control">
			
			<form:option value ="00">00</form:option>
			<form:option value ="15">15</form:option>
			<form:option value ="30">30</form:option>
			<form:option value ="45">45</form:option>
			
			</form:select>
		</div>

		<div class = "form-group col-md-2">
			<label>AM/PM:</label>
			<form:errors path = "ampm"></form:errors>
			<form:select path ="ampm" class = "form-control">
			
			<form:option value ="AM">AM</form:option>
			<form:option value ="PM">PM</form:option>

			
			</form:select>
		</div>

	</div>
	
	
	
	<div class = "form-group col-md-2">
		<label>Price:</label>
		<form:errors path = "price" class = "text-danger"></form:errors>
		<form:input type="number" class = "form-control" path="price"/><br>
	</div>
	
	<div class = "form-group col-md-2">
		<label>Notes:</label>
		<form:errors path = "notes" class = "text-danger"></form:errors>
		<form:textarea type="textarea" rows="4" cols="50" class = "form-control" path="notes"/>
	</div>




	
	
	<input type="submit" value="Submit" class="btn btn-success">
</form:form>
    <a href="/dashboard"><button type="button" class="btn btn-danger mt-2">Cancel</button></a>
        
    </div> <!-- End of Container -->
</body>
</html>