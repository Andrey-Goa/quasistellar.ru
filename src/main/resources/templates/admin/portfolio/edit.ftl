<@admin title="Admin-Portfolio-Edit">
<h2> Редактрирование портфолио </h2>
<form action="/admin/portfolio/edit/${portfolioId}" method="POST" enctype="multipart/form-data">


        <#include "_form.ftl">

          <div class="form-group">
                    <div>
                        <input type="submit" id="update" value="Update" class="btn btn-primary" />
                    </div>
                </div>
    </form>
</@admin>