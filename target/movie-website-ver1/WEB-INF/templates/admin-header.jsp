<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/16/2021
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>

<header>
    <nav class="navbar navbar-expand-sm navbar-dark fixed-top bg-teal">
        <button class="navbar-toggler sideMenuToggler" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="/admin/home/">ADMIN DASHBOARD</a>

        <button
                class="navbar-toggler d-lg-none"
                type="button"
                data-toggle="collapse"
                data-target="#collapsibleNavId"
                aria-controls="collapsibleNavId"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <li class="nav-item mt-2">
                    <a class="nav-link" href="#"> <i class="fa fa-bell-o"></i></a>
                </li>
                <li class="nav-item mt-2">
                    <a class="nav-link" href="#">
                        <i class="fa fa-comment-o"></i>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle"
                            href="#"
                            id="dropdownId"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                    >
                        <img src="https://i.pinimg.com/564x/53/40/70/534070e3ff8746512d8fbaaa9aec68cb.jpg" alt="Avatar" class="avatar" />
                        <span class="username">ADMIN</span>
                    </a>
                    <div
                            class="dropdown-menu dropdown-menu-right"
                            aria-labelledby="dropdownId"
                    >
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-user-o"></i>
                            Profile
                        </a>

                        <a class="dropdown-item" href="#">
                            <i class="fa fa-bar-chart"></i>
                            Analytics
                        </a>

                        <a class="dropdown-item" href="#">
                            <i class="fa fa-money"></i>
                            Withdraw
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-shield"></i>
                            Settings & Privacy
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/admin/logout/">
                            <i class="fa fa-sign-out"></i>
                            Log Out
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- ##### End: Header Area ##### -->

<!-- ##### Main Area ##### -->
<!-- Main Wrapper -->
<div class="wrapper d-flex">
    <!-- Sidebar Menu -->
    <div class="side-menu">
        <div class="sidebar d-flex flex-column">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="#" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-th"></i
                        ><span class="text">Menu</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/movies/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-user"></i
                        ><span class="text">List Phim</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/categories/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-bar-chart"></i
                        ><span class="text">Thể Loại</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/actor/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-bug"></i
                        ><span class="text">Diễn Viên</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/slide-grid/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-user"></i
                        ><span class="text">Slide and GridView</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-inbox"></i
                        ><span class="text">User</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/admins/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-gear"></i
                        ><span class="text">Admin</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/settings/" class="nav-link px-2 text-primary">
                        <i class="side-menu-icon fa fa-compass"></i
                        ><span class="text">Settings</span>
                    </a>
                </li>
            </ul>
            <div class="sidebar-bottom">
                <!-- Toggle Menu -->
                <li class="nav-item toggler-icon text-center">
                    <a href="#" class="nav-link text-primary sideMenuToggler">
                        <i class="side-menu-icon fa fa-arrow-right"></i>
                    </a>
                </li>
            </div>
        </div>
    </div>
