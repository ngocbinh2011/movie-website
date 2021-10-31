<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/10/2021
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Phim diễn viên ${headerContent}</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value="/resources/css/reset-repository.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style-repository.css"/>">
    <!-- font awesome  -->
    <script src="https://kit.fontawesome.com/44ec9fb3c1.js" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="/WEB-INF/templates/header.jsp"%>

<div id="content">
    <div class="breadcrumb">
                <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="/">
                        <span class="breadcrumb-link-text-wrap">Trang Chủ</span>
                    </a>
                <span aria-label="breadcrumb separator"> / </span>
                <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="#">
                        <span class="breadcrumb-link-text-wrap">Phim Mới</span>
                    </a>
                <span aria-label="breadcrumb separator"> / </span> Phim CỦA ${headerContent}
    </div>
    <div class="latest">
        <div class="more">
            <h1>Phim CỦA ${headerContent}</h1>
            <div class="filterm"><i class="fas fa-filter"></i> Filter</div>
            <div class="bigfilter">
                <div class="movie-search-filter">
                    <div class="btn-group col-md-12">
                        <form id="form-filter" class="form-inline" method="get" action="">
                            <div class="col-md-2 col-xs-12 col-sm-6">
                                <div class="filter-box">
                                    <div class="filter-box-title">Sắp xếp</div>
                                    <select class="form-control" id="filter-sort" name="sort">
                                        <option value="updatetime">Cập nhật</option>
                                        <option value="popular">Lượt xem</option>
                                        <option value="new">Thời gian đăng</option>
                                        <option value="year">Năm sản xuất</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-2 col-xs-12 col-sm-6">
                                <div class="filter-box">
                                    <div class="filter-box-title">Định dạng</div>
                                    <select class="form-control" id="filter-type" name="type">
                                        <option value="">Định Dạng</option>
                                        <option value="phim-moi">Phim mới</option>
                                        <option value="phim-le">Phim lẻ</option>
                                        <option value="phim-bo">Phim bộ</option>
                                        <option value="phim-chieu-rap-online">Phim rạp</option>
                                        <option value="phim-tv-show">TV Show</option>
                                        <option value="phim-18">Phim 18+</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-2 col-xs-12 col-sm-6">
                                <div class="filter-box">
                                    <div class="filter-box-title">Thể loại</div>
                                    <select class="form-control" id="filter-category" name="category">
                                        <option value="">Thể Loại</option>
                                        <option value="phim-18">Phim 18+</option>
                                        <option value="the-thao">Phim Thể Thao</option>
                                        <option value="than-thoai">Phim Thần Thoại</option>
                                        <option value="hai-huoc">Phim Hài Hước</option>
                                        <option value="phim-co-trang">Phim Cổ Trang</option>
                                        <option value="phim-khoa-hoc">Phim Khoa Học</option>
                                        <option value="phim-kinh-dien">Phim Kinh Điển</option>
                                        <option value="the-thao">Phim Thể Thao</option>
                                        <option value="giat-gan"> Phim Giật Gân</option>
                                        <option value="lich-su">Phim Lịch sử</option>
                                        <option value="tham-hoa">Phim Thảm Họa</option>
                                        <option value="kiem-hiep">Phim Kiếm Hiệp</option>
                                        <option value="phieu-luu">Phim Phiêu Lưu</option>
                                        <option value="hoat-hinh">Phim Hoạt Hình</option>
                                        <option value="gia-dinh-hoc-duong">Gia Đình - Học Đường</option>
                                        <option value="chien-tranh">Phim Chiến Tranh</option>
                                        <option value="tam-ly">Phim Tâm Lý</option>
                                        <option value="da-su">Phim Dã Sữ</option>
                                        <option value="tinh-cam">Phim Tình Cảm</option>
                                        <option value="tu-lieu">Phim Tư Liệu</option>
                                        <option value="tv-show">Phim TV Show</option>
                                        <option value="vien-tuong">Phim Viễn Tưỡng</option>
                                        <option value="vo-thuat">Phim Võ Thuật</option>
                                        <option value="kinh-di">Phim Kinh Dị</option>
                                        <option value="vien-tay">Phim Viễn Tây</option>
                                        <option value="am-nhac">Phim Âm Nhạc</option>
                                        <option value="hinh-su">Phim Hình Sự</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-2 col-xs-12 col-sm-6">
                                <div class="filter-box">
                                    <div class="filter-box-title">Quốc gia</div>
                                    <select class="form-control" id="filter-country" name="country">
                                        <option value="">Quốc Gia</option>
                                        <option value="malaysia">Malaysia</option>
                                        <option value="chau-a">Phim Châu Á</option>
                                        <option value="anh">Phim Anh</option>
                                        <option value="phap">Phim Pháp</option>
                                        <option value="chau-au">Phim Châu Âu</option>
                                        <option value="khac">Phim Khác</option>
                                        <option value="trung-quoc">Phim Trung Quốc</option>
                                        <option value="duc">Phim Đức</option>
                                        <option value="anh">Phim Anh</option>
                                        <option value="han-quoc">Phim Hàn Quốc</option>
                                        <option value="dai-loan">Phim Đài Loan</option>
                                        <option value="hong-kong">Phim Hồng Kông</option>
                                        <option value="nhat-ban">Phim Nhật Bản</option>
                                        <option value="my">Phim Mỹ</option>
                                        <option value="thai-lan">Phim Thái Lan</option>
                                        <option value="an-do">Phim Ấn Độ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-1 col-xs-12 col-sm-6">
                                <div class="filter-box">
                                    <div class="filter-box-title">Năm</div>
                                    <select class="form-control" id="filter-year" name="release">
                                        <option value="">Năm</option>
                                        <option value="2021">2021</option>
                                        <option value="2020">2020</option>
                                        <option value="2019">2019</option>
                                        <option value="2018">2018</option>
                                        <option value="2017">2017</option>
                                        <option value="2016">2016</option>
                                        <option value="2015">2015</option>
                                        <option value="2014">2014</option>
                                        <option value="2013">2013</option>
                                        <option value="2012">2012</option>
                                        <option value="2011">2011</option>
                                        <option value="2010">2010</option>
                                        <option value="2009">2009</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-2 col-xs-12 col-sm-6">
                                <button type="submit" id="btn-movie-filter" class="btn btn-danger">Lọc phim</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="los">
            <c:forEach items="${listMovie}" var="movie">
                <article class="box">
                    <div class="bx">
                        <a href="/noi-dung/${movie.code}" title="${movie.name}" alt="${movie.name}">
                            <div class="limit">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}" />
                                <c:set var="status" value="HD"></c:set>
                                <c:if test="${movie.amountEpisode > 1}">
                                    <c:set var="status" value="${movie.currentEpisode}/${movie.amountEpisode}"></c:set>
                                </c:if>
                                <div class="overlay"> <span class="quality -">${status}</span>
                                    <header class="ttl entry-header">
                                        <h3 class="entry-title">${movie.name}</h3>
                                    </header>
                                </div>
                            </div>
                        </a>
                    </div>
                </article>
            </c:forEach>

        </div>
        <div class="pagination">
            <ul class='page-numbers'>
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
        <div class="clear"></div>
    </div>
</div>
<div id="footer">
    <div class="bgc">Copyright ©2021 NETIME</div>
</div>
<!-- jquery  -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/repository.js"/>"></script>
</body>
</html>