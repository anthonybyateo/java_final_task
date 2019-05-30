<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <div class="card-header bg-white">Популярные заметки <span class="error">${errorIn} ${errorUp}</span>
                    </div>
                    <div class="card-body text-dark">
                        <c:forEach var="user" items="${users}" varStatus="status">
                            <div class="note">
                                <a href="#profile"><img src="${pageContext.request.contextPath}/<c:out value='${user.avatar}'/>" width="60" height="60" class="rounded-circle img-note"></a>
                                <p class="card-text"> <a href="#1"><c:out value="${user.name}"/> <c:out value="${user.lastname}"/></a><br>
                                    <span class="text-muted">@<c:out value="${user.login}"/></span>
                                    <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0 btn-note" type="submit">Подписаться</button></p>
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

    /*    function value(passForm) {

            /!** This function is being used to find out the values input by the user in both the password and confirm password text boxes.
             * The results are fed back to the user using alerts.
             * **!/

            //check for lower case
            if (!passForm.passInput.value.match(/[a-z]/)) {
                alert("Password must contain at least one lower case letter.");
                passForm.passInput.focus();
                return false;
            }

            //Validating length
            if ((passForm.passInput.value).length < 8) {
                alert("Your password has less than 8 characters.");
                passForm.passInput.focus();
                return false;
            }

            //Validationg confirmation matches
            if (passForm.confirmPassInput.value != passForm.passInput.value) {
                alert("Your confirmation password does not match.");
                passForm.passInput.focus();
                return false;
            }

            //Validating confirmation input
            if (passForm.confirmPassInput.value == "") {
                alert("Please confirm your password.");
                passForm.passInput.focus();
                return false;
            }

            //check for upper ase
            if (!passForm.passInput.value.match(/[A-Z]/)) {
                alert("Password must contain at least one upper case letter.");
                passForm.passInput.focus();
                return false;
            }

            //check for number
            if (!passForm.passInput.value.match(/\d+/g)) {
                alert("Password must contain at least one number.");
                passForm.passInput.focus();
                return false;
            }


            //confirm passwords match and have been created
            if ((passForm.password.value) != (passForm.confpassword.value)) {
                alert("Your password has been created! hhhhhhhh");
                return true;
            }


        };*/
</script>
</body>
</html>
