$(document).ready(function() {
    'use strict';
    var dropZone = $('#drop-zone');
    var uploadForm = $('#js-upload-form');
    displayLast5UploadedImages();
    var startUpload = function(files) {
        console.log(files);
        $(".progress").html("<div id=\"upload-progress-bar\" class=\"progress-bar\" role=\"progressbar\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>");
        if(!$("#fileTags").val()){
             $("#tag-error-message").html("At least 1 tag is required.");
            $("#tag-error-message").show();
            return;
        }
        if(files.length>1)
            console.log("More than 1 file are uploaded. Only the first file is selected.");
        var file = files[0];
            console.log("file");
        if(!validateImageFile(file)) return;
        
        
        var FR = new FileReader();
        FR.onload = function(e){
            var idata =e.target.result;
            var base64_data = idata.substring(idata.indexOf(",")+1,idata.length);
            imgurUpload(base64_data);
        }; 
        FR.readAsDataURL(file);        
    };
    
    var imgurUpload =  function(base64_data){
        $.ajax({
            url: 'https://api.imgur.com/3/image',
            method: 'POST',
            headers: {
              Authorization: 'Client-ID 360bd34dd9a6ad3',
              Accept: 'application/json'
            },
            data: {
              image: base64_data
            },
            xhr: function(){
                var xhr = new window.XMLHttpRequest();
                //Upload progress
                xhr.upload.addEventListener("progress", function(evt){
                if (evt.lengthComputable) {
                  var percentComplete = evt.loaded / evt.total*100;
                  //Do something with upload progress
                  $("#upload-progress-bar").width(percentComplete+'%');
                  console.log(percentComplete);
                  }
                }, false);
              //Download progress
                xhr.addEventListener("progress", function(evt){
                  if (evt.lengthComputable) {
                    var percentComplete = evt.loaded / evt.total;
                  //Do something with download progress
                    console.log(percentComplete);
                  }
                }, false);
                return xhr;
              },
            success: function(result) {
              var imgId = result.data.id;
              var imgLink = result.data.link;
             console.log(imgLink);
             logFileUpload(result.data);
             $("#upload-progress-bar").toggleClass('progress-bar-success').delay(3000)
                     .queue(function(next){
                         $(".progress").html("");
                     });
            },
            error: function(request, status, error){
                console.log(request);
                console.log(status);
                console.log(error);
                $("#upload-progress-bar").toggleClass('progress-bar-danger').delay(3000)
                     .queue(function(next){
                         $(".progress").html("");
                });
                $("#image-upload-error-message").html("File upload to imgur failed.");
                $("#image-upload-error-message").show();
                
          }
      });
    };
    
    var logFileUpload = function(data){
        var imgId = data.id;
        var imgLink = data.link;
        var image = {
            'imgurId': imgId,
            'tagString': $("#fileTags").val()
        };
        console.log(image);
        $.ajax({
           url: '/img',
           type: 'POST',
           dataType : "json",
           contentType: "application/json; charset=utf-8",
           data: JSON.stringify(image),
           success: function(result){
               console.log(result);
//               $("#uploadResult").prepend($('<img>',{id:imgId, src:imgLink}));
               var gallery = blueimp.Gallery([imgLink]);
               displayLast5UploadedImages();
           }
        });
        
    };

    uploadForm.submit(function(e) {
        var uploadFiles = document.getElementById('js-upload-files').files;
        e.preventDefault();
        hideErrorMessages();
        startUpload(uploadFiles);
    });
    dropZone.on("drop",function(e) {
        e.preventDefault();
        e.stopPropagation();
        this.className = 'upload-drop-zone';
        var files = e.originalEvent.dataTransfer.files;
        hideErrorMessages();
        startUpload(files);
    });
    
    dropZone.on("dragover",function(e) {
        e.preventDefault();
        e.stopPropagation();
        this.className = 'upload-drop-zone drop';
        return false;
    });
    
    dropZone.on("dragleave",function(e) {
        e.preventDefault();
        e.stopPropagation();
        this.className = 'upload-drop-zone';
        return false;
    });
    
});