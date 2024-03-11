<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="./assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assets/favicon/site.webmanifest">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">

    <!-- Embed Font -->
    <link rel="stylesheet" href="./assets/font/stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sora:wght@100..800&display=swap" rel="stylesheet">

    <!-- SCSS -->
    <link rel="stylesheet" href="./assets/css/main.css">

    <!-- Fontawesome -->
    <link rel="stylesheet" href="./assets/fontawesome/css/all.min.css">

    <!-- Script -->
    <script src="./assets/js/script.js"></script>
    <title>About us</title>
</head>
<body>
    <!-- Header -->
    <header id="header"></header>
    <script>
        load("#header", "./templates/header.jsp");
    </script>

    <main class="about">
        <!-- Hero -->
        <section class="hero">
            <h1 class="section__heading--main about__heading">About us</h1>
            <span class="section__heading white">THE BEST PIZZAS IN THE CITY</span>
        </section>

        <!-- Subhero -->
        <section class="sub-hero">
            <div class="container">
                <div class="sub-hero__inner">
                    <div class="sub-hero__content">
                        <h4 class="sub-hero__heading">Thin crust dough</h4>
                        <p class="section__desc sub-hero__desc">The dough of an Italian pizza should be thin, and the edges should be fluffy in the middle and crispy on the outside.</p>
                    </div>
                    <div class="sub-hero__wrapper">
                        <img src="assets/images/about-sub-hero.jpg" alt="Loading" class="sub-hero__img">
                    </div>
                    <div class="sub-hero__content">
                        <h4 class="sub-hero__heading">
                            Excellent toppings</h4>
                        <p class="section__desc sub-hero__desc">The ingredients determine the pizza taste — you will find only the best seasonal ingredients at our place.</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Transparent -->
        <section class="transparent">
            <div class="container">
                <div class="transparent__inner">
                    <h2 class="transparent__heading section__heading--main white">Discover what authentic pizza tastes like</h2>
                    <a href="order-online.jsp" class="transparent__order-btn order__online-btn btn">Order online</a>
                </div>
            </div>
        </section>

        <!-- Welcome -->
        <section class="welcome">
            <div class="container">
                <div class="welcome__inner">
                    <div class="welcome__content">
                        <h3 class="welcome__heading section__heading">Welcome to sunny Italy!</h3>
                        <p class="welcome__desc section__desc">If you choose our Italian pizzeria, you certainly won't regret it. We make our pizzas with the highest quality products, imported straight from Italy.</p>
                        <p class="welcome__desc section__desc">We invite you on a journey to sunny Italy. Our adventure with pizza began during one of our family trips. We fell in love with regional flavors and have longed for them every day ever since. By creating EXPRESS PIZZA ITALY we want you to have a similar experience.</p>
                        <a href="order-online.jsp" class="welcome__order-btn btn order__online-btn">Order with delivery</a>
                    </div>
                    <div class="welcome__media">
                        <div class="welcome__media--wrapper">
                            <img src="assets/images/welcome-img-below.png" alt="Loading" class="welcome__media--img">
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </main>

    <!-- Footer -->
    <footer id="footer" class="footer"></footer>
    <script>
        load('#footer', "./templates/footer.jsp");
    </script>
</body>
</html>