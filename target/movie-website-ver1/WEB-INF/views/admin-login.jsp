<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/18/2021
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="keywords"
          content="unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form">
    <meta name="author" content="leamug">
    <title>Login</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" type="image/x-icon">
    <!-- Bootstrap core Library -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <link rel="stylesheet" href="<c:url value="/resources/css/admin-login.css"/>">

</head>
<body>

<!-- This is a very simple parallax effect achieved by simple CSS 3 multiple backgrounds, made by http://twitter.com/msurguy -->

<div class="simple-login-container">
    <h2>Please Login To Continue</h2>
    <form action="/admin/login/" method="post">
        <div class="row">
            <div class="col-md-12 form-group">
                <input type="text" class="form-control" placeholder="Username" name="username">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 form-group">
                <input type="password" placeholder="Enter your Password" class="form-control" name="password">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 form-group">
                <input type="submit" class="btn btn-block btn-login" placeholder="Enter your Password" >
            </div>
        </div>

    </form>
</div>
</body>
</html>
