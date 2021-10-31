<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2021
  Time: 9:31 AM
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
                <h1>Danh Sách Phim</h1>

                <div class="row my-3">
                    <div class="col-md-12">
                        <div class="card p-3 shadow">
                            <form action="/admin/movies/search/" method="post" class="form-inline my-2" accept-charset="UTF-8">
                                <input
                                        class="form-control w-100"
                                        type="text" name="movieName"
                                        placeholder="Search..."
                                />
                                <small id="helpId" class="text-muted"
                                >Tìm kiếm Theo Tên Phim...</small
                                >
                                <button
                                        class="btn ml-auto bg-teal text-white my-2"
                                        type="submit"
                                >
                                    Tìm kiếm phim
                                </button>

                            </form>
                            <div class="form-inline my-2">
                                <a class="btn ml-auto bg-teal text-white my-2" href="/admin/movies/add/">
                                    Thêm Phim
                                </a>
                            </div>
                            <h4 class="my-2 mb-3">Tìm kiếm</h4>
                            <table
                                    class="table table-striped table-inverse table-responsive"
                            >
                                <thead class="thead-inverse">
                                <tr>
                                    <th>STT</th>
                                    <th>Id</th>
                                    <th>Tên Phim</th>
                                    <th>Ngày Tạo</th>
                                    <th>Người Tạo</th>
                                    <th>Ngày Sửa</th>
                                    <th>Người Sửa</th>
                                    <th>Sửa Phim</th>
                                    <th>Chọn</th>
                                    <th>Xóa</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${listMovie}" var="movie" varStatus="status">
                                        <tr>
                                            <td>${status.index + 1}</td>
                                            <td class="col-1">${movie.id}</td>
                                            <td class="col-3">${movie.name}</td>
                                            <td class="col-2">${movie.createDate}</td>
                                            <td>No name</td>
                                            <td class="col-2">${movie.updateDate}</td>
                                            <td>No name</td>
                                            <td>
                                                <a href="/admin/movies/${movie.id}/change/"><i class="fas fa-wrench"></i></a>
<%--                                                <a href="delete/${movie.id}/"><i class="fas fa-trash-alt"></i></a>--%>
                                            </td>
                                            <td class="col-1">
                                                <input type="checkbox" id="" name="" value="yes">
                                                <label for=""></label><br>
                                            </td>
                                            <td><a href="/admin/movies/delete/${movie.id}/"><i class="fas fa-trash-alt"></i></a></td>
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
            <c:if test="${currentPage > 1}">
                <li><a class="page-numbers" href="1">Đầu</a> </li>
                <li><a class="page-numbers" href="${currentPage - 1}">${currentPage - 1}</a> </li>
            </c:if>
            <li><span class="page-numbers current">${currentPage}</span> </li>
            <c:if test="${currentPage + 1 <= maxPage}">
                <li><a class="page-numbers" href="${currentPage + 1}">${currentPage + 1}</a> </li>
            </c:if>
            <c:if test="${currentPage + 2 <= maxPage}">
                <li><a class="page-numbers" href="${currentPage + 2}">${currentPage + 2}</a> </li>
            </c:if>
            <c:if test="${currentPage + 3 <= maxPage}">
                <li><a class="page-numbers" href="${currentPage + 3}">${currentPage + 3}</a> </li>
            </c:if>
            <c:if test="${currentPage + 4 <= maxPage}">
                <li><a class="page-numbers" href="${currentPage + 4}">${currentPage + 4}</a> </li>
            </c:if>
            <c:if test="${currentPage < maxPage}">
                <li><a class="page-numbers" href="${maxPage}">Cuối</a> </li>
            </c:if>
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
<script src="<c:url value="/resources/js/admin-common.js"/>"></script>
</body>
</html>
