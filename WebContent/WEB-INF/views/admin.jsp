<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Page</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/admin.js"></script>
</head>
<body>
	<h1>Toys:</h1>
	<table id="toys" class="toys">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Description</th>
			<th>Category</th>
			<th>Update operation</th>
			<th>Delete operation</th>
		</tr>
		   <c:forEach items="${toyList}" var="toy" >
		     <tr id="toy_<c:out value="${toy.id}"/>">
		       <td contenteditable='true' class="toyName"><c:out value="${toy.name}" /></td>
		       <td contenteditable='true' class="toyPrice"><c:out value="${toy.price}" /></td>
         	   <td contenteditable='true' class="toyCount"><c:out value="${toy.count}" /></td>
        	   <td contenteditable='true' class="toyDescription"><c:out value="${toy.description != null ? toy.description : \"No description\"}"/></td>
               <td class="toyCategory"><c:out value="${toy.category.name}" /></td>
               <td class="update">
	               <input type='button' value='Update toy'/>
               </td>
               <td class="delete">
	               <input type='button' value='Delete toy'/>
               </td>
		     </tr>
		   </c:forEach>
	</table>
	<input id="add-form" type="button" value="Add toy"/><br><br>
	<div id="addDiv" class="addForm" style="visibility: hidden">
		<form id="addForm1" name="addForm1">
			<h1>Add toy:</h1>
			<label>Name</label>:
			<input class="input" id="iname" name="name" type="text"/> <br><br>
			<div class="errors" id="name" style="visibility: hidden"></div> <br>
			<label>Price</label>:
			<input class="input" id="iprice" name="price" type="text"/>  <br><br>
			<div class="errors" id="price" style="visibility: hidden"> </div> <br>
			<label>Quantity</label>:
			<input class="input" id="icount" name="count" type="text"/>  <br><br>
			<div class="errors" id="count" style="visibility: hidden"> </div> <br>
			<label>Description</label>:
			<input class="input" id="idescription" name="description" type="text"/>  <br><br>
			<div class="errors" id="description" style="visibility: hidden"></div> <br>
			<label>Category</label>:
			<select id="icategory">
				<c:forEach items="${categories}" var="cat">
					<option value="${cat.id}"><c:out value="${cat.name}"/></option>
				</c:forEach>
			</select><br><br>
			<input id="addButton" type="button" value="Add"/><br><br>
			<input id="cancelButton" class="cancel" type="button" value="Cancel"/><br><br>
		</form>
	</div><br><br>
	<a href="<c:url value="/logout" />" > Logout</a>

</body>
</html>