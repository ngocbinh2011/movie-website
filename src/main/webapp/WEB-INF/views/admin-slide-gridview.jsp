<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/17/2021
  Time: 12:18 PM
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
              <form method="post" action="slide/add-movie/" class="form-inline my-2">
              <select id="" name="movieId" placeholder="Thể Loại" >
                <c:forEach items="${listMovie}" var="movie">
                  <option value="${movie.id}">${movie.id} - ${movie.name}</option>
                </c:forEach>

              </select>

              <label>link ảnh hiển thị trên slider</label>
              <input
                      class="form-control w-100"
                      type="text" name="imageSlide"
              />

              <button
                      class="btn ml-auto bg-teal text-white my-2"
                      type="submit"
              >
                Thêm Phim Vào Slide
              </button>
              </form>
              <h4 class="my-2 mb-3">Slide</h4>
              <table
                      class="table table-striped table-inverse"
              >
                <thead class="thead-inverse">
                <tr>
                  <th>STT</th>
                  <th>Id</th>
                  <th>Tên Phim</th>
                  <th>Image Phim</th>
                  <th>Ngày Tạo</th>
                  <th>Người Tạo</th>
                  <th>Ngày Sửa</th>
                  <th>Người Sửa</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovieSlider}" var="movieSlider" varStatus="status">
                  <tr>
                    <td>${status.index + 1}</td>
                    <td class="col-1">${movieSlider.movie.id}</td>
                    <td class="col-3">${movieSlider.movie.name}</td>
                    <td><img width="80" height="50" src="${movieSlider.imageLinkSlider}" alt=""></td>
                    <td class="col-2">${movieSlider.createDate}</td>
                    <td>${movieSlider.creator.username}</td>
                    <td class="col-2">${movieSlider.updateDate}</td>
                    <td>${movieSlider.updator.username}</td>
                    <td>
                      <a href="slide/delete/${movieSlider.id}/"><i class="fas fa-trash-alt"></i></a>
                    </td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>

            </div>

          </div>

        </div>

        <div  style="padding-top: 70px" class="row my-3">
          <div class="col-md-12">
            <div class="card p-3 shadow">
              <form method="post" action="grid/add-movie/1/" class="form-inline my-2">
              <select id="" name="movieId" placeholder="Thể Loại" >
                <c:forEach items="${listMovie}" var="movie">
                  <option value="${movie.id}">${movie.id} - ${movie.name}</option>
                </c:forEach>

              </select>


              <button
                      class="btn ml-auto bg-teal text-white my-2"
                      type="submit"
              >
                Thêm Phim Vào Grid 1
              </button>
                </form>
              <h4 class="my-2 mb-3">Grid 1</h4>
              <table
                      class="table table-striped table-inverse"
              >
                <thead class="thead-inverse">
                <tr>
                  <th>STT</th>
                  <th>Id</th>
                  <th>Tên Phim</th>
                  <th>Image Phim</th>
                  <th>Ngày Tạo</th>
                  <th>Người Tạo</th>
                  <th>Ngày Sửa</th>
                  <th>Người Sửa</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovieOfGrid1}" var="movie" varStatus="status">
                  <tr>
                    <td>${status.index + 1}</td>
                    <td class="col-1">${movie.id}</td>
                    <td class="col-3">${movie.name}</td>
                    <td><img width="80" height="50" src="${movie.imageLinkPoster}" alt=""></td>
                    <td class="col-2">${movie.createDate}</td>
                    <td>${movie.creator.username}</td>
                    <td class="col-2">${movie.updateDate}</td>
                    <td>${movie.updator.username}</td>
                    <td>
                      <a href="grid/delete/1/${movie.id}/"><i class="fas fa-trash-alt"></i></a>
                    </td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>

            </div>

          </div>
        </div>

        <div style="padding-top: 70px" class="row my-3">
          <div class="col-md-12">
            <div class="card p-3 shadow">
              <form method="post" action="grid/add-movie/2/" class="form-inline my-2">
              <select id="" name="movieId" placeholder="Thể Loại" >
                <c:forEach items="${listMovie}" var="movie">
                  <option value="${movie.id}">${movie.id} - ${movie.name}</option>
                </c:forEach>

              </select>



              <button
                      class="btn ml-auto bg-teal text-white my-2"
                      type="submit"
              >
                Thêm Phim Vào Grid 2
              </button>
                </form>
              <h4 class="my-2 mb-3">Grid 2</h4>
              <table
                      class="table table-striped table-inverse"
              >
                <thead class="thead-inverse">
                <tr>
                  <th>STT</th>
                  <th>Id</th>
                  <th>Tên Phim</th>
                  <th>Image Phim</th>
                  <th>Ngày Tạo</th>
                  <th>Người Tạo</th>
                  <th>Ngày Sửa</th>
                  <th>Người Sửa</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovieOfGrid2}" var="movie" varStatus="status">
                  <tr>
                    <td>${status.index + 1}</td>
                    <td class="col-1">${movie.id}</td>
                    <td class="col-3">${movie.name}</td>
                    <td><img width="80" height="50" src="${movie.imageLinkPoster}" alt=""></td>
                    <td class="col-2">${movie.createDate}</td>
                    <td>${movie.creator.username}</td>
                    <td class="col-2">${movie.updateDate}</td>
                    <td>${movie.updator.username}</td>
                    <td>
                      <a href="grid/delete/2/${movie.id}/"><i class="fas fa-trash-alt"></i></a>
                    </td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>

            </div>

          </div>
        </div>
        <div style="padding-top: 70px" class="row my-3">
          <div class="col-md-12">
            <div class="card p-3 shadow">
              <form method="post" action="grid/add-movie/3/" class="form-inline my-2">
              <select id="" name="movieId" placeholder="Thể Loại" >
                <c:forEach items="${listMovie}" var="movie">
                  <option value="${movie.id}">${movie.id} - ${movie.name}</option>
                </c:forEach>

              </select>



              <button
                      class="btn ml-auto bg-teal text-white my-2"
                      type="submit"
              >
                Thêm Phim Vào Grid 3
              </button>
                </form>
              <h4 class="my-2 mb-3">Grid 3</h4>
              <table
                      class="table table-striped table-inverse"
              >
                <thead class="thead-inverse">
                <tr>
                  <th>STT</th>
                  <th>Id</th>
                  <th>Tên Phim</th>
                  <th>Image Phim</th>
                  <th>Ngày Tạo</th>
                  <th>Người Tạo</th>
                  <th>Ngày Sửa</th>
                  <th>Người Sửa</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovieOfGrid3}" var="movie" varStatus="status">
                  <tr>
                    <td>${status.index + 1}</td>
                    <td class="col-1">${movie.id}</td>
                    <td class="col-3">${movie.name}</td>
                    <td><img width="80" height="50" src="${movie.imageLinkPoster}" alt=""></td>
                    <td class="col-2">${movie.createDate}</td>
                    <td>${movie.creator.username}</td>
                    <td class="col-2">${movie.updateDate}</td>
                    <td>${movie.updator.username}</td>
                    <td>
                      <a href="grid/delete/3/${movie.id}/"><i class="fas fa-trash-alt"></i></a>
                    </td>
                  </tr>
                </c:forEach>

                </tbody>
              </table>

            </div>

          </div>
        </div>
        <div style="padding-top: 70px" class="row my-3">
          <div class="col-md-12">
            <div class="card p-3 shadow">
              <form method="post" action="grid/add-movie/4/" class="form-inline my-2">
              <select id="" name="movieId" placeholder="Thể Loại" >
                <c:forEach items="${listMovie}" var="movie">
                  <option value="${movie.id}">${movie.id} - ${movie.name}</option>
                </c:forEach>

              </select>



              <button
                      class="btn ml-auto bg-teal text-white my-2"
                      type="submit"
              >
                Thêm Phim Vào Grid 4
              </button>
                </form>
              <h4 class="my-2 mb-3">Grid 4</h4>
              <table
                      class="table table-striped table-inverse"
              >
                <thead class="thead-inverse">
                <tr>
                  <th>STT</th>
                  <th>Id</th>
                  <th>Tên Phim</th>
                  <th>Image Phim</th>
                  <th>Ngày Tạo</th>
                  <th>Người Tạo</th>
                  <th>Ngày Sửa</th>
                  <th>Người Sửa</th>
                  <th>Xóa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listMovieOfGrid4}" var="movie" varStatus="status">
                  <tr>
                    <td>${status.index + 1}</td>
                    <td class="col-1">${movie.id}</td>
                    <td class="col-3">${movie.name}</td>
                    <td><img width="80" height="50" src="${movie.imageLinkPoster}" alt=""></td>
                    <td class="col-2">${movie.createDate}</td>
                    <td>${movie.creator.username}</td>
                    <td class="col-2">${movie.updateDate}</td>
                    <td>${movie.updator.username}</td>
                    <td>
                      <a href="grid/delete/4/${movie.id}/"><i class="fas fa-trash-alt"></i></a>
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

</body>
</html>
