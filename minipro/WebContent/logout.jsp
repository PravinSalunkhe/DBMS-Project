<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	  response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");
	
	if(session.getAttribute("curr_uid") != null)
	{
		session.removeAttribute("curr_uid");
		session.invalidate();
		response.sendRedirect("home");
	}
	
	else if(session.getAttribute("participant_id") != null)
	{
		session.removeAttribute("participant_id");
		session.invalidate();
		response.sendRedirect("home");
	}
	else
	{
		session.removeAttribute("admin_id");
		session.invalidate();
		response.sendRedirect("home");
	}
	%> 

</body>
<script type="text/javascript">
	function preventBack(){window.history.forward();}
	setTimeout("preventBack()",0);
	window.onunload=function(){null};
</script>

</html>