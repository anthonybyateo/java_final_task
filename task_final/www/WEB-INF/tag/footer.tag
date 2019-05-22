<%@tag language="java" pageEncoding="UTF-8"%>

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
                    <h5 class="modal-title">Вход</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form method="POST">
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
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Имя">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Фамилия">
                        <input class="form-control mr-sm-2 btn-rounded" id="date" type="date" placeholder="Год рождения">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Логин">
                        <input class="form-control mr-sm-2 btn-rounded" type="text" placeholder="Почта">
                        <input class="form-control mr-sm-2 btn-rounded" type="password" placeholder="Password">
                        <input class="form-control mr-sm-2 btn-rounded" type="password" placeholder="Сonfirm password"><br>
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