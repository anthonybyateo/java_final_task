<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

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
<jsp:include page="WEB-INF/jsp/common/header.jsp" />
<div class="main">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-12">
                <div class="card border-light mb-3">
                    <div class="card-header bg-white">Описание проекта:<span class="error">${errorIn} ${errorUp}</span>
                    </div>
                    <div class="card-body text-dark">
                        <p>Социальная сеть Приложение предназначено для публикации коротких заметок в формате блога. Заметки размещаются на стене пользователя. Другие пользователи могут комментировать заметки, а также оценивать их через систему лайков. Также к заметкам можно добавлять теги, которые определяют тематику написанной заметки, и по которым можно найти заметки. Также существует система подписок на других пользователей для того, чтобы читать заметки интересующего человека. На странице есть блок, в котором отображаются самые популярные заметки пользователей, на которых вы подписаны.</p>
                    </div>
                </div>
            </div>
            <jsp:include page="WEB-INF/jsp/common/aside.jsp" />
        </div>
    </div>
</div>
<jsp:include page="WEB-INF/jsp/common/footer.jsp" />
</body>
</html>
