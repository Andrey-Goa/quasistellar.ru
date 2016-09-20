<@admin title="Admin-Message">

<table class="table table-bordered table-hover">
  <thead class="thead-inverse">
    <tr>

     <th>Дата</th>
      <th>Имя</th>
      <th>Email</th>
      <th>Телефон</th>
      <th>Прочитать сообщение</th>

    </tr>
  </thead>
 <tbody>
 <#list messages as message>

     <td><h4>${(message.date)!}</h4></td>
     <td><h4>${(message.name)!}</h4></td>
     <td><h4>${(message.email)!}</h4></td>
     <td><h4>${(message.tel)!}</h4></td>
     <form action="/admin/clients/${message.id}" method="GET">
           <td><button class="btn btn-success">Прочитать</button></td>
           </form>
           </tr>

 </#list>
 </tbody>
 </table>
</@admin>