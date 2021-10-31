<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2021
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Basic Admin Dashboard</title>

  <!-- Bootstrap CSS -->
  <link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" type="image/x-icon">
  <link
          rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous"
  />

  <!-- FontAwesome 4.7.0 -->
  <script src="https://kit.fontawesome.com/44ec9fb3c1.js" crossorigin="anonymous"></script>

  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="<c:url value="/resources/css/admin-style-common.css"/>" />
</head>

<body>
<!-- ##### Header Area ##### -->
<%@ include file="/WEB-INF/templates/admin-header.jsp"%>

  <!-- Main Content of the Body -->
  <div class="main-content">
    <main>
      <div class="container-fluid my-2">
        <h1>Chọn phần muốn sửa</h1>


        <div class="row my-3">
          <div class="col-md-12">
            <div class="card p-3 shadow">

              <a href="general-information/" class="btn mr-auto  bg-teal text-white my-2">
                thông tin chung
              </a>
              <a href="category/" class="btn mr-auto  bg-teal text-white my-2">
                thể loại
              </a>
              <a href="actor/" class="btn mr-auto  bg-teal text-white my-2">
                diễn viên
              </a>
              <a href="episodes/" class="btn mr-auto  bg-teal text-white my-2">
                các tập phim
              </a>
              <a href="keywords/" class="btn mr-auto  bg-teal text-white my-2">
                từ khóa của phim
              </a>
            </div>

          </div>
        </div>
    </main>
  </div>
</div>

<script
        src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"
></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"
></script>

<!-- FontAwesome 5.1.1 -->

<!-- Main JavaScript -->
<script src="<c:url value="/resources/js/admin-common.js"/>"></script>
</body>
</html>


</body>
</html>
