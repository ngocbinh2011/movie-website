<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="main-menu" class="site-header" role="banner">
    <div class="centernav">
        <div class="bound">
            <div class="logo">
                <a href="/" title="Netime" rel="home">
                    <img src="<c:url value="/resources/image/logo.png"/>" alt="" rel="home" />
                </a>
            </div>
            <label for="show-menu" class="show-menu"><i class="fas fa-bars"></i></label>
            <span role="navigation">
                    <ul id="menu-menu" class="menu">
                        <li class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home">
                            <a href="/" aria-current="page"><span>TRANG CHỦ</span></a>
                        </li>
                        <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children"><a href="#"><span>THỂ LOẠI</span></a>
                            <ul class="sub-menu">
                        <c:forEach items="${headerCategory}" var="category">
                            <li class="menu-item menu-item-type-taxonomy menu-item-object-country"><a title="${category.name}" href="/the-loai/${category.code}">Phim ${category.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children"><a href="#"><span>QUỐC GIA</span></a>
                    <ul class="sub-menu">
                        <c:forEach items="${headerNational}" var="national">
                            <li class="menu-item menu-item-type-taxonomy menu-item-object-country"><a title="${national.name}" href="/quoc-gia/${national.code}">Phim ${national.name}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children"><a href="#"><span>PHIM LẺ</span></a>
                    <ul class="sub-menu">
                        <c:forEach items="${headerListYear}" var="year">
                            <li class="menu-item menu-item-type-taxonomy menu-item-object-country"><a title="${year}" href="/phim-le/${year}">Năm ${year}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children"><a href="#"><span>PHIM BỘ</span></a>
                    <ul class="sub-menu">
                        <c:forEach items="${headerNational}" var="national">
                            <li class="menu-item menu-item-type-taxonomy menu-item-object-country"><a title="${national.name}" href="/phim-bo/${national.code}">${national.name}</a></li>
                        </c:forEach>

                    </ul>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="/top-phim-imdb"><span>TOP IMDb</span></a>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page"><a href="#"><span>TÀI KHOẢN</span></a>
                </li>
                    </ul>
                    </span>
            <div class="searchx">
                <form action="" id="form" method="get">
                    <input type="search" class="search-live" maxlength="256" placeholder="Nhập từ khóa" id="s"/>
                    <button type="submit" id="submit"><i class="fas fa-search"></i>
                    </button>
                </form>
            </div>
            <div class="ms"><i class="fas fa-search"></i>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</header>