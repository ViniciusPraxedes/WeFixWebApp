<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Styles -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <style><%@include file="css/styles.css"%></style>
    <link rel="stylesheet" media="screen and (max-width: 768px)" href="css/tablet.css">
    <link rel="stylesheet" media="screen and (max-width: 415px)" href="css/mobile.css">

    <!--External-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">

    <title>WeFix | Mobile repair</title>
</head>

<body id="Home">
<nav>
    <h1 id="logo"><span class="text-primary"><i class="fas fa-tools"></i> We</span>Fix</h1>
    <ul>
        <li><a href="#Home">Home</a></li>
        <li><a href="#who-we-are">Who we are</a></li>
        <li><a href="#contact-us">Contact us</a></li>
        <li><a href="/WeFix/customer">Budgeting</a></li>

    </ul>
</nav>

<header>
    <div id="showcase">
        <h1>WeFix</h1>
        <p>We are a company with mobile phone repair expertise. With the consumer wishes in mind.</p>
        <a class="button" href="/WeFix/customer" class="button" role="button">Get started</a>
    </div>
</header>

<section id="what-we-do">
    <div class="container">
        <h2><span class="text-primary">What we can</span> offer</h2>
        <div class="boxes">
            <div class="box">
                <i class="fas fa-search fa-3x"></i>
                <h3>Budget</h3>
                <p>We offer a free budgeting of your problem.</p>
            </div>
            <div class="box">
                <i class="fas fa-mobile fa-3x"></i>
                <h3>Screen fix</h3>
                <p>Has our phone screen gone broke? Don't worry.<span class="text-primary"> We fix!</span></p>
            </div>
            <div class="box">
                <i class="fas fa-tools fa-3x"></i>
                <h3>Hardware repair</h3>
                <p>We fix all kinds of hardware problems your phone may have.</p>
            </div>
        </div>
    </div>
</section>

<section id="who-we-are">
    <div id="who-we-are-img">
    </div>
    <div id="who-we-are-container">
        <h2><span class="text-primary">Who</span> we are</h2>
        <p>We are focused on delivering the best service to our clients</p>
        <h3>Our group</h3>
        <ul>
            <li>Smith: CEO</li>
            <li>Shannon Johnson: CFO</li>
            <li>John Corbit: Lead Technician</li>
            <li>Janet Williams: Technician</li>
            <li>Kara Jackson: Senior Technician</li>
        </ul>
    </div>
</section>

<section id="contact-us">
    <div class="contact-us-container">
        <h2>Contact us</h2>
        <p>User the form below to contact us</p>

        <form>
            <div class="form-group">
                <label for="Name">Name</label>
                <input type="text" name="Name" value="">
            </div>
        </form>

        <form>
            <div class="form-group">
                <label for="Email">E-mail</label>
                <input type="text" name="Enter Email" value="">
            </div>
        </form>

        <form>
            <div class="form-group">
                <label for="Number">Phone number</label>
                <input type="text" name="Phone Number" value="">
            </div>
        </form>

        <form>
            <div class="form-group">
                <label for="Text">Text</label>
                <textarea name="Text" rows="8" cols="80"></textarea>
            </div>
            <button type="button" name="Send">Send</button>
        </form>
    </div>
    <div id="map"></div>
</section>

<footer>
    <p>Copyright © 2023, WeFix, All Rights Reserved</p>
</footer>

<!--Scripts-->
<script type="text/javascript"><%@include file="js/main.js" %></script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB8CmsPvFEcDMcL2srFYLHj6forEyp5FDE&callback=initMap" async defer></script>


</body>
</html>
