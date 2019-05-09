<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>${ message }</p>
	<form action="${url}" method="post">
		<p>Usuário: <input type="text" name="user" /></p>
		<p>Senha: <input type="password" name="pass" /></p>
		<p><input type="submit" value="Login" /></p>
	</form>

</body>
</html>