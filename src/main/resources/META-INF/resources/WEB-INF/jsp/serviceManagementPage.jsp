<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>MyFavBooks</title>

    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="icon" type="image/x-icon" href="https://freepngimg.com/download/book/6-2-book-png-7.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


</head>
<body>
<header class="mb-auto">
    <div>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3 p-1">
            <a class="navbar-brand m-1">WeFix</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/serviceManagement">Services</a></li>
                    <li class="nav-item"><a class="nav-link" href="/customerManagement">Customers</a></li>
                    <li class="nav-item"><a class="nav-link" href="/phoneManagement">Phones</a></li>
                    <li class="nav-item"><a class="nav-link" href="/paymentManagement">Payments</a></li>
                </ul>
            </div>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            </ul>
        </nav>

    </div>
</header>

<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Welcome ${name}</h1>
                <p class="lead text-muted">We are glad to have you back!</p>
            </div>
        </div>
    </section>

    <div class="container-fluid">
        <h1>Your services: </h1>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Service name: </th>
                <th>Customer name: </th>
                <th>Phone model: </th>
                <th>Description: </th>
                <th>Done Status: </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${services}" var="service">
                <tr>
                    <td>${service.serviceName}</td>
                    <td>${service.customerName}</td>
                    <td>${service.phoneModel}</td>
                    <td>${service.description}</td>
                    <td>${service.done}</td>
                    <td><a href="deleteService?id=${service.id}" class="btn btn-danger">DELETE</a> </td>
                    <td><a href="updateServiceStatus?id=${service.id}" class="btn btn-success">MARK AS DONE</a> </td>
                    <td><a href="updateServiceStatusAgain?id=${service.id}" class="btn btn-warning">MARK AS UNDONE</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</main>

<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>
