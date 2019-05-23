<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

subscribers

<form method="POST">
    <input class="form-control mr-sm-2 btn-rounded" minlength="3" maxlength="40" type="text" placeholder="Имя" required>
    <input class="form-control mr-sm-2 btn-rounded" minlength="3" maxlength="40" type="text" placeholder="Фамилия" required>
    <input class="form-control mr-sm-2 btn-rounded" min="1900-01-01" max="2019-01-01" id="date" type="date" placeholder="Год рождения:" required>
    <input class="form-control mr-sm-2 btn-rounded" name="login" minlength="3" maxlength="32" type="text" placeholder="Логин" required>
    <input class="form-control mr-sm-2 btn-rounded" type="email" placeholder="Почта" required>
    <input class="form-control mr-sm-2 btn-rounded" minlength="6" maxlength="40" type="password" placeholder="Password" required>
    <input class="form-control mr-sm-2 btn-rounded" minlength="6" maxlength="40" type="password" placeholder="Сonfirm password" required><br>
    <input type="hidden" name="command" value="test">
    <div class="justify-content-center">
        <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Зарегистрироваться</button>
    </div>
</form>