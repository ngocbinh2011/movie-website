<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/20/2021
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Error</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" type="image/x-icon">
    <!-- Bootstrap CSS -->
    <link rel="shortcut icon" sizes="180x180" href="./apple-touch-icon.png">
    <link rel="stylesheet" href="<c:url value="/resources/css/exception.css"/>">
</head>

<body>
<div class="error-content">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ">
                <div class="error-text">
                    <div class="im-sheep">
                        <div class="top">
                            <div class="body"></div>
                            <div class="head">
                                <div class="im-eye one"></div>
                                <div class="im-eye two"></div>
                                <div class="im-ear one"></div>
                                <div class="im-ear two"></div>
                            </div>
                        </div>
                        <div class="im-legs">
                            <div class="im-leg"></div>
                            <div class="im-leg"></div>
                            <div class="im-leg"></div>
                            <div class="im-leg"></div>
                        </div>
                    </div>
                    <h4>Oops! ${message}</h4>
                    <p>We are sorry about that! Please ensure and try again. If the problem persists contact support </p>
                    <a href="/" class="btn btn-primary btn-round" > Go to homepage </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>