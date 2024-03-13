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
    <title>Check out</title>
</head>

<body>
    <main class="check-out">
        <div class="breadcrumbs">
            <div class="container">
                <ul class="breadcrumbs__list">
                    <li class="breadcrumbs__item active">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">1</div>
                            <span class="breadcrumbs__title">Order</span>
                        </div>
                    </li>
                    <li class="breadcrumbs__item line">
                        <div class="breadcrumbs__line"></div>
                    </li>
                    <li class="breadcrumbs__item">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">2</div>
                            <span class="breadcrumbs__title">Confirmation</span>
                        </div>
                    </li>
                    <li class="breadcrumbs__item line">
                        <div class="breadcrumbs__line"></div>
                    </li>
                    <li class="breadcrumbs__item">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">3</div>
                            <span class="breadcrumbs__title">Ready</span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="check-out__content">
            <div class="container">
            <form action="checkOutServlet" method="POST">
                <div class="check-out__content--inner">
                    <div class="check-out__left">
                        <article class="payment-cart">
                            <div class="payment-cart__inner">
                                <!-- Payment type -->
                                <div class="payment-cart__block">
                                    <span class="payment-cart__title">Payment</span>
                                    <label for="card">
                                        <div class="payment-cart__type">
                                            <input hidden checked class="payment-cart__checkbox" type="radio"
                                                name="payment__type" value="cart" id="card">
                                            <span class="payment-cart__text">Cart (upon receipt)</span>
                                            <img src="./assets/images/payment-cart-card.png" alt="Card"
                                                class="payment-cart__type--icon">
                                        </div>
                                    </label>
                                    <label for="cash">
                                        <div class="payment-cart__type">
                                            <input hidden class="payment-cart__checkbox" type="radio"
                                                name="payment__type" value="cash" id="cash">
                                            <span class="payment-cart__text">Cash</span>
                                            <img src="./assets/images/payment-cart-cash.png" alt="Card"
                                                class="payment-cart__type--icon">
                                        </div>
                                    </label>
                                </div>
                                <!-- order type -->
                                <div class="payment-cart__row">
                                    <div class="payment-cart__column">
                                        <span class="payment-cart__title">Order type</span>
                                        <label for="delivery">
                                            <div class="payment-cart__type">
                                                <input hidden checked class="payment-cart__checkbox" type="radio"
                                                    name="order__type" value="delivery" id="delivery">
                                                <span class="payment-cart__text">Delivery</span>
                                            </div>
                                        </label>
                                        <label for="pickup">
                                            <div class="payment-cart__type">
                                                <input hidden class="payment-cart__checkbox" type="radio"
                                                    name="order__type" value="pickup" id="pickup">
                                                <span class="payment-cart__text">Pick up</span>
                                            </div>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </article>
                        <article class="payment-cart">
                            <div class="payment-cart__inner">
                                <!-- order type -->
                                <span class="payment-cart__title">Contact</span>
                                <div class="payment-cart__row">
                                    <div class="payment-cart__column">
                                        <div class="form-group">
                                            <label for="firstname" class="form-label small">First name *</label>
                                            <input type="text" name="firstname" id="firstname" required
                                                class="form-input no-rounded">
                                        </div>
                                        <div class="form-group">
                                            <label for="phone" class="form-label small">Phone *</label>
                                            <input type="text" name="phone" id="phone" required class="form-input no-rounded">
                                        </div>
                                    </div>
                                    <div class="payment-cart__column">
                                        <div class="form-group">
                                            <label for="lastname" class="form-label small">Last name *</label>
                                            <input type="text" required name="lastname" id="lastname"
                                                class="form-input no-rounded">
                                        </div>
                                        <div class="form-group">
                                            <label for="email" class="form-label small">Email *</label>
                                            <input type="email" required name="email" id="email" class="form-input no-rounded">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="address" class="form-label small">Address (leave this field blank if you pickup)</label>
                                    <input type="text" name="address" id="address" class="form-input no-rounded">
                                </div>
                            </div>
                        </article>
                    </div>
                    <div class="check-out__right">
                        <article class="order-cart">
                            <span class="order-cart__title">Your order</span>
                            <div class="order-cart__content">
                                <div class="order-cart__notempty">
                                    
                                </div>
                            </div>
                            <button type="submit" class="btn order-cart__btn">Create order</button>
                        </article>
                    </div>
                </div>
            </form>
        </div>
        </div>
    </main>
    <script>
        loadOrderCart();
    </script>
</body>

</html>