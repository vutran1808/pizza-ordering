<form action="registerServlet" class="form" method="post">
    <div class="form-group">
        <label for="email" class="form-label">Email *</label>
        <input type="text" name="email" id="email" class="form-input">
    </div>
    <div class="form-group">
        <label for="password" class="form-label">Password *</label>
        <input type="password" name="password" id="password" class="form-input">
    </div>
    <div class="form-group">
        <label for="password" class="form-label">Confirm password *</label>
        <input type="password" name="confirm-password" id="password" class="form-input">
    </div>
    <div class="form-group horizontal">
        <input type="checkbox" class="form-checkbox" name="" id="agree">
        <label for="agree" class="form-label">I agree to receiving commercial information at the given e-mail address (not obligatory)</label>
    </div>
    <button class="form-submit-btn btn" type="submit">Finish registration</button>
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
    <a href="#!" class="form__logins--item">
        <i class="fa-brands fa-google"></i>
        Sign in with Google
    </a>
</div>
<div class="form__text">
    <span class="form-label">ALready have an account? <a href="#!" class="form__text--title" modal="form-login.html">Login</a></span>
</div>