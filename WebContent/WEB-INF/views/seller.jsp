<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
	<title>Seller Page</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/seller.js"></script>
</head>
<body>

	<span>
		Categories:
		<select id="categories">
			<c:forEach items="${categories}" var="cat">
				<option value="${cat.id}"><c:out value="${cat.name}"/></option>
			</c:forEach>
		</select>
		
		<input id="get-toys" type="button" value="Get Toys"></input>	
	</span>
	
	<div>
		<table class="categories" id="toys">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>Selling Quantity</th>
				</tr>
			</thead>
			<tbody id="toys-body">
				<tr>
					<td colspan="5">
						No data available
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
					</td>
					<td>
						<input id="calculate-total" type="button" value="Calculate Total Price"></input>
					</td>
				</tr>
			</tfoot>
		</table>
	
		<div>
			<span>
				Total Price: <label id="total-price">0</label> RON
			</span>
			<span>
				<input id="sell-toys" type="button" value="Sell Toys" disabled/>
				<input id="cancel" type="button" value="Cancel" disabled/>
			</span>
		</div>
		
	</div>
	
	<a href="<c:url value="/logout" />" > Logout</a>
</body>
</html>