$(function(){
    $("#registration_link").on('click',function(){
        //event.preventDefault();
        //event.stopPropagation();
        $.ajax({
           type: 'GET',
           url: '/registration',
           success: function(response){
               $("#body").html(response);
               getCurrentUser();
           },
           error: function(status, response){
               console.log(response);
           }
        });
        //$("#body").load("/resources/templates/imgur.jsp");
    });
    
    $("#login_button").on('click',function(){
        var loginForm =$("#login_form");
        $.post(loginForm.attr("action"),loginForm.serialize(),function(response){
            $("#body").html(response);
            //redirectToImageUploadPage();
            getCurrentUser();
        });
    });
});

