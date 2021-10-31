<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2021
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
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
                <h1>Thể loại</h1>

                <div class="row my-3">
                    <div class="col-md-12">
                        <div class="card p-3 shadow">
                            <form action="add/" method="post" class="form-inline my-2">
                                <select id="" name="categoryAdd" placeholder="Thể Loại">
                                    <c:forEach items="${listCategory}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>

                                <button
                                        class="btn ml-auto bg-teal text-white my-2"
                                        type="submit"
                                >
                                    Thêm Thể Loại
                                </button>

                            </form>
                            <h4 class="my-2 mb-3">Tìm kiếm</h4>
                            <table
                                    class="table table-striped table-inverse "
                            >
                                <thead class="thead-inverse">
                                <tr>
                                    <th>STT</th>
                                    <th>Id</th>
                                    <th>Thể loại</th>
                                    <th>Code</th>
                                    <th>Xóa</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCategoryOfMovie}" var="category" varStatus="status">
                                        <tr>
                                            <td class="col-4">${status.index + 1}</td>
                                            <td class="col-4">${category.id}</td>
                                            <td class="col-4">${category.name}</td>
                                            <td class="col-4">${category.code}</td>
                                            <td>
                                                <a href="delete/${category.id}/"><i class="fas fa-trash-alt"></i></a>
                                            </td>
                                        </tr>

                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

            </div>
    </div>
    </main>
</div>
</div>
<!-- ##### End: Main Area ##### -->

<!-- ##### Footer Area ##### -->
<!-- <footer> -->
<div class="container text-center">
    <div class="pagination row" style="display:flex; justify-content: center;">
        <ul class='page-numbers'  style="display:flex; list-style: none;">
            <li><span class="page-numbers current">1</span> </li>
            <li><a class="page-numbers" href="#">2</a> </li>
            <li><a class="page-numbers" href="#">3</a> </li>
            <li><a class="page-numbers" href="#">4</a> </li>
            <li><a class="page-numbers" href="#">5</a> </li>
            <li><span class='page-numbers dots'>...</span> </li>
            <li><a class="page-numbers" href="#">Cuối</a> </li>
        </ul>
    </div>
</div>
</footer>
<!-- ##### End: Footer Area ##### -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
</body>
</html>