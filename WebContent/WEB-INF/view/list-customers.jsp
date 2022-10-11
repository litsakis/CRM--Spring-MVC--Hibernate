<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>


<head>
	<title>List Customers </title>
	<!-- link style sheet -->
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		
		</div>
		<div id="container">
		
			<div id="content">
			
			
			<!-- add our html table here -->
			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					
					</tr>
					<!-- loop over and print customers -->
					
					<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td> ${tempCustomer.firstName } 
						<td> ${tempCustomer.lastName } 
						<td> ${tempCustomer.email } 

					</tr>
					
					
					</c:forEach>
			
				</table>
			
			
			</div>
		
		
		</div>
	
	</div>

</body>
</html>