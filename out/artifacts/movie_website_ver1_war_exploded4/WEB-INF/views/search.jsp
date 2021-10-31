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
    <title>Netime</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/reset-repository.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style-repository.css"/>">
    <!-- font awesome  -->
    <script src="https://kit.fontawesome.com/44ec9fb3c1.js" crossorigin="anonymous"></script>
</head>
<body class="home blog">

<%@ include file="/WEB-INF/templates/header.jsp"%>

<div id="content">
    <div class="breadcrumb">
                <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="#">
                        <span class="breadcrumb-link-text-wrap">Trang Chủ</span>
                    </a>
                <span aria-label="breadcrumb separator"> / </span>
                <span class="breadcrumb-link-wrap">
                    <a class="breadcrumb-link" href="#">
                        <span class="breadcrumb-link-text-wrap">quốc gia</span>
                    </a>
                <span aria-label="breadcrumb separator"> / </span> Phim Trung Quốc
    </div>
    <div class="latest">
        <div class="more">
            <h1>Tìm Kiếm: Name</h1>
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
                                        <option value="phim-chau-a">Phim Châu Á</option>
                                        <option value="phim-anh">Phim Anh</option>
                                        <option value="phim-phap">Phim Pháp</option>
                                        <option value="phim-chau-au">Phim Châu Âu</option>
                                        <option value="phim-khac">Phim Khác</option>
                                        <option value="phim-trung-quoc">Phim Trung Quốc</option>
                                        <option value="phim-duc">Phim Đức</option>
                                        <option value="phim-anh">Phim Anh</option>
                                        <option value="phim-han-quoc">Phim Hàn Quốc</option>
                                        <option value="phim-dai-loan">Phim Đài Loan</option>
                                        <option value="phim-hong-kong">Phim Hồng Kông</option>
                                        <option value="phim-nhat-ban">Phim Nhật Bản</option>
                                        <option value="phim-my">Phim Mỹ</option>
                                        <option value="phim-thai-lan">Phim Thái Lan</option>
                                        <option value="phim-an-do">Phim Ấn Độ</option>
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
            <article class="box">
                <div class="bx">
                    <a href="#" title="Chuyện Gì Xảy Ra Nếu Như...?" alt="Chuyện Gì Xảy Ra Nếu Như...?">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-se-ra-sao-neu-2021.jpg" title="Chuyện Gì Xảy Ra Nếu Như...?" alt="Chuyện Gì Xảy Ra Nếu Như...?" />
                            <div class="overlay"> <span class="quality -">Tập 2</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Chuyện Gì Xảy Ra Nếu Như...?</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Boruto: Naruto Thế Hệ Kế Tiếp" alt="Boruto: Naruto Thế Hệ Kế Tiếp">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster_boruto-naruto-the-he-ke-tiep.jpg" title="Boruto: Naruto Thế Hệ Kế Tiếp" alt="Boruto: Naruto Thế Hệ Kế Tiếp" />
                            <div class="overlay"> <span class="quality -">Tập 211</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Boruto: Naruto Thế Hệ Kế Tiếp</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="One Piece Đảo Hải Tặc" alt="One Piece Đảo Hải Tặc">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-one-piece-dao-hai-tac-1999.jpg" title="One Piece Đảo Hải Tặc" alt="One Piece Đảo Hải Tặc" />
                            <div class="overlay"> <span class="quality -">Tập 987</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">One Piece Đảo Hải Tặc</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Đấu La Đại Lục" alt="Đấu La Đại Lục">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster_dau-la-dai-luc-2018.jpg" title="Đấu La Đại Lục" alt="Đấu La Đại Lục" />
                            <div class="overlay"> <span class="quality -">Tập 169</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Đấu La Đại Lục</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Star Wars: Lực Lượng Nhân Bản 99" alt="Star Wars: Lực Lượng Nhân Bản 99">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-star-wars-luc-luong-nhan-ban-99-2021.jpg" title="Star Wars: Lực Lượng Nhân Bản 99" alt="Star Wars: Lực Lượng Nhân Bản 99" />
                            <div class="overlay"> <span class="quality -">16/16</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Star Wars: Lực Lượng Nhân Bản 99</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Hoàng Tử Ai Cập" alt="Hoàng Tử Ai Cập">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-hoang-tu-ai-cap-1998.jpg" title="Hoàng Tử Ai Cập" alt="Hoàng Tử Ai Cập" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Hoàng Tử Ai Cập</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Liên Quân Siêu Thú" alt="Liên Quân Siêu Thú">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-lien-quan-sieu-thu-2019.jpg" title="Liên Quân Siêu Thú" alt="Liên Quân Siêu Thú" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Liên Quân Siêu Thú</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Vua Pháp Thuật" alt="Vua Pháp Thuật">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-vua-phap-thuat-2021.jpg" title="Vua Pháp Thuật" alt="Vua Pháp Thuật" />
                            <div class="overlay"> <span class="quality -">13/13</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Vua Pháp Thuật</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Nữ Chiến Binh Amazon" alt="Nữ Chiến Binh Amazon">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-nu-chien-binh-amazon-2021.jpg" title="Nữ Chiến Binh Amazon" alt="Nữ Chiến Binh Amazon" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Nữ Chiến Binh Amazon</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 2" alt="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 2">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-thuy-thu-mat-trang-vinh-hang-phan-2-2021.jpg" title="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 2" alt="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 2" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 2</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 1" alt="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 1">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-thuy-thu-mat-trang-vinh-hang-phan-1-2021.jpg" title="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 1" alt="Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 1" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Thủy Thủ Mặt Trăng: Vĩnh Hằng Phần 1</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Người Dơi: Đêm Trường Halloween Phần 2" alt="Người Dơi: Đêm Trường Halloween Phần 2">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-nguoi-doi-dem-truong-halloween-phan-2-2021.jpg" title="Người Dơi: Đêm Trường Halloween Phần 2" alt="Người Dơi: Đêm Trường Halloween Phần 2" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Người Dơi: Đêm Trường Halloween Phần 2</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Võ Tòng Huyết Chiến Sư Tử Lâu" alt="Võ Tòng Huyết Chiến Sư Tử Lâu">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-vo-tong-huyet-chien-su-tu-lau-2021.jpg" title="Võ Tòng Huyết Chiến Sư Tử Lâu" alt="Võ Tòng Huyết Chiến Sư Tử Lâu" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Võ Tòng Huyết Chiến Sư Tử Lâu</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Hồi Sinh Ký Ức" alt="Hồi Sinh Ký Ức">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-hoi-sinh-ky-uc-2021.jpg" title="Hồi Sinh Ký Ức" alt="Hồi Sinh Ký Ức" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Hồi Sinh Ký Ức</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Lục Kỵ Sĩ" alt="Lục Kỵ Sĩ">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-luc-ky-si-2021.jpg" title="Lục Kỵ Sĩ" alt="Lục Kỵ Sĩ" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Lục Kỵ Sĩ</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Cô Gái Ngọt Ngào" alt="Cô Gái Ngọt Ngào">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-co-gai-ngot-ngao-2021.jpg" title="Cô Gái Ngọt Ngào" alt="Cô Gái Ngọt Ngào" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Cô Gái Ngọt Ngào</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Thiên Đường Đen" alt="Thiên Đường Đen">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-thien-duong-den-2010.jpg" title="Thiên Đường Đen" alt="Thiên Đường Đen" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Thiên Đường Đen</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Vũ Trụ Tội Lỗi" alt="Vũ Trụ Tội Lỗi">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-vu-tru-toi-loi-2021.jpg" title="Vũ Trụ Tội Lỗi" alt="Vũ Trụ Tội Lỗi" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Vũ Trụ Tội Lỗi</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Phù Thủy Tình Yêu" alt="Phù Thủy Tình Yêu">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-phu-thuy-tinh-yeu-2016.jpg" title="Phù Thủy Tình Yêu" alt="Phù Thủy Tình Yêu" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Phù Thủy Tình Yêu</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Cô Gái Da Trắng" alt="Cô Gái Da Trắng">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-co-gai-da-trang-2016.jpg" title="Cô Gái Da Trắng" alt="Cô Gái Da Trắng" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Cô Gái Da Trắng</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Lối Thoát Thông Minh" alt="Lối Thoát Thông Minh">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-loi-thoat-thong-minh-2021.jpg" title="Lối Thoát Thông Minh" alt="Lối Thoát Thông Minh" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Lối Thoát Thông Minh</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Lính Bắn Tỉa: Quyết Chiến Sinh Tử" alt="Lính Bắn Tỉa: Quyết Chiến Sinh Tử">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-linh-ban-tia-quyet-chien-sinh-tu-2020.jpg" title="Lính Bắn Tỉa: Quyết Chiến Sinh Tử" alt="Lính Bắn Tỉa: Quyết Chiến Sinh Tử" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Lính Bắn Tỉa: Quyết Chiến Sinh Tử</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="Vịnh Câm Lặng" alt="Vịnh Câm Lặng">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-vinh-cam-lang-2020.jpg" title="Vịnh Câm Lặng" alt="Vịnh Câm Lặng" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">Vịnh Câm Lặng</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
            <article class="box">
                <div class="bx">
                    <a href="#" title="G.I. Joe: Xà Nhãn Báo Thù" alt="G.I. Joe: Xà Nhãn Báo Thù">
                        <div class="limit">
                            <img src="https://i3.wp.com/image.bongngocdn.com/upload/poster-g-i-joe-xa-nhan-bao-thu-2021.jpg" title="G.I. Joe: Xà Nhãn Báo Thù" alt="G.I. Joe: Xà Nhãn Báo Thù" />
                            <div class="overlay"> <span class="quality -">HD</span>
                                <header class="ttl entry-header">
                                    <h3 class="entry-title">G.I. Joe: Xà Nhãn Báo Thù</h3>
                                </header>
                            </div>
                        </div>
                    </a>
                </div>
            </article>
        </div>
        <div class="pagination">
            <ul class='page-numbers'>
                <li><span class="page-numbers current">1</span> </li>
                <li><a class="page-numbers" href="#">2</a> </li>
                <li><a class="page-numbers" href="#">3</a> </li>
                <li><a class="page-numbers" href="#">4</a> </li>
                <li><a class="page-numbers" href="#">5</a> </li>
                <li><span class='page-numbers dots'>...</span> </li>
                <li><a class="page-numbers" href="#">Cuối</a> </li>
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