<%-- 
    Document   : upload-body
    Created on : Jul 12, 2017, 6:15:40 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="resources/css/blueimp-gallery.min.css">
<script src="resources/js/bootstrap-tagsinput.js"></script>
<script src="resources/js/image.js"></script>
<script src="resources/js/blueimp-gallery.min.js"></script>
<script>
    
document.getElementById('links').onclick = function (event) {
    event = event || window.event;
    var target = event.target || event.srcElement,
        link = target.src ? target.parentNode : target,
        options = {index: link, event: event},
        links = this.getElementsByTagName('a');
    blueimp.Gallery(links, options);
};
</script>
<div class="panel panel-default">
    <div id="blueimp-gallery" class="blueimp-gallery">
        <div class="slides"></div>
        <h3 class="title"></h3>
        <a class="prev">‹</a>
        <a class="next">›</a>
        <a class="close">×</a>
        <a class="play-pause"></a>
        <ol class="indicator"></ol>
    </div>
    <div class="panel-heading"><strong>Upload Files</strong></div>
    <div class="panel-body">

      <!-- Standar Form -->
      <h4>Select files from your computer</h4>
      <div id="image-upload-error-message" class="alert alert-danger" hidden="true"></div>
      <form action="" method="post" enctype="multipart/form-data" id="js-upload-form">
        <div class="form-inline">
          <div class="form-group">
            <input type="file" name="files[]" id="js-upload-files" multiple>
          </div>
          <button type="submit" class="btn btn-sm btn-primary" id="js-upload-submit">Upload files</button>
        </div>
          <!-- Drop Zone -->
      <h4>Or drag and drop files below</h4>
      <div class="upload-drop-zone" id="drop-zone">
        Just drag and drop files here!
      </div>
           
      <!-- Progress Bar -->
      <div class="progress">
      </div>
      
      <h4>Please type in at least one tag to describe this cheat sheet.</h4>
      <div id="tag-error-message" class="alert alert-danger" hidden="true"></div>
      <div>
          <input id="fileTags" type="text" name="fileTags" data-role="tagsinput"/>
      </div>
      </form>

<!--       Drop Zone 
      <h4>Or drag and drop files below</h4>
      <div class="upload-drop-zone" id="drop-zone">
        Just drag and drop files here!
      </div>
           
       Progress Bar 
      <div class="progress">
      </div>
      
      <h4>Please type in at least one tag to describe this cheat sheet.</h4>
      <div>
          <input id="fileTags" type="text" name="fileTags" data-role="tagsinput"/>
      </div>-->

      <!-- Upload Finished -->
      <div class="js-upload-finished">
        <h3>Recently Uploaded</h3>
        <div id="links" class="row">
            <div class="col-md-3">
              <img id="img1" src=""/>
            </div>
            <div class="col-md-3">
              <img id="img2" src="" />
            </div>
            <div class="col-md-3">
              <img id="img3" src="" />
            </div>
            <div class="col-md-3">
              <img id="img4" src="" />
            </div>
        </div>
      </div>
    </div>
    <div class="panel-footer">
<!--      <div id="uploadResult">
      </div>  -->
    </div> 
</div>
