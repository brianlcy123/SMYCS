$(function(){
    $("#body").load("resources/templates/home-body.jsp");
    
    $("#home").on('click',function(){
        $("#body").load("resources/templates/home-body.jsp");
    });
    $("#upload").click(function(event){
        event.preventDefault();
        event.stopPropagation();
        $.ajax({
           type: 'GET',
           url: '/img',
           success: function(response){
               $("#body").html(response);
           },
           error: function(status, response){
               console.log(response);
           }
        });
    });
});

