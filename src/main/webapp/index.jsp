<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en-US">
	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>WebLink -- Konkrets, Lda</title>


        <meta property="fb:app_id" content="1236025403088867">
        <meta property="og:url" content="https://elearning.konkrets.pt/">
        <meta property="og:title" content="Melhor plataforma de elearning do mercado.">
        <meta property="og:description" content="Plataforma de elearning com os melhores precos. Vem ver.">
        <meta property="og:image" content="http://elearning.konkrets.pt/resources/images/successCourse/pass.png">
        <meta property="og:image:secure_url" content="https://elearning.konkrets.pt/resources/images/successCourse/pass.png">
        <meta property="og:image:type" content="image/png">
        <meta property="og:image:width" content="256">
        <meta property="og:image:height" content="256">





        <!-- Mobile Metas -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- Google Fonts  -->
        <link href="<c:url value="http://fonts.googleapis.com/css?family=Roboto:400,700,500" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="http://fonts.googleapis.com/css?family=Lato:300,400" />" rel="stylesheet" type="text/css">

        <!-- Libs and Plugins CSS -->
        <link href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.minhome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/owlCarrosel/owl.carousel.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/Animations/animate.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/owlCarrosel/owl.theme.css" />" rel="stylesheet">

		<!-- Theme CSS -->
        <link href="<c:url value="/resources/css/Homepage/reset.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/Homepage/style.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/Homepage/mobile.css" />" rel="stylesheet">

		<!-- Skin CSS -->
        <link href="<c:url value="/resources/css/Homepage/cool-gray.css" />" rel="stylesheet">






        <!-- Variables -->


    </head>

    <body data-spy="scroll" data-target="#main-navbar">
        <div class="page-loader"></div>  <!-- Display loading image while page loads -->
    	<div class="body">
        
            <!--========== BEGIN HEADER ==========-->
            <header id="header" class="header-main">

                <!-- Begin Navbar -->
                <nav id="main-navbar" class="navbar navbar-default navbar-fixed-top" role="navigation"> <!-- Classes: navbar-default, navbar-inverse, navbar-fixed-top, navbar-fixed-bottom, navbar-transparent. Note: If you use non-transparent navbar, set "height: 98px;" to #header -->

                  <div class="container">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>

                        <a class="navbar-brand page-scroll" href="index.jsp">Unika</a>

                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a class="page-scroll" href="#about-section">Sobre Nós</a></li>
                            <li><a class="page-scroll" href="#services-section">Cursos</a></li>
                            <li><a class="page-scroll" href="#team-section">Equipa</a></li> 
                            <li><a class="page-scroll" href="#contact-section">Contacto</a></li>
                            <li><a class="page-scroll" href="<c:url value="/loginMenu" />">Entrar</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                  </div><!-- /.container -->
                </nav>
                <!-- End Navbar -->

            </header>
            <!-- ========= END HEADER =========-->
            
            
            
            
        	<!-- Begin text carousel intro section -->

			<section id="text-carousel-intro-section" class="parallax" data-stellar-background-ratio="0.5" style="background-image: url(<c:url value="/resources/images/Homepage/2.jpg" />);">
				
				<div class="container">
					<div class="caption text-center text-white" data-stellar-ratio="0.7">

						<div id="owl-intro-text" class="owl-carousel">
							<div class="item">
								<h1>Plataforma n.º 1 de ensino do mercado</h1>
								<p>Veja os nossos cursos</p>
                                <div class="extra-space-l"></div>
								<a class="btn btn-blank" href="<c:url value="/loginMenu" />" target="_blank" role="button">Aceda!</a>
							</div>
							<div class="item">
								<h1> Konkrets </h1>
								<p>Veja o nosso site e que mais podemos oferecer</p>
								<div class="extra-space-l"></div>
								<a class="btn btn-blank" href="<c:url value="www.konkrets.com" />" target="_blank" role="button">Aceda!</a>
							</div>
						</div>

					</div> <!-- /.caption -->
				</div> <!-- /.container -->

			</section>
			<!-- End text carousel intro section -->




            <!-- Begin about section -->
            <section id="about-section" class="page bg-style1">
                <!-- Begin page header-->
                <div class="page-header-wrapper">
                    <div class="container">
                        <div class="page-header text-center wow fadeInUp" data-wow-delay="0.3s">
                            <h2>Sobre nós</h2>

                            <p class="subtitle">Alguma informação sobre nós</p>
                        </div>
                    </div>
                </div>
                <!-- End page header-->

                <!-- Begin rotate box-1 -->
                <div class="rotate-box-1-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
                                    <span class="rotate-box-icon">
                                        <i class="fa fa-users"></i>
                                    </span>
                                    <div class="rotate-box-info">
                                        <h4>Quem Somos?</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.2s">
                                    <span class="rotate-box-icon"><i class="fa fa-diamond"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>O que fazemos?</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
                                    <span class="rotate-box-icon"><i class="fa fa-heart"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>Porque o fazemos?</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>

                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.6s">
                                    <span class="rotate-box-icon"><i class="fa fa-clock-o"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>Desde quando?</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>

                        </div> <!-- /.row -->
                    </div> <!-- /.container -->
                </div>
                <!-- End rotate box-1 -->

                <div class="extra-space-l"></div>


            </section>
            <!-- End about section -->
     
            <!-- Begin Services -->
            <section id="services-section" class="page text-center">
                <!-- Begin page header-->
                <div class="page-header-wrapper">
                    <div class="container">
                        <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                            <h2>Cursos em Destaque</h2>
                            <div class="devider"></div>
                            <p class="subtitle">Cursos disponiveis para inscrição</p>
                        </div>
                    </div>
                </div>
                <!-- End page header-->
            
                <!-- Begin roatet box-2 -->
                <div class="rotate-box-2-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0">
                                    <span class="rotate-box-icon"><i class="fa fa-mobile"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>App Development</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>
            
                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.2s">
                                    <span class="rotate-box-icon"><i class="fa fa-pie-chart"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>Ui Design</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>
            
                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.4s">
                                    <span class="rotate-box-icon"><i class="fa fa-cloud"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>Cloud Hosting</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>
                            
                            <div class="col-md-3 col-sm-6">
                                <a href="#" class="rotate-box-2 square-icon text-center wow zoomIn" data-wow-delay="0.6s">
                                    <span class="rotate-box-icon"><i class="fa fa-pencil"></i></span>
                                    <div class="rotate-box-info">
                                        <h4>Coding Pen</h4>
                                        <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do eiusmod tempor incidist.</p>
                                    </div>
                                </a>
                            </div>
                            
                        </div> <!-- /.row -->
                    </div> <!-- /.container -->
                    
                    <div class="container">
                        <!-- Cta Button -->
                        <div class="extra-space-l"></div>
                        <div class="text-center">
                    		<a class="btn btn-default btn-lg-xl" href="http://www.imransdesign.com/" target="_blank" role="button">Lista Completa</a>
                        </div>
                    </div> <!-- /.container -->                       
                </div>
                <!-- End rotate-box-2 -->
            </section>
            <!-- End Services -->
              

            <!-- Begin counter up -->
            <section id="counter-section">
				<div id="counter-up-trigger" class="counter-up text-white parallax" data-stellar-background-ratio="0.5" style="background-image: url(<c:url value="/resources/images/Homepage/counter-bg.jpg" />);">
					<div class="cover"></div>
                    <!-- Begin page header-->
                    <div class="page-header-wrapper">
                        <div class="container">
                            <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                                <h2>Alguns Números</h2>
                                <div class="devider"></div>
                            </div>
                        </div>
                    </div>
                    <!-- End page header-->
					<div class="container">

						<div class="row">

							<div class="fact text-center col-md-3 col-sm-6">
								<div class="fact-inner">
									<i class="fa fa-users fa-3x"></i>
                                    <div class="extra-space-l"></div>
									<span class="counter">6666</span>
									<p class="lead">Número de inscritos actual</p>
								</div>
							</div>

							<div class="fact text-center col-md-3 col-sm-6">
								<div class="fact-inner">
									<i class="fa fa-check fa-3x"></i>
                                    <div class="extra-space-l"></div>
									<span class="counter">800</span>
									<p class="lead">Número de cursos completos</p>
								</div>
							</div>

							<div class="fact text-center col-md-3 col-sm-6">
								<div class="fact-inner">
									<i class="fa fa-eye fa-3x"></i>
                                    <div class="extra-space-l"></div>
									<span class="counter">5500</span>
									<p class="lead">Horas de curso</p>
								</div>
							</div>

							<div class="fact last text-center col-md-3 col-sm-6">
								<div class="fact-inner">
									<i class="fa fa-archive fa-3x"></i>
                                    <div class="extra-space-l"></div>
									<span class="counter">127</span>
									<p class="lead">Número de cursos disponivel</p>
								</div>
							</div>

						</div> <!-- /.row -->
					</div> <!-- /.container -->
				</div>
            </section>
			<!-- End counter up -->
                
                
                
                
            <!-- Begin team-->
            <section id="team-section" class="page">
                <!-- Begin page header-->
                <div class="page-header-wrapper">
                    <div class="container">
                        <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                            <h2>A nossa equipa</h2>
                            <div class="devider"></div>
                            <p class="subtitle">Conheça as caras por trás deste projecto</p>
                        </div>
                    </div>
                </div>
                <!-- End page header-->
                <div class="container">
                    <div class="row">
                        <div class="team-items">
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.2s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">

                                                <img src="<c:url value="/resources/images/team/5.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-male"></i>
                                                    <p>Luís Fernandes</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.3s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/7.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-female"></i>
                                                    <p>Patricia Duarte</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.4s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/3.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-female"></i>
                                                    <p>Ângela Paiva</p>
                                                </div>
                                            </div>  
                                        </div>
                                    </div>
                                </div>
                            </div>
    
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.5s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/2.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-female"></i>
                                                    <p>Ana Neves</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.6s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/6.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-male"></i>
                                                    <p>Nuno Clamote</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.7s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/8.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-male"></i>
                                                    <p>Rui Pinto</p>
                                                </div>
                                            </div>  
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.8s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/9.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-female"></i>
                                                    <p>Sofia Martins</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                             <div class="col-md-2">
                             </div>
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.4s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/10.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-male"></i>
                                                    <p>Serge Nunes</p>
                                                </div>
                                            </div>  
                                        </div>
                                    </div>
                                </div>
                            </div>
    
                            <div class="col-md-2">
                                <div class="team-container wow bounceIn" data-wow-delay="0.5s">
                                    <div class="team-item">
                                        <div class="team-triangle">
                                            <div class="content">
                                                <img src="<c:url value="/resources/images/team/4.jpg" />" alt="title"/>
                                                <div class="team-hover text-center">
                                                    <i class="fa fa-female"></i>
                                                    <p>Bárbara Cravo</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>  
                    </div>
                </div>

            </section>
            <!-- End team-->



            <!-- Begin contact section -->
			<section id="contact-section" class="page text-white parallax" data-stellar-background-ratio="0.5" style="background-image: url(<c:url value="/resources/images/Homepage/map-bg.jpg" />);">
            <div class="cover"></div>
            
                 <!-- Begin page header-->
                <div class="page-header-wrapper">
                    <div class="container">
                        <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                            <h2>Contacto</h2>
                            <div class="devider"></div>
                            <p class="subtitle">Como nos contactar</p>
                        </div>
                    </div>
                </div>
                <!-- End page header-->
                
                <div class="contact wow bounceInRight" data-wow-delay="0.4s">
                    <div class="container">
                    	<div class="row">
                        
                            <div class="col-sm-6">
                                <div class="contact-info">
                                    <h4>Nossa Morada</h4>
                                    <ul class="contact-address">
			                            <li><i class="fa fa-map-marker fa-lg"></i>&nbsp; Avenida João das Regras, nº62
3040-256<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Coimbra, Portugal</li>
			                            <li><i class="fa fa-phone"></i>&nbsp; 239 157 354</li>
			                            <li><i class="fa fa-envelope"></i> info@konkrets.pt</li>
			                        </ul>
                                    <ul class="contact-address">
                                        <li><i class="fa fa-map-marker fa-lg"></i>&nbsp; Rua Inês de Castro nº9B
3200-150<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;Lousã, Portugal</li>
                                        <li><i class="fa fa-phone"></i>&nbsp; 239 993 478</li>
                                        <li><i class="fa fa-envelope"></i> info@konkrets.pt</li>
                                    </ul>
                                </div>
                            </div>
                        
                        	<div class="col-sm-6">
                                <div class="contact-form">
                                	<h4>Escreva-nos:</h4>
                                    <form role="form">
                                        <div class="form-group">
                                            <input type="text" class="form-control input-lg" placeholder="O Seu Nome" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control input-lg" placeholder="O seu E-mail" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control input-lg" placeholder="Assunto" required>
                                        </div>
                                        <div class="form-group">
                                            <textarea class="form-control input-lg" rows="5" placeholder="Mensagem" required></textarea>
                                        </div>
                                        <button type="submit" class="btn wow bounceInRight" data-wow-delay="0.8s">Envie!</button>
                                    </form>
                                </div>	
                            </div>
                                                                                
                        </div> <!-- /.row -->
                    </div> <!-- /.container -->
                </div>
            </section>
            <!-- End contact section -->

             <!-- Begin partners -->
            <section id="partners-section">
                <!-- Begin page header-->
                <div class="page-header-wrapper">
                    <div class="container">
                        <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                            <h2>Os Nossos Parceiros</h2>
                            <div class="devider"></div>
                            <p class="subtitle">Empresas que usaram os nossos serviços.</p>
                        </div>
                    </div>
                </div>
                <!-- End page header-->
                <div class="container">
                    <div id="owl-partners" class="owl-carousel">

                        <img height="45" width="200" src="<c:url value="/resources/images/partners/1.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/2.jpg" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/3.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/4.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/5.jpg" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/6.jpg" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/7.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/8.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/9.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/10.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/11.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/12.png" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/13.jpg" />" alt="img">
                        <img height="45" width="200" src="<c:url value="/resources/images/partners/14.png" />" alt="img">
                    </div>images/div>
                </div>
            </section>
            <!-- End partners -->
                

            <a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a> <!-- Scroll to top button -->
                                              
        </div><!-- body ends -->


        <script src="<c:url value="/resources/js/jQuery/jquery-1.11.1.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Bootstrap/bootstrap.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/owlCarrosel/owl.carousel.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jQuery/jquery.stellar.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Animations/wow.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Homepage/waypoints.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Homepage/isotope.pkgd.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Homepage/classie.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jQuery/jquery.easing.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jQuery/jquery.counterup.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Homepage/smoothscroll.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Homepage/theme.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jQuery/jquery.easing.min.js" />" type="text/javascript"></script>

    </body> 
        
            
</html>
