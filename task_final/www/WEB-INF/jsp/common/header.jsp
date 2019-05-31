<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url var="popularPeople" value="popular_people.html"/>
<c:url var="profile" value="profile.html"/>
<c:url var="edit" value="edit.html"/>
<c:url var="logout" value="logout.html"/>

<c:set var="current" value="${param.language}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>
<fmt:bundle basename="text">

<div class="header sticky-top">
    <div class="pos-f-t">
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
                <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <button type="button" class="btn btn-dark btn-rounded" data-toggle="modal" data-target="#noteModal"><fmt:message key="nav.note"/></button>
                    <li class="nav-item link">
                        <a href="${popularPeople}"><fmt:message key="nav.popular"/></a>
                    </li>
                    <c:if test="${not empty authorizedUser}">
                        <li class="nav-item link">
                            <a href="#subscription"><fmt:message key="nav.subscriptions"/></a>
                        </li>
                        <li class="nav-item link">
                            <a href="friends.html"><fmt:message key="nav.subscribers"/></a>
                        </li>
                    </c:if>
                    <li class="nav-item dropdown link">
                        <a class="dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown">
                            <fmt:message key="nav.notes"/>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#"><fmt:message key="nav.popular"/></a>
                            <a class="dropdown-item" href="#"><fmt:message key="nav.latest"/></a>
                            <c:if test="${not empty authorizedUser}">
                                <a class="dropdown-item" href="#"><fmt:message key="nav.readable"/></a>
                            </c:if>
                        </div>
                    </li>

                    <li class="nav-item dropdown link">
                        <a class="dropdown-toggle" href="#"role="button" data-toggle="dropdown">
                            <fmt:message key="nav.language"/>
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/language=en_US">en</a>
                            <a class="dropdown-item" href="?language=ru_RU">ru</a>
                            <a class="dropdown-item" href="?language=de_DE">de</a>
                        </div>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0" method="POST">
                    <input class="form-control mr-sm-2 btn-rounded" name="search" type="search" placeholder="<fmt:message key="nav.language"/>">
                    <input type="hidden" name="actionPost" value="/findUser">
                    <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit"><fmt:message key="nav.search"/></button>
                </form>
                <c:if test="${empty authorizedUser}">
                    <button type="button" class="btn btn-dark btn-rounded ml-lg-2" data-toggle="modal" data-target="#signinModal">Вход</button>
                    <button type="button" class="btn btn-dark btn-rounded ml-lg-2" data-toggle="modal" data-target="#signupModal">Регистрация</button>
                </c:if>
                <c:if test="${not empty authorizedUser}">
                    <div class="dropdown">
                        <a class="account" href="#" id="navbarDropdownAccount" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/${authorizedUser.avatar}" width="40" height="40" class="rounded-circle">
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownAccount">
                            <a class="dropdown-item" href="${profile}?id=${authorizedUser.id}"><fmt:message key="nav.page"/>а</a>
                            <a class="dropdown-item" href="${edit}"><fmt:message key="nav.edit"/></a>
                            <a class="dropdown-item" href="${logout}"><fmt:message key="nav.logout"/></a>
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
</div>
</fmt:bundle>