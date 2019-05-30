<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="common/header.jsp" />
<div class="main">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-12">
                <div class="card border-light mb-3">
                    <div class="card-header bg-white">
                        <img src="img/profile.jpg" width="170" height="170" class="rounded-circle img-note">
                        <p><span>${authorizedUser.name} ${authorizedUser.lastname}</span><br>
                            <span class="text-muted">@${authorizedUser.login}</span>
                        <form class="form" method="POST" enctype="multipart/form-data">
                            <input type="hidden" name="actionPost" value="/changePhoto">
                            <button class="btn btn-dark btn-rounded" type="submit">Change photo</button>
                        </form>
                        </p>
                    </div>
                    <div class="card-header bg-white">Редактор аккаунта<span class="error">${errorEdit} ${euser}</span>
                    </div>
                    <div class="card-body text-dark">
                        <form class="form" method="POST" name="passForm">
                            <input class="form-control mr-sm-2 btn-rounded" name="name" value="${authorizedUser.name}" minlength="3" maxlength="40" type="text" placeholder="Имя" required>
                            <input class="form-control mr-sm-2 btn-rounded" name="lastname" value="${authorizedUser.lastname}" minlength="3" maxlength="40" type="text" placeholder="Фамилия" required>
                            <input class="form-control mr-sm-2 btn-rounded" name="birthday" value="${authorizedUser.birthday}" min="1900-01-01" max="2019-01-01" id="date" type="date" placeholder="Год рождения:" required>
                            <input type="hidden" name="actionPost" value="/edit">
                            <div class="justify-content-center">
                                <button class="btn btn-dark btn-rounded" type="submit">Edit</button>
                                <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0 reset" type="reset">Reset</button>
                            </div>
                        </form>
                        <br>
                        <hr>
                        <form class="form" method="POST" name="passForm">
                            <input class="form-control mr-sm-2 btn-rounded" name="password" minlength="6" maxlength="40" type="password" placeholder="Old password" required>
                            <input class="form-control mr-sm-2 btn-rounded" name="newPassword" minlength="6" maxlength="40" type="password" placeholder="New password" required>
                            <input class="form-control mr-sm-2 btn-rounded" name="confNewPassword" minlength="6" maxlength="40" type="password" placeholder="Сonfirm new password" required><br>
                            <input type="hidden" name="actionPost" value="/changePassword">
                            <button class="btn btn-dark btn-rounded" type="submit">Edit</button>
                        </form>
                    </div>
                </div>
            </div>
            <jsp:include page="common/aside.jsp" />
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp" />
</body>
</html>
