<%@ page import="com.mysql.cj.protocol.x.XMessage" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/register.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Sign in</title>
</head>

<body>

<div class="main">
    <p class="sign" align="center">Sign in</p>
    <form action="login" method="post">
        <input class="un " type="text" name = "email" align="center" placeholder="Email">
        <input class="pass" type="password" name = "password" align="center" placeholder="Password">

        <br><p style = "color: mediumvioletred" align = "center">${message}</p>
        <button class ="submit" align="center">Sign in</button>

    </form>
    <p  class = "forgot" align = "center">Don't have an account?</p>
    <div class="register">
        <a href="${pageContext.request.contextPath}/register" style = "color:#8C55AA">Register</a>
    </div>

</div>
