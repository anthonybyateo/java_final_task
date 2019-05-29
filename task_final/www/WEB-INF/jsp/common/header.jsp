<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header sticky-top">
    <div class="pos-f-t">
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="#">
                <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <button type="button" class="btn btn-dark btn-rounded" data-toggle="modal" data-target="#noteModal">Записать</button>
                    <li class="nav-item link">
                        <a href="popular_people.html">Популярные</a>
                    </li>
                    <c:if test="${not empty authorizedUser}">
                        <li class="nav-item link">
                            <a href="#subscription">Подписки</a>
                        </li>
                        <li class="nav-item link">
                            <a href="friends.html">Подписчики</a>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown link">
                        <a class="dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">
                            Заметки
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Популярные</a>
                            <a class="dropdown-item" href="#">Последние</a>
                            <c:if test="${not empty authorizedUser}">
                                <a class="dropdown-item" href="#">Читаемые</a>
                            </c:if>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2 btn-rounded" type="search" placeholder="Искать пользователя" aria-label="Search">
                    <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Поиск</button>
                </form>
                <c:if test="${empty authorizedUser}">
                    <button type="button" class="btn btn-dark btn-rounded ml-lg-2" data-toggle="modal" data-target="#signinModal">Вход</button>
                    <button type="button" class="btn btn-dark btn-rounded ml-lg-2" data-toggle="modal" data-target="#signupModal">Регистрация</button>
                </c:if>
                <c:if test="${not empty authorizedUser}">
                    <div class="dropdown">
                        <a class="account" href="#" id="navbarDropdownAccount" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="img/profile.jpg" width="40" height="40" class="rounded-circle">
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownAccount">
                            <a class="dropdown-item" href="${profile}">Моя страница</a>
                            <a class="dropdown-item" href="${edit}">Редактировать</a>
                            <a class="dropdown-item" href="${logout}">Выйти</a>
                        </div>
                    </div>
                </c:if>
            </div>
        </nav>
        <div class="collapse" id="navbarToggleExternalContent">
            <div class="bg-dark p-4">
                <h4 class="text-white">В разаработке</h4>
            </div>
        </div>
    </div>
</div> <!-- end header -->