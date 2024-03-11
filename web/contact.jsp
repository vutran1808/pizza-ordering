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
    <title>Contact</title>
</head>
<body>
    <!-- Header -->
    <header id="header" class="header"></header>
    <script>
        load("#header", "./templates/header.jsp");
    </script>

    <main class="contact">
        <!-- Hero -->
        <section class="hero">
                <div class="container">
                    <div class="hero__inner">
                        <i class="contact__icon fa-regular fa-envelope-open"></i>
                        <span class="section__desc--main contact__sub-heading">CONTACT US</span>
                        <h2 class="section__heading--main white contact__heading">ORDER A DELICIOUS PIZZA WITH DELIVERY IN LESS THAN HALF AN HOUR.</h2>
                        <span class="contact__tel">+48 33 8376 6284</span>
                        <div class="contact__info">
                            <div class="contact__info--column">
                                <p class="contact__info--text">4557 Heron Way</p>
                                <p class="contact__info--text">Stayton</p>
                                <p class="contact__info--text">97383</p>
                                <p class="contact__info--text">Oregon</p>
                            </div>
                            <div class="contact__info--column">
                                <p class="contact__info--text">Email:</p>
                                <p class="contact__info--text">example@mail.com</p>
                                <p class="contact__info--text">Everyday 7AM - 11PM</p>
                            </div>
                        </div>
                    </div>
            </div>
        </section>

        <!-- sending -->
        <section class="sending">
            <div class="container">
                <div class="sending__inner">
                    <div class="sending__content">
                        <span class="section__desc--main contact__sub-heading">WRITE TO US</span>
                        <h2 class="sending__heading section__heading">
                            Order an
                            <span class="express-heading">Italian pizza!</span>
                        </h2>
                        <p class="sending__desc section__desc">Use our form and order a pizza with delivery to your home. We guarantee it will be delivered to you warm and in less than half an hour.</p>
                    </div>
                    <div class="sending__form">
                        <form action="" class="form">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="firstname" class="form-label small">First Name</label>
                                    <input type="text" name="firstname" id="firstname" class="form-input">
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="form-label small">Last Name</label>
                                    <input type="text" name="lastname" id="lastname" class="form-input">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="phone" class="form-label small">Phone</label>
                                    <input type="text" name="phone" id="phone" class="form-input">
                                </div>
                                <div class="form-group">
                                    <label for="email" class="form-label small">E-mail</label>
                                    <input type="email" name="email" id="email" class="form-input">
                                </div>
                            </div> 
                            <div class="form-group">
                                <label for="message" class="form-label small">Message</label>
                                <textarea name="message" id="message" cols="30" rows="5" maxlength="5000" class="form-textarea"></textarea>
                            </div>    
                            <button type="submit" class="sending__btn btn">Send</button>                       
                        </form>
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