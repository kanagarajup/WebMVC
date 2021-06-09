<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="customer.Customer"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b></b><p>Customer Details</p></b><br><br>  
<%  
Customer bean=(Customer)request.getAttribute("bean");  
out.print("<br>CID: "+bean.getCid());
out.print("<br>CNAME: "+bean.getCname());
out.print("<br>BALANCE: "+bean.getBalance());
out.print("<br>BRANCH: "+bean.getBranch());
%>  

</body>
</html>