<form action="accountServlet" class="form" method="post">
    <div class="form-row">
        <div class="form-group">
            <label for="firstname" class="form-label">First name</label>
            <input type="text" name="firstname" id="firstname" value="${firstname}" class="form-input">
        </div>
        <div class="form-group">
            <label for="lastname" class="form-label">Last name</label>
            <input type="text" name="lastname" id="lastname" class="form-input">
        </div>
    </div>
    <div class="form-group">
        <label for="city" class="form-label">City</label>
        <input type="text" name="city" id="city" class="form-input">
    </div>
    <div class="form-group">
        <label for="street" class="form-label">Street</label>
        <input type="text" name="street" id="street" class="form-input">
    </div>
    <div class="form-group">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" name="phone" id="phone" class="form-input">
    </div>
    <button type="submit" class="btn">Save</button>
</form>