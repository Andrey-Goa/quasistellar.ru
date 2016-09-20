<@layout title="Index">
  <#include "menu.ftl">
    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">QuasiStellar</div>

                <a href="#services" class="page-scroll btn btn-xl">Услуги</a>
            </div>
        </div>
    </header>

    <!-- Services Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Услуги</h2>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Разработка веб-приложений</h4>

                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-android fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Разработка приложений под Android</h4>

                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-paper-plane fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading"> Боты для Telegram </h4>

                </div>
            </div>
        </div>
    </section>



    <!-- About Section -->
    <section id="about" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">About</h2>
                     <div class="timeline-body">

                     </div>

                </div>
            </div>
        </div>
    </section>

      <section id="portfolio">
             <div class="container">
                 <div class="row">
                     <div class="col-lg-12 text-center">
                         <h2 class="section-heading">Portfolio</h2>
                     </div>
                 </div>
                <div class="row">
                 <#list portfolios as portfolio>
                   <div class="col-sm-6 col-md-4">
                     <div class="thumbnail">
                      <img src="img/portfolio/${portfolio.imgPath}" alt="Портфолио">
                      <div class="caption">
                        <h4>${portfolio.title}</h4>
                        <p>${portfolio.content}</p>
                        <p><a href="${portfolio.url}" target="_blank">${portfolio.url}</a></p>
                      </div>
                    </div>
                  </div>
                       </#list>
                       </div>
                           </div>
                           </section>

    <section id="team" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Контакты</h2>
                </div>
            </div>
            <div class="row">

            </div>

        </div>
    </section>


    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Связаться со мной</h2>

                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form autocomplete="" id="send-form" method="POST">
                        <div class="row">

                            <div class="col-md-6">
                                <div class="form-group">
                                    <input  type="text" class ="form-control" required  placeholder="Ваше имя *" name="name" id="name">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input  type="email" class="form-control" required placeholder="Ваш Email *" name="email" id="email">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="tel" class="form-control" placeholder="Ваш телефон" name="tel" id="tel">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <textarea class="form-control" required placeholder="Ваше сообщение *" name="content" id="content"></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <input type="submit" id="form-update" value="Отправить" class="btn btn-xl" >

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
<footer>@QuasiStellar 2016</footer>
</@layout>