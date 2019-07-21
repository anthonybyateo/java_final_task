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
<jsp:include page="common/header.jsp" />
<div class="main">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-12">
                <div class="card border-light mb-3">
                    <div class="card-header bg-white">Популярные заметки <span id="auth-info"></span>${test} <span class="error">${errorIn} ${errorUp}</span>
                    </div>
                    <div class="card-body text-dark">
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <div class="note">
                                <a href="#profile"><img src="${pageContext.request.contextPath}/<c:out value='${user.avatar}'/>" width="60" height="60" class="rounded-circle img-note"></a>
                                <p class="card-text"> <a href="#1"><c:out value="${user.name}"/> <c:out value="${user.lastname}"/></a><br>
                                    <span class="text-muted">@<c:out value="${user.login}"/></span>
                                    <c:if test = "${not empty friend}">
                                        <button id="unsubscribe${user.id}" class="btn btn-outline-danger btn-rounded my-2 my-sm-0 btn-note unsub" style="display: block" type="submit">Отписаться</button>
                                        <button id="subscribe${user.id}" class="btn btn-outline-dark btn-rounded my-2 my-sm-0 btn-note sub" style="display: none" type="submit">Подписаться</button>
                                    </c:if>
                                    <c:if test = "${empty friend}">
                                        <button id="unsubscribe${user.id}" class="btn btn-outline-danger btn-rounded my-2 my-sm-0 btn-note unsub" style="display: none" type="submit">Отписаться</button>
                                        <button id="subscribe${user.id}" class="btn btn-outline-dark btn-rounded my-2 my-sm-0 btn-note sub" style="display: block" type="submit">Подписаться</button>
                                    </c:if>
                                </p>
                                <p class="info-user">
                                    <a href="">Заметки: 10</a><br>
                                    <a href="">Подписчики: ${subscribers[status.index]}</a>
                                </p><hr>
                            </div>
                        </c:forEach>
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
            <jsp:include page="common/aside.jsp" />
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp" />
<script>
    $(document).ready(function(){
        $(".sub").click(function(){
            var data = {"actionPost":"/subscribe"};
            //data = {"login":$("#login").val(), "password":$("#password").val()};
            //
            var id = $(this).attr('id');
            var num = "7";
            $.ajax
            ({
                type: "POST",//Метод передачи
                dataType: 'text',
                data: data,//Передаваемые данные в JSON - формате
                url: '',//Название сервлета pageContext.request.contextPath/edit.html
                success:function(data)//Если запрос удачен
                {
                    //alert(data);
                    //$("#auth-info").css({"background-color":serverData.backgroundColor, "height": "50px", "color":"white"});
                    foo = 7;
                    $("#auth-info").html(data + "//" + id);
                    $("#" + id).css({"display": "none"});
                    $("#un" + id).css({"display": "block"});
                    //alert(id);
                },
                error: function(e)//Если запрос не удачен
                {
                    alert("error" + e);
                    //$("#auth-info").css({"background-color":"#CC6666", "height": "50px", "color":"white"});
                    //$("#auth-info").html("Запрос не удался!");
                }
            });
        });
    });

</script>
</body>
</html>
