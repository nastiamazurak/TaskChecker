<%--
  Created by IntelliJ IDEA.
  User: nastiamazurak
  Date: 10/4/19
  Time: 8:34 дп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/register.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Register</title>
</head>

<body>
<div class="main">
    <p class="sign" align="center">Register</p>
    <form action="register" method="post">
        <input class="un " type="text" name = "email" align="center" placeholder="Email">
        <input class="pass" type="password" name = "password" align="center" placeholder="Password">
        <br>${message}
        <input class="pass" type="password" name = "confirm" align="center" placeholder="Confirm password">
        <br>${message}


        <button class ="submit" align="center">Register</button>
        <p style = "color: red;" align = "center">${emailError}</p>
        <p style = "color: red;" align = "center">${passError}</p>

    </form>
    <p  class = "forgot" align = "center"> <a href="${pageContext.request.contextPath}/login" style = "color:#8C55AA">Already have an account?</a></p>


</div>

</body>




</html>