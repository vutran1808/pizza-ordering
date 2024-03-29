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
    <link rel="stylesheet" href="assets/font/stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sora:wght@100..800&display=swap" rel="stylesheet">

    <!-- SCSS -->
    <link rel="stylesheet" href="./assets/css/main.css">

    <!-- Fontawesome -->
    <link rel="stylesheet" href="./assets/fontawesome/css/all.min.css">

    <!-- Script -->
    <script src="./assets/js/script.js"></script>
    <title>Home</title>
</head>
<body>
    <!-- Header -->
    <header id="header"></header>
    <script>
        load("#header", "templates/header.jsp");
    </script>

    <main class="home">
        <!-- Hero -->
        <section class="hero">
            <div class="container">
                <div class="hero__inner">
                    <h1 class="section__heading--main">Authentic Italian pizza!</h1>
                    <p class="section__desc--main">Delicious Italian pizza straight from the oven with delivery to your door!</p>
                    <a href="order-online.jsp" class="order__online-btn btn hero__btn">Order online</a>
                </div>
            </div>
        </section>

        <!-- Enjoy -->
        <section class="enjoy">
            <div class="enjoy__inner">
                <div class="enjoy__media">
                    <div class="enjoy__media--wrapper">
                        <img src="assets/images/enjoy-1.jpg" alt="Loading" class="enjoy__media--img">
                    </div>
                    <div class="enjoy__media--wrapper">
                        <img src="assets/images/enjoy-2.jpg" alt="Loading" class="enjoy__media--img">
                    </div>
                </div>
                <div class="enjoy__content">
                    <h2 class="section__heading">Enjoy the original Italian pizza</h2>
                    <p class="section__desc">Italians say that the secret to good pizza is carefully selected ingredients of the best quality. They say there should be no more than 3 of them! And all this on extremely thin crust dough. Do you agree? Come to EXPRESS PIZZA ITALY and see for yourself.</p>
                </div>
            </div>
        </section>

        <!-- Description -->
        <section class="description">
            <div class="description__inner">
                <div class="description__content">
                    <h2 class="section__heading white">Only the best ingredients</h2>
                    <p class="section__desc white">We use only natural ingredients to prepare our pizzas, most of which we import from Italy. Italian burrata, spices, olive oil? These and many other additives determine the taste of our products.</p>
                    <a href="order-online.jsp" class="description__btn btn order__online-btn white-rounded">Order online</a>
                </div>
                <div class="description__media">
                    <div class="description__media--wrapper">
                        <img src="assets/images/pizza.png" alt="Pizza" class="description__media--img">
                    </div>
                </div>
            </div>
        </section>

        <!-- Transparent Section -->
        <section class="transparent">
            <div class="transparent__inner">
                <h2 class="section__heading white transparent__heading">We invite you to EXPRESS PIZZA ITALY!</h2>
            </div>
        </section>
    </main>

    <!-- Footer -->
    <footer id="footer"></footer>
    <script>
        load('#footer', "./templates/footer.jsp");
    </script>
</body>
</html>