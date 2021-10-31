<%@ page import="com.streammovies.model.movies.Movie" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2021
  Time: 4:29 PM
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
    <title>Xem phim ${movie.name}</title>
    <link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/reset-watch.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style-watch.css"/>">
    <!-- font awesome  -->
    <script src="https://kit.fontawesome.com/44ec9fb3c1.js" crossorigin="anonymous"></script>
</head>
<body class="home blog">
    <%@ include file="/WEB-INF/templates/header.jsp"%>

<div id="content">
    <div class="singlecontent minwidth">
        <div class="breadcrumb">
                <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="/">
                        <span class="breadcrumb-link-text-wrap">Trang Chủ</span>
                    </a>
                    </span>
            <span aria-label="breadcrumb separator"> / </span>
            <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="#">
                        <c:set var="content" value="Phim Bộ"></c:set>
                        <c:if test="${movie.amountEpisode == 1}">
                            <c:set var="content" value="Phim Lẻ"></c:set>
                        </c:if>
                        <span class="breadcrumb-link-text-wrap"> ${content}</span>
                    </a>
                </span>
            <span aria-label="breadcrumb separator"> / </span> ${movie.name}
        </div>
        <article class="hentry">
            <div class="bigplay">
                <iframe style="width: 100%;" src="${link.url}" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" allow="autoplay; fullscreen"></iframe>
            </div>
            <div class="infodb">
                <div class="infl">
                    <div class="list-sever" style="text-align:center; margin: 0;" >
                        <a href="1">
                            <c:if test="${link.serverId == 1}">
                                <div class="btn btn-success link-backup active">
                                    </c:if>
                            <c:if test="${link.serverId != 1}">
                                <div class="btn btn-success link-backup">
                                    </c:if>
                                VIP
                            </div>
                        </a>
                        <a href="2">
                            <c:if test="${link.serverId == 2}">
                                <div class="btn btn-success link-backup active">
                                    </c:if>
                            <c:if test="${link.serverId != 2}">
                                <div class="btn btn-success link-backup">
                                    </c:if>
                                    OK
                                </div>
                        </a>
                        <a href="3">
                            <c:if test="${link.serverId == 3}">
                                <div class="btn btn-success link-backup active">
                                    </c:if>
                            <c:if test="${link.serverId != 3}">
                                <div class="btn btn-success link-backup">
                                    </c:if>
                                    GO
                                </div>
                        </a>
                        <a href="4">
                            <c:if test="${link.serverId == 4}">
                                <div class="btn btn-success link-backup active">
                                    </c:if>
                            <c:if test="${link.serverId != 4}">
                                <div class="btn btn-success link-backup">
                                    </c:if>
                                    HYX
                                </div>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <br>
                    <div class="epg">
                        <h3>Phụ đề</h3>
                        <div class="epgl">
                            <ul class="movie-list-eps">
                                <c:forEach items="${listEpisode}" var="episode" varStatus="status">
                                    <li class="movie-episode">
                                        <c:if test="${episode.code.equals(episodeCode) == true}">
                                            <a href="/xem-phim/${movie.code}/${episode.code}/1" class="movie-episode active">
                                                <span class="box-shadow active">${status.index + 1}</span>
                                            </a>
                                        </c:if>
                                        <c:if test="${episode.code.equals(episodeCode) == false}">
                                            <a href="/xem-phim/${movie.code}/${episode.code}/1" class="movie-episode">
                                                <span class="box-shadow">${status.index + 1}</span>
                                            </a>
                                        </c:if>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <br>
                        <div class="left">
                            <div class="limage">
                                <img src="${movie.imageLinkPoster}" title="${movie.name}" alt="${movie.name}">
                            </div>
                            <div class="button-play">
                            </div>
                            <div class="rating-prc">
                                    <span class="hidden">
                                        <div class="rtp">
                                            <div class="rtb"><span style="width:50%"></span></div>
                                            <div class="rtd"> <span>3.8</span>/<span>140</span> votes</div>
                                        </div>
                                    </span>
                            </div>
                        </div>
                        <div class="right">
                            <h1 class="entry-title" style="color: red;">${movie.name}</h1>
                            <p class="name-en">${movie.englishName}</p>
                            <div class="socialts">
                                <a href="https://www.facebook.com/sharer/sharer.php?u=https://1ginz.github.io/netime/#" target="_blank" class="fb" rel="noopener">
                                    <i class="fab fa-facebook-f"></i>
                                    <span>Facebook</span>
                                </a>
                                <a href="https://www.twitter.com/intent/tweet?url=https://1ginz.github.io/netime/#" target="_blank" class="twt" rel="noopener">
                                    <i class="fab fa-twitter"></i>
                                    <span>Twitter</span>
                                </a>
                                <a href="whatsapp://send?text=G.I. Joe: Xà Nhãn Báo Thù https://1ginz.github.io/netime/#" target="_blank" class="wa">
                                    <i class="fab fa-whatsapp" rel="noopener"></i>
                                    <span>WhatsApp</span>
                                </a>
                                <a href="https://pinterest.com/pin/create/button/?url=https://bongngo.org/gi-joe-xa-nhan-bao-thu-9119.html&media=&description=G.I. Joe: Xà Nhãn Báo Thù" target="_blank" class="pntrs" rel="noopener">
                                    <i class="fab fa-pinterest-p"></i>
                                    <span>Pinterest</span>
                                </a>
                            </div>
                            <div class="entry-content" itemprop="description">
                                <p>${movie.shortContent}</p>
                                <ul class="data">
                                    <li><b>Đang phát</b> :
                                        <font color="red">Phụ đề</font>
                                    </li>
                                    <li>
                                        <b>Thể loại:</b>
                                        <c:forEach items="${movie.listCategory}" var="category">
                                            <a href="/the-loai/${category.code}" title="${category.name}">${category.name}</a>,
                                        </c:forEach>
                                    </li>
                                    <li><b>Quốc Gia:</b> <a href="/quoc-gia/${movie.national.code}" title="${movie.national.name}">${movie.national.name}</a> </li>
                                    <li><b>Diễn Viên:</b>
                                        <c:forEach items="${movie.listActor}" var="actor" varStatus="status">
                                        <span >
                                            <span><a rel="tag" href="/dien-vien/${actor.code}" title="Diễn Viên ${actor.name}">${actor.name}</a></span>
                                        </span><c:if test="${status.index != movie.listActor.size() - 1}">,</c:if>
                                        </c:forEach>
                                    </li>
                                    <li><b>Đạo Diễn:</b>
                                        <span>
                                                <span><a rel="tag" href="/dao-dien/${movie.director}/page/1" title="${movie.director}">${movie.director}</a></span>
                                            </span>
                                    </li>
                                    <li><b>Thời Lượng:</b>
                                        <c:if test="${movie.amountEpisode != 1}"><span>${movie.minutes} Phút / Tập</span></c:if>
                                        <c:if test="${movie.amountEpisode == 1}"><span>${movie.minutes} Phút</span></c:if>
                                    </li>
                                    <li><b>Năm:</b>
                                        <span>
                                                <time>
                                                    <a rel="tag" href="/nam-san-xuat/${movie.yearPublish}" title="Phim Năm ${movie.yearPublish}">${movie.yearPublish}</a>
                                                </time>
                                            </span>
                                    </li>
                                    <li><b>Điểm IMDb:</b>
                                        <span class="imdb">${movie.imdbScore}</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="clear"></div>
                        <div id="tags">
                            <h3><label>Keywords:</label>
                                <c:forEach items="${movie.listTagname}" var="tag" varStatus="status">
                                <span itemprop="keywords">
                                    <a href="#" title="${tag.name}">${tag.name}</a>
                                </span><c:if test="${status.index < movie.listTagname.size() - 1}">,</c:if>
                                </c:forEach>
                            </h3>
                        </div>
                        <div id="comment" class="cmt">
                            <h2 class="cmnt title-nav">Bình Luận Phim ${movie.name}</h2>
                            <div id="comments" class="bixbox comments-area">
                                <div class="fb-comments" data-colorscheme="light" data-href="https://code.ptit.edu.vn/" data-width="100%" data-numposts="5">Loading...</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="infr">
                    <div class="minfr">
                        <div class="bmarea">
                            <iframe style="max-width:100%;" width="560" height="315" src="${movie.trailerLink}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        </div>
                        <div class="epg">
                            <h2>PHIM LẺ XEM NHIỀU</h2>
                            <div class="epgl">
                                <ul>
                                    <c:forEach items="${listFeatureBestView}" var="movie">
                                        <li>
                                            <a href="/noi-dung/${movie.code}">
                                                <div class="l">
                                                    <div class="eptlx"><b>${movie.name}</b>
                                                    </div>
                                                    <div class="epdatex">${movie.englishName}</div>
                                                </div>
                                                <div class="r"><i class="fas fa-chevron-right"></i>
                                                </div>
                                            </a>
                                        </li>

                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="epg">
                            <h2>PHIM BỘ XEM NHIỀU</h2>
                            <div class="epgl">
                                <ul>
                                    <c:forEach items="${listSeriesBestView}" var="movie">
                                        <li>
                                            <a href="/noi-dung/${movie.code}">
                                                <div class="l">
                                                    <div class="eptlx"><b>${movie.name}</b>
                                                    </div>
                                                    <div class="epdatex">${movie.englishName}</div>
                                                </div>
                                                <div class="r"><i class="fas fa-chevron-right"></i>
                                                </div>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </article>
        <div class="latest relat">
            <div class="more">
                <h2 class="title-nav"><span>Phim Cùng Thể Loại</span></h2>
                <div class="clear"></div>
            </div>
            <div class="los">
                <c:forEach items="${listMovieSameName}" var="movie">

                    <article class="box">
                        <div class="bx">
                            <a href="/noi-dung/${movie.code}"  title="${movie.name}" alt="${movie.name}">
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
        </div>
    </div>
</div>
<div id="footer">
    <Copyright class="bgc">Copyright ©2021 NETIME</div>
</div>

<!-- jquery  -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/watch.js"/>"></script>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v12.0" nonce="yznNT322"></script>
</body>