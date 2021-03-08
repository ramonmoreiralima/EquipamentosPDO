<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body themebg-pattern="pattern2">
    <div id="pcoded" class="pcoded iscollapsed" theme-layout="vertical" vertical-placement="left" vertical-layout="wide" pcoded-device-type="desktop" vertical-nav-type="expanded" vertical-effect="shrink" vnavigation-view="view1" nav-type="st2" fream-type="theme1" layout-type="light">
        <div class="pcoded-overlay-box"></div>
			<div class="pcoded-container navbar-wrapper">
			
				<nav class="navbar header-navbar pcoded-header iscollapsed" header-theme="theme1" pcoded-header-position="fixed">
					<div class="navbar-wrapper">

						<div class="navbar-logo" logo-theme="theme1">
							<a class="mobile-menu" id="mobile-collapse" href="#">
								<i class="ti-menu"></i>
							</a>
							<a class="mobile-search morphsearch-search" href="#">
								<i class="ti-search"></i>
							</a>
							<a href="#">
								<img class="img-fluid" src="lib/img/logo.png"  width="100" height="100" alt="Oi Simples Assim.">
							</a>
							<a class="mobile-options">
								<i class="ti-more"></i>
							</a>
						</div>

						<div class="container">
							<div class="col align-self-start"></div>
							<div class="row align-items-end">
							    <div class="col-6">
							      <span class="pcoded-mtext" data-i18n="nav.dash.main">${title}</span>
							    </div>
							    <div class="col">
							     
							    </div>
							    <div class="col">
							     
							    </div>
							    <div class="col">
							      
							    </div>
							    <form class="form-inline mt-2 mt-md-0">
								    <div class="row justify-content-between">
									    <div class="col-8">
									     <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
									    </div>
									    <div class="col-4">
									      <button class="btn btn-outline-success btn-sm" type="submit">Search</button>
									    </div>
								 	</div>
								</form>
						  </div>

						  
						  
						</div>  
          
					</div>
				</nav>

            <!--  INICIO MENU LATERAL -->
            <div class="pcoded-main-container" style="margin-top: 80px;">
                <div class="pcoded-wrapper">
                    <nav class="pcoded-navbar" navbar-theme="themelight1" active-item-theme="theme4" sub-item-theme="theme2" active-item-style="style0" pcoded-navbar-position="fixed">
                        <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
                        
                            <!-- <div class="pcoded-navigatio-lavel" data-i18n="nav.category.navigation" menu-title-theme="theme1">Layout</div> -->
								<ul class="pcoded-item pcoded-left-item" item-border="true" item-border-style="none" subitem-border="true">
									<li class="active">
										<a href="equipamento?op=home">
											<span class="pcoded-micon"><i class="ti-home"></i><b></b></span>
											<span class="pcoded-mtext" data-i18n="nav.dash.main">Home</span>
											<span class="pcoded-mcaret"></span>
										</a>
									</li>
									<li class="pcoded-hasmenu" dropdown-icon="style1" subitem-icon="style6">
										<a href="javascript:void(0)">
											<span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
											<span class="pcoded-mtext" data-i18n="nav.basic-components.main">Equipamento</span>
											<span class="pcoded-mcaret"></span>
										</a>
										<ul class="pcoded-submenu">
											<li class=" ">
											
												<a href="equipamento?op=list">
													<span class="pcoded-micon"><i class="ti-angle-right"></i></span>
													<span class="pcoded-mtext" data-i18n="nav.basic-components.alert">Listar</span>
													<span class="pcoded-mcaret"></span>
												</a>
												
											</li>
											<li class=" ">
											
												<a href="equipamento?op=new">
													<span class="pcoded-micon"><i class="ti-angle-right"></i></span>
													<span class="pcoded-mtext" data-i18n="nav.basic-components.breadcrumbs">Novo</span>
													<span class="pcoded-mcaret"></span>
												</a>
												
											</li>
											
										</ul>
									</li>
								</ul>
                            </nav>
                            
						   <div class="pcoded-content">
						    	<div class="pcoded-inner-content">
									<div class="main-body">
										<c:if test="${msg != null or err != null}">
				                        	<div class="alert alert-warning alert-dismissible fade show" role="alert">
												<strong>${msg}${err}</strong>
												<button type="button" class="close" data-dismiss="alert" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div> 
				                		</c:if>
									</div>
								</div>
							</div>
                            
                            