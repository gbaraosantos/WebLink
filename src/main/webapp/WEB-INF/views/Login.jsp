<%--@elvariable id="_csrf" type="org.springframework.security.web.csrf.CsrfAuthenticationStrategy.SaveOnAccessCsrfToken"--%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

    <head>

        <meta charset="utf-8" >
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>WebLink -- Konkrets,Lda</title>

        <!-- CSS -->
        <link href="<c:url value="/resources/css/Bootstrap/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/fontAwesome/Fontcss/font-awesome.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/Login/form-elements.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/Login/style.css" />" rel="stylesheet">
        <link href="<c:url value="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500" />" rel="stylesheet">

        <script src="<c:url value="https://code.jquery.com/jquery-2.1.3.min.js" />" type="text/javascript"></script>

  <!-- Alerts -->

        <script src="<c:url value="/resources/js/SweetAlerts/sweetalert-dev.js" />" type="text/javascript"></script>
        <link href="<c:url value="/resources/css/SweetAlerts/sweetalert.css" />" rel="stylesheet">
  <!--.......................-->

        <script src="<c:url value="/resources/js/Bootstrap/bootstrap.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Login/LoginRegister.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jQuery/jquery.backstretch.min.js" />" type="text/javascript"></script>

    </head>

    <body background="<c:url value="/resources/images/Login/2.jpg" />">

        <!-- Top content -->

        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong><span style="color: #FF9933;">Web</span>Link</strong> e-Learning Platform</h1>
                            <div class="description">
                            	<p>
	                            	Novo Sistema de Login
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <ul class="nav nav-tabs nav-justified">
                                <li role="presentation" class="active"><a href="#Login" aria-controls="Login" role="tab" data-toggle="tab">Login</a></li>
                                <li role="presentation"><a href="#Reg" aria-controls="Reg" role="tab" data-toggle="tab">Register</a></li>
                            </ul>

                            <div class="panel panel-default">
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="Login">
                                    	<div class="form-top">
                                            

                                        		<div class="form-top-left">
                                                    <p style="color: #d43f3a;">${errorMessage}</p>
                                        			<h3>Login na plataforma</h3>
                                            		<p>Preencha com o seu email e password:</p>
                                        		</div>
                                        		<div class="form-top-right">
                                        			<span class="fa fa-lock" style="font-style: italic;"></span>
                                        		</div>
                                        </div> 

                                        <div class="form-bottom">
                                            <form role="form" action="<c:url value="/loginForm"/>" method="post" class="login-form" >
                                                <div class="input-group" style="margin-bottom: 10px">
                                                    <input class="form-control" placeholder="E-mail" name="email" type="text" id = "login_email">
                                                    <span class="input-group-addon glyphicon glyphicon-envelope" id="basic-addon0"></span>
                                                </div>
                                                
                                                <div class="input-group" style="margin-bottom: 10px">
                                                    <input class="form-control" placeholder="Password" name="password" type="password" id = "login_password">
                                                    <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon2"></span>
                                                </div>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <button type="submit" class="btn" onclick="return verify_login();">Log in!</button>
                                            </form>
                                        </div>   
                                    </div>

                                    <div role="tabpanel" class="tab-pane" id="Reg">
                                        <div class="form-top">
                                                <div class="form-top-left">
                                                    <h3>Registo na plataforma</h3>
                                                    <p>Preencha com os seus dados:</p>
                                                </div>
                                                <div class="form-top-right">
                                                    <span class="fa fa-lock" style="font-style: italic;"></span>
                                                </div>
                                        </div> 

                                        <div class="form-bottom">
                                            <form role="form" action="<c:url value="/registerForm"/>" method="post" class="login-form">
                                                <div class= "input-group">
                                                    <input class="form-control" placeholder="Nome Completo" name="name" type="text" id= "nome" spellcheck='false'>
                                                    <span class="input-group-addon glyphicon glyphicon-user" id="basic-addon3"></span>
                                                </div>

                                                <hr>

                                                <div class= "input-group" style="margin-bottom: 7px;">          
                                                        <input class="form-control" placeholder="E-mail" name="email" type="text" id = "email">
                                                        <span class="input-group-addon glyphicon glyphicon-envelope" id="basic-addon4"></span>
                                                </div>


                                                <div class= "input-group">          
                                                        <input class="form-control" placeholder="Repita o E-mail" name="email_again" type="text" id = "re_mail">
                                                        <span class="input-group-addon glyphicon glyphicon-envelope" id="basic-addon5"></span>
                                                </div>

                                                <hr>

                                                <div class = "input-group" style="margin-bottom: 7px;">
                                                        <input class="form-control" placeholder="Password" name="password" type="password" id = "password">
                                                        <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon6"></span>

                                                </div>

                                                <div class = "input-group">
                                                        <input class="form-control" placeholder="Repita a Password" name="password_again" id= "re_password" type="password">
                                                        <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon7"></span>
                                                </div>

                                                <hr>

                                                <h5> Data de nascimento: </h5>

                                                <div class= "input-group">
                                                    <div class="form-group col-lg-4">
                                                        <select class="form-control selectpicker" id = "dia_reg" title="dia_reg" name="dia_reg">
                                                            <option selected = "selected" value= "0"> -- Dia -- </option>
                                                            <option value="1"> 1 </option>
                                                            <option value="2"> 2 </option>
                                                            <option value="3"> 3 </option>
                                                            <option value="4"> 4 </option>
                                                            <option value="5"> 5 </option>
                                                            <option value="6"> 6 </option>
                                                            <option value="7"> 7 </option>
                                                            <option value="8"> 8 </option>
                                                            <option value="9"> 9 </option>
                                                            <option value="10"> 10 </option>
                                                            <option value="11"> 11 </option>
                                                            <option value="12"> 12 </option>
                                                            <option value="13"> 13 </option>
                                                            <option value="14"> 14 </option>
                                                            <option value="15"> 15 </option>
                                                            <option value="16"> 16 </option>
                                                            <option value="17"> 17 </option>
                                                            <option value="18"> 18 </option>
                                                            <option value="19"> 19 </option>
                                                            <option value="20"> 20 </option>
                                                            <option value="21"> 21 </option>
                                                            <option value="22"> 22 </option>
                                                            <option value="23"> 23 </option>
                                                            <option value="24"> 24 </option>
                                                            <option value="25"> 25 </option>
                                                            <option value="26"> 26 </option>
                                                            <option value="27"> 27 </option>
                                                            <option value="28"> 28 </option>
                                                            <option value="29"> 29 </option>
                                                            <option value="30"> 30 </option>
                                                            <option value="31"> 31 </option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-lg-4">
                                                        <select class="form-control selectpicker" id = "mes_reg" title="mes_reg" name="mes_reg">
                                                            <option selected = "selected" value= "0"> -- Mês -- </option>
                                                            <option value="1"> Janeiro </option>
                                                            <option value="2"> Fevereiro </option>
                                                            <option value="3"> Março </option>
                                                            <option value="4"> Abril </option>
                                                            <option value="5"> Maio </option>
                                                            <option value="6"> Junho </option>
                                                            <option value="7"> Julho </option>
                                                            <option value="8"> Agosto </option>
                                                            <option value="9"> Setembro </option>
                                                            <option value="10"> Outubro </option>
                                                            <option value="11"> Novembro </option>
                                                            <option value="12"> Dezembro </option>
                                                        </select>
                                            
                                                    </div>
                                                    <div class="form-group col-lg-4">
                                                        <select class="form-control selectpicker" id = "ano_reg" title="ano_reg" name="ano_reg">
                                                            <option selected = "selected" value= "0"> -- Ano -- </option>
                                                            <option value="2015">2007</option>
                                                            <option value="2014">2006</option>  
                                                            <option value="2013">2007</option>
                                                            <option value="2012">2006</option>  
                                                            <option value="2011">2007</option>
                                                            <option value="2010">2006</option>  
                                                            <option value="2009">2007</option>
                                                            <option value="2008">2006</option>  
                                                            <option value="2007">2007</option>
                                                            <option value="2006">2006</option>                                                      
                                                            <option value="2005">2005</option>                                                      
                                                            <option value="2004">2004</option>                                                      
                                                            <option value="2003">2003</option>                                                      
                                                            <option value="2002">2002</option>                                                      
                                                            <option value="2001">2001</option>                                                      
                                                            <option value="2000">2000</option>                                                      
                                                            <option value="1999">1999</option>                                                      
                                                            <option value="1998">1998</option>                                                      
                                                            <option value="1997">1997</option>                                                      
                                                            <option value="1996">1996</option>                                                      
                                                            <option value="1995">1995</option>                                                      
                                                            <option value="1994">1994</option>                                                      
                                                            <option value="1993">1993</option>                                                      
                                                            <option value="1992">1992</option>                                                      
                                                            <option value="1991">1991</option>                                                      
                                                            <option value="1990">1990</option>                                                      
                                                            <option value="1989">1989</option>                                                      
                                                            <option value="1988">1988</option>                                                      
                                                            <option value="1987">1987</option>                                                      
                                                            <option value="1986">1986</option>                                                      
                                                            <option value="1985">1985</option>                                                      
                                                            <option value="1984">1984</option>                                                      
                                                            <option value="1983">1983</option>                                                      
                                                            <option value="1982">1982</option>                                                      
                                                            <option value="1981">1981</option>                                                      
                                                            <option value="1980">1980</option>                                                      
                                                            <option value="1979">1979</option>                                                      
                                                            <option value="1978">1978</option>                                                      
                                                            <option value="1977">1977</option>                                                      
                                                            <option value="1976">1976</option>                                                      
                                                            <option value="1975">1975</option>                                                      
                                                            <option value="1974">1974</option>                                                      
                                                            <option value="1973">1973</option>
                                                            <option value="1972">1972</option>                                                      
                                                            <option value="1971">1971</option>                                                      
                                                            <option value="1970">1970</option>                                                      
                                                            <option value="1969">1969</option>                                                      
                                                            <option value="1968">1968</option>                                                      
                                                            <option value="1967">1967</option>                                                      
                                                            <option value="1966">1966</option>                                                      
                                                            <option value="1965">1965</option>                                                      
                                                            <option value="1964">1964</option>                                                      
                                                            <option value="1963">1963</option>                                                      
                                                            <option value="1962">1962</option>                                                      
                                                            <option value="1961">1961</option>                                                      
                                                            <option value="1960">1960</option>                                                      
                                                            <option value="1959">1959</option>                                                      
                                                            <option value="1958">1958</option>                                                      
                                                            <option value="1957">1957</option>                                                      
                                                            <option value="1956">1956</option>                                                      
                                                            <option value="1955">1955</option>                                                      
                                                            <option value="1954">1954</option>                                                      
                                                            <option value="1953">1953</option>
                                                            <option value="1952">1952</option>                                                      
                                                            <option value="1951">1951</option>                                                      
                                                            <option value="1950">1950</option>                                                      
                                                            <option value="1949">1949</option>                                                      
                                                            <option value="1948">1948</option>
                                                            <option value="1947">1947</option>                                                      
                                                            <option value="1946">1946</option>                                                      
                                                            <option value="1945">1945</option>
                                                            <option value="1944">1944</option>                                                      
                                                            <option value="1943">1943</option>                                                      
                                                            <option value="1942">1942</option>                                                      
                                                            <option value="1941">1941</option>
                                                            <option value="1940">1940</option>                                                      
                                                            <option value="1939">1939</option>                                                      
                                                            <option value="1938">1938</option>                                                      
                                                            <option value="1937">1937</option>                                                      
                                                            <option value="1936">1936</option>                                                      
                                                            <option value="1935">1935</option>                                                      
                                                            <option value="1934">1934</option>                                                      
                                                            <option value="1933">1933</option>                                                      
                                                            <option value="1932">1932</option>                                                      
                                                            <option value="1931">1931</option>                                                      
                                                            <option value="1930">1930</option>                                                      
                                                            <option value="1929">1929</option>                                                      
                                                            <option value="1928">1928</option>                                                      
                                                            <option value="1927">1927</option>                                                      
                                                            <option value="1926">1926</option>                                                      
                                                            <option value="1925">1925</option>                                                      
                                                            <option value="1924">1924</option>                                                      
                                                            <option value="1923">1923</option>                                                      
                                                            <option value="1922">1922</option>                                                      
                                                            <option value="1921">1921</option>                                                      
                                                            <option value="1920">1920</option>
                                                            <option value="1919">1919</option>                                                      
                                                            <option value="1918">1918</option>                                                      
                                                            <option value="1917">1917</option>                                                      
                                                            <option value="1916">1916</option>                                                      
                                                            <option value="1915">1915</option>                                                      
                                                            <option value="1914">1914</option>                                                      
                                                            <option value="1913">1913</option>                                                      
                                                            <option value="1912">1912</option>                                                      
                                                            <option value="1911">1911</option>                                                      
                                                            <option value="1910">1910</option>                                                      
                                                            <option value="1909">1909</option>                                                      
                                                            <option value="1908">1908</option>                                                      
                                                            <option value="1907">1907</option>                                                      
                                                            <option value="1906">1906</option>                                                      
                                                            <option value="1905">1905</option>                                                      
                                                            <option value="1904">1904</option>                                                      
                                                            <option value="1903">1903</option>                                                      
                                                            <option value="1902">1902</option>                                                      
                                                            <option value="1900">1900</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <hr>

                                                <h5> Nacionalidade: </h5>
                                                <div class = "input-group" >
                                                    <div style="text-align: center;">
                                                        <select class="form-control selectpicker" name="nationality" id="nacionalidade" title="nacionalidade">
                                                            <option value="0">-- Selecione --</option>
                                                            <option value="afghan">Afghan</option>
                                                            <option value="albanian">Albanian</option>
                                                            <option value="algerian">Algerian</option>
                                                            <option value="american">American</option>
                                                            <option value="andorran">Andorran</option>
                                                            <option value="angolan">Angolan</option>
                                                            <option value="antiguans">Antiguans</option>
                                                            <option value="argentinean">Argentinean</option>
                                                            <option value="armenian">Armenian</option>
                                                            <option value="australian">Australian</option>
                                                            <option value="austrian">Austrian</option>
                                                            <option value="azerbaijani">Azerbaijani</option>
                                                            <option value="bahamian">Bahamian</option>
                                                            <option value="bahraini">Bahraini</option>
                                                            <option value="bangladeshi">Bangladeshi</option>
                                                            <option value="barbadian">Barbadian</option>
                                                            <option value="barbudans">Barbudans</option>
                                                            <option value="batswana">Batswana</option>
                                                            <option value="belarusian">Belarusian</option>
                                                            <option value="belgian">Belgian</option>
                                                            <option value="belizean">Belizean</option>
                                                            <option value="beninese">Beninese</option>
                                                            <option value="bhutanese">Bhutanese</option>
                                                            <option value="bolivian">Bolivian</option>
                                                            <option value="bosnian">Bosnian</option>
                                                            <option value="brazilian">Brazilian</option>
                                                            <option value="british">British</option>
                                                            <option value="bruneian">Bruneian</option>
                                                            <option value="bulgarian">Bulgarian</option>
                                                            <option value="burkinabe">Burkinabe</option>
                                                            <option value="burmese">Burmese</option>
                                                            <option value="burundian">Burundian</option>
                                                            <option value="cambodian">Cambodian</option>
                                                            <option value="cameroonian">Cameroonian</option>
                                                            <option value="canadian">Canadian</option>
                                                            <option value="cape verdean">Cape Verdean</option>
                                                            <option value="central african">Central African</option>
                                                            <option value="chadian">Chadian</option>
                                                            <option value="chilean">Chilean</option>
                                                            <option value="chinese">Chinese</option>
                                                            <option value="colombian">Colombian</option>
                                                            <option value="comoran">Comoran</option>
                                                            <option value="congolese">Congolese</option>
                                                            <option value="costa rican">Costa Rican</option>
                                                            <option value="croatian">Croatian</option>
                                                            <option value="cuban">Cuban</option>
                                                            <option value="cypriot">Cypriot</option>
                                                            <option value="czech">Czech</option>
                                                            <option value="danish">Danish</option>
                                                            <option value="djibouti">Djibouti</option>
                                                            <option value="dominican">Dominican</option>
                                                            <option value="dutch">Dutch</option>
                                                            <option value="east timorese">East Timorese</option>
                                                            <option value="ecuadorean">Ecuadorean</option>
                                                            <option value="egyptian">Egyptian</option>
                                                            <option value="emirian">Emirian</option>
                                                            <option value="equatorial guinean">Equatorial Guinean</option>
                                                            <option value="eritrean">Eritrean</option>
                                                            <option value="estonian">Estonian</option>
                                                            <option value="ethiopian">Ethiopian</option>
                                                            <option value="fijian">Fijian</option>
                                                            <option value="filipino">Filipino</option>
                                                            <option value="finnish">Finnish</option>
                                                            <option value="french">French</option>
                                                            <option value="gabonese">Gabonese</option>
                                                            <option value="gambian">Gambian</option>
                                                            <option value="georgian">Georgian</option>
                                                            <option value="german">German</option>
                                                            <option value="ghanaian">Ghanaian</option>
                                                            <option value="greek">Greek</option>
                                                            <option value="grenadian">Grenadian</option>
                                                            <option value="guatemalan">Guatemalan</option>
                                                            <option value="guinea-bissauan">Guinea-Bissauan</option>
                                                            <option value="guinean">Guinean</option>
                                                            <option value="guyanese">Guyanese</option>
                                                            <option value="haitian">Haitian</option>
                                                            <option value="herzegovinian">Herzegovinian</option>
                                                            <option value="honduran">Honduran</option>
                                                            <option value="hungarian">Hungarian</option>
                                                            <option value="icelander">Icelander</option>
                                                            <option value="indian">Indian</option>
                                                            <option value="indonesian">Indonesian</option>
                                                            <option value="iranian">Iranian</option>
                                                            <option value="iraqi">Iraqi</option>
                                                            <option value="irish">Irish</option>
                                                            <option value="israeli">Israeli</option>
                                                            <option value="italian">Italian</option>
                                                            <option value="ivorian">Ivorian</option>
                                                            <option value="jamaican">Jamaican</option>
                                                            <option value="japanese">Japanese</option>
                                                            <option value="jordanian">Jordanian</option>
                                                            <option value="kazakhstani">Kazakhstani</option>
                                                            <option value="kenyan">Kenyan</option>
                                                            <option value="kittian and nevisian">Kittian and Nevisian</option>
                                                            <option value="kuwaiti">Kuwaiti</option>
                                                            <option value="kyrgyz">Kyrgyz</option>
                                                            <option value="laotian">Laotian</option>
                                                            <option value="latvian">Latvian</option>
                                                            <option value="lebanese">Lebanese</option>
                                                            <option value="liberian">Liberian</option>
                                                            <option value="libyan">Libyan</option>
                                                            <option value="liechtensteiner">Liechtensteiner</option>
                                                            <option value="lithuanian">Lithuanian</option>
                                                            <option value="luxembourger">Luxembourger</option>
                                                            <option value="macedonian">Macedonian</option>
                                                            <option value="malagasy">Malagasy</option>
                                                            <option value="malawian">Malawian</option>
                                                            <option value="malaysian">Malaysian</option>
                                                            <option value="maldivan">Maldivan</option>
                                                            <option value="malian">Malian</option>
                                                            <option value="maltese">Maltese</option>
                                                            <option value="marshallese">Marshallese</option>
                                                            <option value="mauritanian">Mauritanian</option>
                                                            <option value="mauritian">Mauritian</option>
                                                            <option value="mexican">Mexican</option>
                                                            <option value="micronesian">Micronesian</option>
                                                            <option value="moldovan">Moldovan</option>
                                                            <option value="monacan">Monacan</option>
                                                            <option value="mongolian">Mongolian</option>
                                                            <option value="moroccan">Moroccan</option>
                                                            <option value="mosotho">Mosotho</option>
                                                            <option value="motswana">Motswana</option>
                                                            <option value="mozambican">Mozambican</option>
                                                            <option value="namibian">Namibian</option>
                                                            <option value="nauruan">Nauruan</option>
                                                            <option value="nepalese">Nepalese</option>
                                                            <option value="new zealander">New Zealander</option>
                                                            <option value="ni-vanuatu">Ni-Vanuatu</option>
                                                            <option value="nicaraguan">Nicaraguan</option>
                                                            <option value="nigerien">Nigerien</option>
                                                            <option value="north korean">North Korean</option>
                                                            <option value="northern irish">Northern Irish</option>
                                                            <option value="norwegian">Norwegian</option>
                                                            <option value="omani">Omani</option>
                                                            <option value="pakistani">Pakistani</option>
                                                            <option value="palauan">Palauan</option>
                                                            <option value="panamanian">Panamanian</option>
                                                            <option value="papua new guinean">Papua New Guinean</option>
                                                            <option value="paraguayan">Paraguayan</option>
                                                            <option value="peruvian">Peruvian</option>
                                                            <option value="polish">Polish</option>
                                                            <option value="portuguese">Portuguese</option>
                                                            <option value="qatari">Qatari</option>
                                                            <option value="romanian">Romanian</option>
                                                            <option value="russian">Russian</option>
                                                            <option value="rwandan">Rwandan</option>
                                                            <option value="saint lucian">Saint Lucian</option>
                                                            <option value="salvadoran">Salvadoran</option>
                                                            <option value="samoan">Samoan</option>
                                                            <option value="san marinese">San Marinese</option>
                                                            <option value="sao tomean">Sao Tomean</option>
                                                            <option value="saudi">Saudi</option>
                                                            <option value="scottish">Scottish</option>
                                                            <option value="senegalese">Senegalese</option>
                                                            <option value="serbian">Serbian</option>
                                                            <option value="seychellois">Seychellois</option>
                                                            <option value="sierra leonean">Sierra Leonean</option>
                                                            <option value="singaporean">Singaporean</option>
                                                            <option value="slovakian">Slovakian</option>
                                                            <option value="slovenian">Slovenian</option>
                                                            <option value="solomon islander">Solomon Islander</option>
                                                            <option value="somali">Somali</option>
                                                            <option value="south african">South African</option>
                                                            <option value="south korean">South Korean</option>
                                                            <option value="spanish">Spanish</option>
                                                            <option value="sri lankan">Sri Lankan</option>
                                                            <option value="sudanese">Sudanese</option>
                                                            <option value="surinamer">Surinamer</option>
                                                            <option value="swazi">Swazi</option>
                                                            <option value="swedish">Swedish</option>
                                                            <option value="swiss">Swiss</option>
                                                            <option value="syrian">Syrian</option>
                                                            <option value="taiwanese">Taiwanese</option>
                                                            <option value="tajik">Tajik</option>
                                                            <option value="tanzanian">Tanzanian</option>
                                                            <option value="thai">Thai</option>
                                                            <option value="togolese">Togolese</option>
                                                            <option value="tongan">Tongan</option>
                                                            <option value="trinidadian or tobagonian">Trinidadian or Tobagonian</option>
                                                            <option value="tunisian">Tunisian</option>
                                                            <option value="turkish">Turkish</option>
                                                            <option value="tuvaluan">Tuvaluan</option>
                                                            <option value="ugandan">Ugandan</option>
                                                            <option value="ukrainian">Ukrainian</option>
                                                            <option value="uruguayan">Uruguayan</option>
                                                            <option value="uzbekistani">Uzbekistani</option>
                                                            <option value="venezuelan">Venezuelan</option>
                                                            <option value="vietnamese">Vietnamese</option>
                                                            <option value="welsh">Welsh</option>
                                                            <option value="yemenite">Yemenite</option>
                                                            <option value="zambian">Zambian</option>
                                                            <option value="zimbabwean">Zimbabwean</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <hr>

                                                <div class = "input-group">
                                                        <input class="form-control" placeholder="Morada" name="address" id= "morada" type="text">
                                                        <span class="input-group-addon glyphicon glyphicon-home" id="basic-addon1"></span>
                                                </div>

                                                <br> 

                                                <h5> Postal code: </h5>
                                                <div class = "input-group">
                                                    <div class= "input-group col-lg-5" style="margin-bottom: 7px;">                 
                                                        <input class="form-control" name="postal1" id= "postal1" type="text" title="postal1">
                                                        <span class="input-group-addon"> - </span>
                                                        <input class="form-control" name="postal2" id= "postal2" type="text" title="postal2">
                                                    </div>


                                                    <input class="form-control" placeholder = "Cidade" name="postal1" id= "city" type="text">

                                                </div>

                                                <hr>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <button type="submit" class="btn" onclick="return verify_registry();">Registo</button>
                                            </form>
                                        </div>
                                    </div>

                                </div>
                            </div>        
                        </div>
                    </div>



                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>Ou faça Login com:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		<span class="fa fa-facebook" style="font-style: italic;"></span> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<span class="fa fa-google-plus" style="font-style: italic;"></span> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </body>

</html>