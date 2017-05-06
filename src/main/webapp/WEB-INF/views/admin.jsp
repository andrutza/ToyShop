<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin Page</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
		$(document).ready(function (){
		    $.ajax({                                      
		      url: 'admin',              
		      type: "get",          
		      dataType: 'html',                
		      success: function(response){
		    	  alert("here");
     	    	 window.location.href = ''; 
     	     }
		    });
		});
	</script>
</head>
<body>
	<h1>Users:</h1>
	<table class="users">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Username</th>
			<th>Password</th>
			<th>Role</th>
			<th>Update operation</th>
			<th>Delete operation</th>
		</tr>
		   <c:forEach items="${userList}" var="user" >
		     <tr id="user_<c:out value="user.id"/>">
		       <td class="userFirstName">
		       		<c:out value="${user.firstName}" />
		       </td>
		       <td class="userLastName"><c:out value="${user.lastName}" /></td>
         	   <td class="personEmail"><c:out value="${user.email}" /></td>
        	   <td class="userUsername"><c:out value="${user.username}" /></td>
               <td class="userPassword"><c:out value="${user.password}" /></td>
               <td class="userRole"><c:out value="${user.role.name}" /></td>
               <td class="update">
	               <a href="<c:url value="/update?id=${user.id}"/>">Update user</a>
               </td>
               <td class="delete">
	               <a href="<c:url value="/delete?id=${user.id}"/>">Delete user</a>
               </td>
		     </tr>
		   </c:forEach>
	</table>
	<h2><a href="<c:url value="/back"/>">Back to home page</a></h2>

</body>
</html>