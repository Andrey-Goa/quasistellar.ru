<@admin title="Admin-Portfolio-New">
<h1>Новое портфолио</h1>

<form action="/admin/portfolio/new" method="POST" enctype="multipart/form-data">

        <#include "_form.ftl">

        <div class="form-group">
                  <div>
                      <input type="submit" id="create" value="Create" class="btn btn-primary" />
                  </div>
              </div>

    </dl>
</form>
</body>
</html>
</@admin>