<#macro layout title>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuasiStellar.ru</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="css/agency.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
$(document).ready(function() {
            jQuery('#send-form').submit(function(){
            var name = jQuery("#name").val();
            var email = jQuery("#email").val();
            var tel = jQuery("#tel").val();
            var content = jQuery("#content").val();
            var strJson = {"name" : name, "email" : email, "tel" : tel, "content" : content}
            jQuery.ajax({
            type: "POST",
            url: "/savemessages",
            data: strJson,
            beforeSend: function() {
            jQuery('#send-form').html("<div id='message'></div>")
                $('#message').html("<img src='img/gears.svg' />");
              },
            success:  function(data) {

               jQuery('#send-form').html("<div id='message'></div>");
                                      jQuery('#message').html("<h2>Запрос отправлен!</h2>")
                                      .hide()
                                      .fadeIn(1500, function() {
                                      $('#message').append("<i class=\"icon-ok\"></i>");
                                      });
                              }



             });
             return false;
           });
        });

    </script>
</head>

<body id="page-top" class="index">



<#nested>



    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>


    <!-- Theme JavaScript -->
    <script src="js/agency.min.js"></script>


</body>
</html>
</#macro>

