<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Successfully Added!</title>

    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="icon" type="image/x-icon" href="https://freepngimg.com/download/book/6-2-book-png-7.png">

    <style>
        body{
            background-image: url("https://images.pexels.com/photos/4449796/pexels-photo-4449796.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>
</head>
<body class="d-flex h-100 text-center text-bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <main class="px-3">
        <h1 class="display-1">Customer successfully added</h1>
        <p> Customer name: ${customer.name}</p>
        <p> Customer email: ${customer.email}</p>
        <p> Customer phone number: ${customer.number}</p>
        <p class="lead">
            <a href="/phone" class="btn btn-lg btn-light fw-bold border-white bg-white">Next step</a>
        </p>
    </main>
</div>
</body>
</html>
