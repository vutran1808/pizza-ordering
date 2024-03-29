<form action="loginServlet" class="form" method="post">
    <div class="form-group">
        <label for="email" class="form-label">Login (Email)</label>
        <input type="text" name="email" id="email" class="form-input">
    </div>
    <div class="form-group">
        <label for="password" class="form-label">Password</label>
        <input type="password" name="password" id="password" class="form-input">
    </div>
    <button class="form-submit-btn btn" type="submit">Log in</button>
</form>
<span class="form-seperate">- or -</span>
<div class="form__login--methods">
    <a href="#!" class="form__logins--item">
        <i class="fa-brands fa-facebook facebook-icon"></i>
        Facebook
    </a>
    <a href="#!" class="form__logins--item">
        <i class="fa-brands fa-apple"></i>
        Sign in with Apple
    </a>
    <a href="" class="form__logins--item">
        <i class="fa-brands fa-google"></i>
        Sign in with Google
    </a>
</div>
<div class="form__text">
    <a href="#!" class="form__text--title" modal="form-forgot-password.html">Forgot password</a>
    <a href="#!" class="form__text--title" modal="form-register.html">Create your account</a>
</div>