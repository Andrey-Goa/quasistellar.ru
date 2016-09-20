<@admin title="Admin-Portfolios">
<form action="/admin/portfolio/new">
    <button class="btn btn-success nav-tabs buttonnote" type="submit"> Создать новое портфолио</button>
</form>
<br>
<table class="margtable table table-bordered table-hover">
  <thead class="thead-inverse">
    <tr>
      <th>Название</th>
      <th>Удалить</th>
      <th>Изменить</th>
    </tr>
  </thead>
 <tbody>


 <#list portfolios as portfolio>
     <td><h4>${(portfolio.title)!}</h4></td>

     <form action="/admin/portfolio/del/${portfolio.id}" method="POST">
                <td><button class="btn btn-danger" onclick="return confirmDelete();">Удалить</button></td>
                </form>
       <form action="/admin/portfolio/edit/${portfolio.id}" method="GET">
      <td><button class="btn btn-success nav-tabs">Изменить</a></td>
            </form>
      </tr>
      </#list>


 </tbody>
    </table>
    <script>
        function confirmDelete() {

    if (confirm("Are you sure?")) {
        return true;
    } else {
        return false;
    }
}

</script>
</@admin>