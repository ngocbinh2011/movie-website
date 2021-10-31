<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2021
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <h1 style="padding-top: 20px">Tập Phim</h1>
            <div class="card p-3 shadow">
                <form action="#" method="post" class="form-inline my-2">
                    <label for="">Tập số:</label>
                    <input
                            class="form-control w-100"
                            type="text" name="" value="${episode.episodeNumber}"
                    />
                    <label for="">Mã code:</label>
                    <input
                            class="form-control w-100"
                            type="text" value="${episode.code}"
                    />


                    <button
                            class="btn ml-auto bg-teal text-white my-2"
                            type="submit"
                    >
                        Update Episode
                    </button>

                </form>
            </div>

            <h1 style="padding-top: 30px">Link Phim</h1>

            <div class="row my-3">
                <div class="col-md-12">
                    <div class="card p-3 shadow">
                        <form action="link/" method="post" class="form-inline my-2">
                            <label for="">Link 1 - Server VIP:</label>
                            <input
                                    class="form-control w-100"
                                    type="text" name="linkVip"
                                    value="${linkVip.url}"
                            />
                            <input type="hidden" name="idLinkVip" value="${linkVip.id}"/>
                            <label for="">Link 2 - Server OK:</label>
                            <input
                                    class="form-control w-100"
                                    type="text" name="linkOk"
                                    value="${linkOk.url}"
                            />
                            <input type="hidden" name="idLinkOk" value="${linkOk.id}"/>
                            <label for="">Link 3 - Server GO:</label>
                            <input
                                    class="form-control w-100"
                                    type="text" name="linkGo"
                                    value="${linkGo.url}"
                            />
                            <input type="hidden" name="idLinkGo" value="${linkGo.id}"/>
                            <label for="">Link 4 - Server HYX</label>
                            <input
                                    class="form-control w-100"
                                    type="text" name="linkHyx"
                                    value="${linkHyx.url}"
                            />
                            <input type="hidden" name="idLinkHyx" value="${linkHyx.id}"/>
                            <button
                                    class="btn ml-auto bg-teal text-white my-2"
                                    type="submit"
                            >
                                Update Link
                            </button>

                        </form>
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

