<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Netime</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset-home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style-home.css"/>">
    <!-- font awesome  -->
    <script src="https://kit.fontawesome.com/44ec9fb3c1.js" crossorigin="anonymous"></script>
    <!-- boostrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body class="home blog">

    <%@ include file="/WEB-INF/templates/header.jsp"%>

<div class="slider">
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <ol class="carousel-controls">
            <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleControls" data-slide-to="1"></li>
            <li data-target="#carouselExampleControls" data-slide-to="2"></li>
            <li data-target="#carouselExampleControls" data-slide-to="3"></li>
            <li data-target="#carouselExampleControls" data-slide-to="4"></li>
            <li data-target="#carouselExampleControls" data-slide-to="5"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <a href="#">
                    <img class="d-block w-100" src="https://flxt.tmsimg.com/assets/p16808418_v_h9_aj.jpg" alt="First slide">
                </a>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://i3.wp.com/image.bongngocdn.com/upload/slide-tham-hiem-rung-xanh-2021.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="https://i3.wp.com/image.bongngocdn.com/upload/slide-cuoc-chien-tuong-lai-2021.jpg" alt="Third slide">
            </div>
            <div class="carousel-item">
                <a href="#">
                    <img class="d-block w-100" src="https://i3.wp.com/image.bongngocdn.com/upload/slide-qua-nhanh-qua-nguy-hiem-huyen-thoai-toc-do-2021.jpg" alt="Fourth slide">
                </a>
            </div>
            <div class="carousel-item">
                <a href="#">
                    <img class="d-block w-100" src="https://i3.wp.com/image.bongngocdn.com/upload/slide-goa-phu-den-2021.jpg" alt="Fourth slide">
                </a>
            </div>
            <div class="carousel-item">
                <a href="#">
                    <img class="d-block w-100" src="https://i3.wp.com/image.bongngocdn.com/upload/slide-godzilla-dai-chien-kong-2021.jpg" alt="Fourth slide">
                </a>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<div id="content">
    <div class="latest">
        <div class="more">
            <h2 class="more-title">${grid1.name}</h2><a href="/the-loai/${grid1.code}">Xem Thêm <i class="fas fa-angle-right"></i></a>
            <div class="clear"></div>
        </div>
        <div class="los">
            <c:forEach items="${listMovieOfGrid1}" var="movie">
                <article class="box">
                    <div class="bx">
                        <a href="/phim/${movie.code}" title="${movie.name}" alt="${movie.name}">
                            <div class="limit">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}" />
                                <div class="overlay"> <span class="quality -">HD</span>
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
    </div>
    <div class="latest">
        <div class="more">
            <h2  class="more-title">${grid2.name}</h2><a href="/the-loai/${grid2.code}">Xem Thêm <i class="fas fa-angle-right"></i></a>
            <div class="clear"></div>
        </div>
        <div class="los">
            <c:forEach items="${listMovieOfGrid2}" var="movie">
                <article class="box">
                    <div class="bx">
                        <a href="/phim/${movie.code}" title="${movie.name}" alt="${movie.name}">
                            <div class="limit">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}" />
                                <div class="overlay"> <span class="quality -">${movie.currentEpisode}/${movie.amountEpisode}</span>
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
    </div>
    <div class="latest">
        <div class="more">
            <h2  class="more-title">${grid3.name}</h2><a href="/the-loai/${grid3.code}">Xem Thêm <i class="fas fa-angle-right"></i></a>
            <div class="clear"></div>
        </div>
        <div class="los">
            <c:forEach items="#{listMovieOfGrid3}" var="movie">
                <article class="box">
                    <div class="bx">
                        <a href="/phim/${movie.code}" title="${movie.name}" alt="${movie.name}">
                            <div class="limit">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}" />
                                <div class="overlay"> <span class="quality -">HD</span>
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
    </div>
    <div class="latest">
        <div class="more">
            <h2  class="more-title">${grid4.name}</h2><a href="/the-loai/${grid4.code}">Xem Thêm <i class="fas fa-angle-right"></i></a>
            <div class="clear"></div>
        </div>
        <div class="los">
            <c:forEach items="${listMovieOfGrid4}" var="movie">
                <article class="box">
                    <div class="bx">
                        <a href="/phim/${movie.code}" title="${movie.name}" alt="${movie.name}">
                            <div class="limit">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}" />
                                <div class="overlay"> <span class="quality -">${movie.currentEpisode}/${movie.amountEpisode}</span>
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
    </div>
</div>
<div id="footer">
    <div class="bgc">Copyright ©2021 NETIME</div>
</div>

</div>
<!-- jquery  -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/home.js"/>"></script>
<!-- popper.js & boostrap  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>