<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Think</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="header sticky-top">
    <div class="pos-f-t">
        <nav class="navbar navbar-expand-lg navbar-light bg-white">
            <a class="navbar-brand" href="#">
                <img src="img/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <button type="button" class="btn btn-dark btn-rounded" data-toggle="modal" data-target="#exampleModal">Записать</button>
                    <li class="nav-item link">
                        <a href="popular_people.html">Популярные</a>
                    </li>
                    <li class="nav-item link">
                        <a href="subscriptions.html">Подписки</a>
                    </li>
                    <li class="nav-item link">
                        <a href="subscribers.html">Подписчики</a>
                    </li>
                    <li class="nav-item dropdown link">
                        <a class="dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Заметки
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Популярные</a>
                            <a class="dropdown-item" href="#">Последние</a>
                            <a class="dropdown-item" href="#">Читаемые</a>
                        </div>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2 btn-rounded" type="search" placeholder="Искать пользователя" aria-label="Search">
                    <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Поиск</button>
                </form>
                <div class="dropdown">
                    <a class="account" href="#" id="navbarDropdownAccount" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="img/profile.jpg" width="40" height="40" class="rounded-circle">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownAccount">
                        <a class="dropdown-item" href="profile.html">Моя страница</a>
                        <a class="dropdown-item" href="#">Редактировать</a>
                        <a class="dropdown-item" href="#">Выйти</a>
                    </div>
                </div>
            </div>
        </nav>
        <div class="collapse" id="navbarToggleExternalContent">
            <div class="bg-dark p-4">
                <h4 class="text-white">В разаработке</h4>
            </div>
        </div>
    </div>
</div> <!-- end header -->

<div class="main">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-12">
                <div class="card border-light mb-3">
                    <div class="card-header bg-white">Популярные заметки
                    </div>
                    <div class="card-body text-dark">
                        <div class="note">
                            <a href="#profile"><img src="img/profile.jpg" width="60" height="60" class="rounded-circle img-note"></a>
                            <p class="card-text"> <a href="#1">Джимм Керри</a> <span class="text-muted">· 4 мин</span></p>
                            <p class="info-user">Some quick example text to build on the card title and make up the bulk of the card's content. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et corporis fugit totam est delectus quam possimus nostrum numquam natus porro illum iusto labore eaque, aut sunt repudiandae aspernatur ab blanditiis. Beatae ullam asperiores fugiat est non placeat totam aliquid sequi doloribus impedit itaque similique enim sunt nulla animi veniam quos laudantium, dolores, expedita accusamus quisquam harum eaque. Qui quaerat tenetur odio quis quibusdam! Expedita aspernatur pariatur vero sunt, laudantium nobis, sint tempore culpa voluptatibus inventore et sed, laboriosam debitis provident consequatur impedit necessitatibus labore consequuntur! Enim officia non expedita nesciunt consequatur omnis velit maxime magnam, dolores magni ipsa dolorem?</p>
                            <div>
                                <a class="like" href="#like"><i class="fa fa-heart"></i></a>
                                <a class="comment" href="#comment"><i class="fa fa-comment"></i></a>
                            </div><hr>
                        </div>
                        <div class="note">
                            <img src="img/profile.jpg" width="60" height="60" class="rounded-circle img-note">
                            <p class="card-text"> <a href="#1">Джимм Керри</a> <span class="text-muted">· 4 мин</span><br>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <div>
                                <a class="like" href="#like"><i class="fas fa-heart"></i>like</a>
                                <a class="comment" href="#comment"><i class="fas fa-heart"></i>comment</a>
                            </div><hr>
                        </div>
                        <div class="note">
                            <img src="img/profile.jpg" width="60" height="60" class="rounded-circle img-note">
                            <p class="card-text"> <a href="#1">Джимм Керри</a> <span class="text-muted">· 4 мин</span><br>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <div>
                                <a class="like" href="#like"><i class="fas fa-heart"></i>like</a>
                                <a class="comment" href="#comment"><i class="fas fa-heart"></i>comment</a>
                            </div><hr>
                        </div>
                        <div class="note">
                            <img src="img/profile.jpg" width="60" height="60" class="rounded-circle img-note">
                            <p class="card-text"> <a href="#1">Джимм Керри</a> <span class="text-muted">· 4 мин</span><br>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <div>
                                <a class="like" href="#like"><i class="fas fa-heart"></i>like</a>
                                <a class="comment" href="#comment"><i class="fas fa-heart"></i>comment</a>
                            </div><hr>
                        </div>
                        <div class="note">
                            <img src="img/profile.jpg" width="60" height="60" class="rounded-circle img-note">
                            <p class="card-text"> <a href="#1">Джимм Керри</a> <span class="text-muted">· 4 мин</span><br>Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <div>
                                <a class="like" href="#like"><i class="fas fa-heart"></i>like</a>
                                <a class="comment" href="#comment"><i class="fas fa-heart"></i>comment</a>
                            </div><hr>
                        </div>

                        <nav class="">
                            <ul class="pagination justify-content-center">
                                <li class="page-item"><a class="page-link text-dark" href="#">Prev</a></li>
                                <li class="page-item"><a class="page-link text-dark" href="#">1</a></li>
                                <li class="page-item"><a class="page-link text-dark" href="#">2</a></li>
                                <li class="page-item"><a class="page-link text-dark" href="#">3</a></li>
                                <li class="page-item"><a class="page-link text-dark" href="#">Next</a></li>
                            </ul>
                        </nav>

                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="card border-light mb-3">
                    <div class="card-header bg-white">Актуальные темы</div>
                    <div class="card-body text-dark">
                        <div class="tag">
                            <a  href="">
                                <p class="card-text">#Евровидение<br> <span class="text-muted">Заметок:</span></p><hr>
                            </a>
                        </div>
                        <div class="tag">
                            <a  href="">
                                <p class="card-text">#Беларусь<br> <span class="text-muted">Заметок:</span></p><hr>
                            </a>
                        </div>
                        <div class="tag">
                            <a  href="">
                                <p class="card-text">#Дебаты<br> <span class="text-muted">Заметок:</span></p>
                            </a><hr>
                        </div>
                        <div class="tag">
                            <a  href="">
                                <p class="card-text">#Жизнь<br> <span class="text-muted">Заметок:</span></p>
                            </a><hr>
                        </div>
                        <div class="tag">
                            <a  href="">
                                <p class="card-text">#Спорт<br> <span class="text-muted">Заметок:</span></p>
                            </a><hr>
                        </div>
                        <form class="form-inline my-2 my-lg-0 justify-content-center">
                            <input class="form-control mr-sm-2 btn-rounded" type="search" placeholder="Искать запись" aria-label="Search">
                            <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Поиск</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    © Anthony, 2019

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Запись</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Тег" maxlength="25">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Тег" maxlength="25">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Тег" maxlength="25">
                        <div class="form-group">
                            <textarea class="form-control" id="message-text" placeholder="Что напишите?" rows="10" maxlength="250"></textarea>
                        </div>
                        <div class="justify-content-center">
                            <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Сделать запись</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="signinModal" tabindex="-1" role="dialog" aria-labelledby="signinModal" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Вход ${message}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:url value="/login.html" var="loginUrl"/>
                    <form method="POST" action="${loginUrl}">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Логин или email">
                        <input class="form-control mr-sm-2 btn-rounded" type="password" placeholder="Password"><br>
                        <div class="justify-content-center">
                            <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Войти</button>
                        </div>
                    </form>
                    <a href="" data-dismiss="modal" data-toggle="modal" data-target="#signupModal">Зарегистрироваться</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModal" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Регистрация</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="POST">
                        <input class="form-control mr-sm-2 btn-rounded" minlength="3" maxlength="40" type="text" placeholder="Имя" required>
                        <input class="form-control mr-sm-2 btn-rounded" minlength="3" maxlength="40" type="text" placeholder="Фамилия" required>
                        <input class="form-control mr-sm-2 btn-rounded" min="1900-01-01" max="2019-01-01" id="date" type="date" placeholder="Год рождения" required>
                        <input class="form-control mr-sm-2 btn-rounded" minlength="3" maxlength="32" type="text" placeholder="Логин" required>
                        <input class="form-control mr-sm-2 btn-rounded" type="email" placeholder="Почта" required>
                        <input class="form-control mr-sm-2 btn-rounded" minlength="6" maxlength="40" type="password" placeholder="Password" required>
                        <input class="form-control mr-sm-2 btn-rounded" minlength="6" maxlength="40" type="password" placeholder="Сonfirm password" required><br>
                        <input type="text" hidden value="/signup.html">
                        <div class="justify-content-center">
                            <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Зарегистрироваться</button>
                        </div>
                    </form>
                    <a href="" data-dismiss="modal" data-toggle="modal" data-target="#signinModal">Войти</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    if (document.location.href.indexOf('exampleModal') != -1) {
        $("#exampleModal").modal('show'); }
    if (document.location.href.indexOf('signinModal') != -1) {
        $("#signinModal").modal('show'); }
    if (document.location.href.indexOf('signupModal') != -1) {
        $("#signupModal").modal('show'); }
</script>
</body>
</html>
