<%@page import="com.example.demo.entity.Doc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/" enctype="multipart/form-data" >
<input type="file" name="image"></input>
<input type="submit" value="submit"></input>
</form>
<%String s = (String)request.getAttribute("msg"); %>
<%if(s!=null){ %>
 <%=s %>
 <%} %>
 <%List<Doc> l = (List<Doc>)request.getAttribute("docs"); %>
 <%if(l!=null){ %>
 <%for(Doc d : l){ %>
 <%=d.getName() %>
 <img src="data:image/jpeg;base64, <%=d.getPicture() %>"  alt="img" >

 <%}} %>
</body>
</html>