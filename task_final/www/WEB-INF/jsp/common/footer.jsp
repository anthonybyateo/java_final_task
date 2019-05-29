<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="footer">
    © Anthony, 2019

    <div class="modal fade" id="noteModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Запись</h5>
                    <button type="button" class="close" data-dismiss="modal">
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

    <div class="modal fade" id="signinModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Вход</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="error">${errorIn}</div>
                <div class="modal-body">
                    <form method="POST">
                        <input class="form-control mr-sm-2 btn-rounded" type="email" name="email" minlength="3" maxlength="32" placeholder="Email" required>
                        <input class="form-control mr-sm-2 btn-rounded" type="password" name="password" minlength="6" maxlength="40" placeholder="Password" required><br>
                        <input type="hidden" name="actionPost" value="/login">
                        <div class="justify-content-center">
                            <button class="btn btn-outline-dark btn-rounded my-2 my-sm-0" type="submit">Войти</button>
                        </div>
                    </form>
                    <a href="" data-dismiss="modal" data-toggle="modal" data-target="#signupModal">Зарегистрироваться</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="signupModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Регистрация</h5>
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="error">${errorUp}</div>
                <div class="modal-body">
                    <form method="POST" name="passForm">
                        <input class="form-control mr-sm-2 btn-rounded" name="name" minlength="3" maxlength="40" type="text" placeholder="Имя" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="lastname" minlength="3" maxlength="40" type="text" placeholder="Фамилия" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="birthday" min="1900-01-01" max="2019-01-01" id="date" type="date" placeholder="Год рождения:" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="login" minlength="3" maxlength="32" type="text" placeholder="Логин" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="email" type="email" placeholder="Почта" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="password" minlength="6" maxlength="40" type="password" placeholder="Password" required>
                        <input class="form-control mr-sm-2 btn-rounded" name="confPassword" minlength="6" maxlength="40" type="password" placeholder="Сonfirm password" required><br>
                        <input type="hidden" name="actionPost" value="/signup">
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