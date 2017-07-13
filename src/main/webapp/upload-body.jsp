<%-- 
    Document   : upload-body
    Created on : Jul 12, 2017, 6:15:40 PM
    Author     : Owner
--%>
<script src="resources/js/bootstrap-tagsinput.js"></script>
<script src="resources/js/drop-zone.js"></script>
<div class="panel panel-default">
    <div class="panel-heading"><strong>Upload Files</strong> <small>Bootstrap files upload</small></div>
    <div class="panel-body">

      <!-- Standar Form -->
      <h4>Select files from your computer</h4>
      <form action="" method="post" enctype="multipart/form-data" id="js-upload-form">
        <div class="form-inline">
          <div class="form-group">
            <input type="file" name="files[]" id="js-upload-files" multiple>
          </div>
          <button type="submit" class="btn btn-sm btn-primary" id="js-upload-submit">Upload files</button>
        </div>
      </form>

      <!-- Drop Zone -->
      <h4>Or drag and drop files below</h4>
      <div class="upload-drop-zone" id="drop-zone">
        Just drag and drop files here
      </div>
      <h4>Please type in at least one tag.</h4>
      <div>
          <input id="fileTags" type="text" name="fileTags" data-role="tagsinput"/>
      </div>
      
      <!-- Progress Bar -->
<!--      <div class="progress">
        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
          <span class="sr-only">60% Complete</span>
        </div>
      </div>-->

      <!-- Upload Finished -->
      <div class="js-upload-finished">
        <h3>Recently Uploaded</h3>
        <div class="row">
            <div class="col-md-2">
              <img id="img1" src=""/>
            </div>
            <div class="col-md-2">
              <img id="img2" src="" />
            </div>
            <div class="col-md-2">
              <img id="img3" src="" />
            </div>
            <div class="col-md-2">
              <img id="img4" src="" />
            </div>
            <div class="col-md-2">
              <img id="img5" src="" />
            </div>
        </div>
      </div>
    </div>
    <div class="panel-footer">
      <div id="uploadResult">
      </div>  
    </div> 
</div>
