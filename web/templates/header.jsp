<header class="header">
    <div class="container">
        <div class="header__inner">
            <!-- Logo -->
            <a href="index.jsp">
                <div class="logo">
                    <img src="assets/images/logo.png" alt="Express Pizza Italy" class="logo-img" />
                </div>
            </a>

            <!-- Navbar -->
            <nav class="navbar">
                <ul class="navbar__list">
                    <li class="navbar__item ">
                        <a href="index.jsp" class="navbar__link">Home</a>
                    </li>
                    <li class="navbar__item ">
                        <a href="about-us.jsp" class="navbar__link">About us</a>
                    </li>
                    <li class="navbar__item ">
                        <a href="contact.jsp" class="navbar__link">Contact</a>
                    </li>
                    <li class="navbar__item ">
                        <a href="orderServlet" class="navbar__link">Order online</a>
                    </li>
                </ul>
                <div class="navbar__line"></div>
            </nav>

            <!-- profile -->
            <div class="profile hide js-toggle" toggle-target=".profile">
                <div class="profile-wrapper">
                    <div class='profile-icon'>
                        <i class="fa-regular fa-user"></i>
                    </div>
                </div>
                <!-- Dropdown -->
                <div class="dropdown">
                    <div class="dropdown__inner">
                        <ul class="dropdown-list">
                            <%
                                if( session.getAttribute("isSigned") != null &&
                                    Boolean.parseBoolean(session.getAttribute("isSigned").toString()) == true) {
                            %>
                                <a href="#!"><li class="dropdown__item" modal="your-account.jsp">Your account</li></a>
                                <a href="logoutServlet"><li class="dropdown__item">Log out</li></a>
                            <%
                                } else {
                            %>
                                <li class="dropdown__item" modal="form-login.jsp">Sign in</li>
                                <li class="dropdown__item" modal="form-register.jsp">Register</li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Overlay -->
        <div class="overlay hide">
            <!-- Login Modal -->
            <div class="form-modal">
                    <i class="fa-solid fa-xmark form-close-btn"></i>
                    <div class="form__container"></div>
            </div>
        </div>
    </div>
</header>

