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
    <title>Admin Page</title>
</head>

<body>
    <main class="admin">
        <div class="container">
            <div class="admin__inner">
                <aside class="admin__sidebar">
                    <ul class="sidebar__list">
                        <li class="sidebar__item" target="task-list">
                            <i class="fa-solid fa-list-check"></i>
                            Task list
                        </li>
                        <li class="sidebar__item" target="menu-list">
                            <i class="fa-solid fa-utensils"></i>
                            Menu
                        </li>
                        <li class="sidebar__item" target="user-list">
                            <i class="fa-solid fa-utensils"></i>
                            User List
                        </li>
                    </ul>
                </aside>
                <div class="admin__content">
                </div>
            </div>
        </div>
    </main>
    <script>
        handleChangeFoodCard();
        toggleAdminPage();
    </script>
</body>

</html>