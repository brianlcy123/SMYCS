var displayLast5UploadedImages = function(){
        $.ajax({
            url: '/img/last5',
            method: 'GET',
            success: function(data,status) {
             console.log(status);
             console.log(data);
             var prefix = 'http://imgur.com/';
             var thumbNailSurfix = 's.png';
             var surfix = '.png';
             $.each(data,function(index,val){
                 if(index === 0) $("#img1").attr('src',prefix+val.imgurId+thumbNailSurfix).wrap("<a href=\""+prefix+val.imgurId+surfix+"\"></a>");
                 if(index === 1) $("#img2").attr('src',prefix+val.imgurId+thumbNailSurfix).wrap("<a href=\""+prefix+val.imgurId+surfix+"\"></a>");
                 if(index === 2) $("#img3").attr('src',prefix+val.imgurId+thumbNailSurfix).wrap("<a href=\""+prefix+val.imgurId+surfix+"\"></a>");
                 if(index === 3) $("#img4").attr('src',prefix+val.imgurId+thumbNailSurfix).wrap("<a href=\""+prefix+val.imgurId+surfix+"\"></a>");
             });
            },
            error: function(request, status, error){
                console.log(request);
                console.log(status);
                console.log(error);
            }
          });
};
var validateImageFile = function(file){
    var ext = file.name.split('.').pop().toLowerCase();
    if($.inArray(ext, ['gif','png','jpg','jpeg','apng','tiff','xcf']) === -1) {
        $("#image-upload-error-message").html("File extension is not supported. Supported file extensions are .gif .png .jpg .jpeg .apng .tiff .xcf");
        $("#image-upload-error-message").show();
        return false;
    }else return true;
};

var hideErrorMessages = function(){
    $("#image-upload-error-message").hide();
    $("#tag-error-message").hide();
};