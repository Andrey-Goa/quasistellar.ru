 <input type="button" class="btn btn-success" value="Назад"  onclick="history.back()">
 <br>
<section>
<dt>Название</dt>
        <dd>
            <@spring.formInput "portfolio.title", "class='form-control' " />
            <div class="alert alert-warning" role="alert">
                        <@spring.showErrors "<br/>" />
            </div>
        </dd>
<dt>Изображение</dt>
        <dd>
                  <#if portfolio.imgPath??>
                   <img src="../../../img/portfolio/${portfolio.imgPath}" width="300px">
                    <@spring.formInput "portfolio.imgPath", "class='form-control' " />
                  </#if>


                  <input type="file" name="file" multiple accept="image/*,image/jpeg">


        </dd>
<dt>Ссылка</dt>
 <dd>
                 <@spring.formInput "portfolio.url", "class='form-control'" />


                </dd>
       <dd>
         <@spring.formTextarea "portfolio.content", "class='form-control'" />


        </dd>
</section>
           <script>
               $(document).ready(function() {
                   $('#content').summernote({
                     height: 300,                 // set editor height
                     minHeight: null,             // set minimum height of editor
                     maxHeight: null,             // set maximum height of editor
                     focus: true                  // set focus to editable area after initializing summernote
                   });
               });
             </script>
