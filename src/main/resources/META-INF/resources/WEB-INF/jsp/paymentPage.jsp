<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add a new book</title>

    <!--<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" >-->
    <link rel="icon" type="image/x-icon" href="https://freepngimg.com/download/book/6-2-book-png-7.png">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    <style>
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


</head>
<body class="bg-light">
<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>Make a new payment</h2>
            <p class="lead">Fill up the form below to make a new payment.</p>
        </div>
        <div>
            <h4 class="mb-3">Payment details</h4>


            <%--@elvariable id="payment" type="jakarta"--%>
            <form:form method="POST" action="payment" modelAttribute="payment">
                <div class="col-md-2">
                    <form:label class="form-label" path="value">Amount (kr)</form:label>
                    <form:input type="text" class="form-control" id="value" path="value"/>
                    <form:errors path="value" cssClass="text-warning"/>
                </div>
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Pay</button>
                </div>
            </form:form>
        </div>
    </main>

</div>

<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

</body>
</html>
