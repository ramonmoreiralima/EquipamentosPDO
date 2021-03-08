                        </div>
                     </div>
                     <!--  FIM MENU LATERAL -->

                  <div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: block;">
                  <div class="mCSB_draggerContainer">
                  		<div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; display: block; height: 0px;">
                  			<div class="mCSB_dragger_bar" style="line-height: 30px;"></div>
                  		</div>
                  		<div class="mCSB_draggerRail"></div>
                  </div>
            </div>
            
	</div>
</div>

         
       
<!-- Warning Section Ends -->
<!-- Required Jquery -->
<script type="text/javascript" src="./lib/js/jquery.min.js(1).download"></script>
<script type="text/javascript" src="./lib/js/jquery-ui.min.js.download"></script>
<script type="text/javascript" src="./lib/js/popper.min.js.download"></script>
<script type="text/javascript" src="./lib/js/bootstrap.min.js.download"></script>
<!-- jquery slimscroll js -->
<script type="text/javascript" src="./lib/js/jquery.slimscroll.js.download"></script>
<!-- modernizr js -->
<script type="text/javascript" src="./lib/js/modernizr.js.download"></script>
<!-- am chart -->
<script src="./lib/js/amcharts.min.js.download"></script>
<script src="./lib/js/serial.min.js.download"></script>
<!-- Todo js -->
<script type="text/javascript " src="./lib/js/todo.js.download"></script>
<!-- Custom js -->
<script type="text/javascript" src="./lib/js/custom-dashboard.js.download"></script>
<script type="text/javascript" src="./lib/js/script.js.download"></script>
<script type="text/javascript " src="./lib/js/SmoothScroll.js.download"></script>
<script src="./lib/js/pcoded.min.js.download"></script>
<script src="./lib/js/demo-12.js.download"></script>
<script src="./lib/js/jquery.mCustomScrollbar.concat.min.js.download"></script>
<script>
var $window = $(window);
var nav = $('.fixed-button');
    $window.scroll(function(){
        if ($window.scrollTop() >= 200) {
         nav.addClass('active');
     }
     else {
         nav.removeClass('active');
     }
 });
    
    function confirmExclusao(id) {
    	// var id = document.getElementById('idEquipamento').value;
    	   if (confirm("Tem certeza que deseja excluir?")) {
    	      location.href="equipamento?op=delete&id="+id;
    	   }
    	}
</script>



</body></html>