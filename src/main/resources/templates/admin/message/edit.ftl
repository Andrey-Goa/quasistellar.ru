<@admin title="Message-Edit">
<input type="button" class="btn btn-lg btn-success" value="Назад"  onclick="history.back()">
<h3>Имя</h3>
<div class="well">
${message.name}
</div>
<br>
<h3>Email</h3>
<div class="well">
${message.email}
</div>
<br>
<h3>Телефон</h3>
<div class="well">
${message.tel!}
</div>
<br>
<div class="well">
${message.content}
<br>
</div>
<form action="/admin/clients/del/${message.id}" method="POST">
           <td><button class="btn btn-danger" onclick="return confirmDelete();">Удалить</button></td>
           </form>
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