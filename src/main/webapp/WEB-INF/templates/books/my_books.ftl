<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
  <div class="col-lg-6 col-md-offset-3">
    <h2 class="page-header text-center">My favourite Books</h2>
    <a href="/books" class="btn btn-link" style="float: left">Books</a>
    <a href="/logout" class="btn btn-link" style="float: right">Logout</a>
  </div>
</div>

<div class="row">
  <div class="col-lg-6 col-md-offset-3">
    <div class="panel-group">
      <#list books as book>
        <div class="panel panel-default">
          <div class="panel-body">
          <#-- book id to send in request -->
            <input class="book" style="display: none" value=${book.id}>
            <div style="float: left">
              <h4>${book.title} by ${book.author}</h4>
              <button type="button" class="remove btn btn-danger">Remove from favourites</button>
            </div>
            <img src="/resources/img/thumbnails/${book.id}.jpg"
                 class="img-thumbnail" width="75" height="150" style="float: right">
          </div>
        </div>
      </#list>
    </div>
  </div>
</div>
</#macro>

<@main title="My books" scripts=["/resources/js/custom/my_books.js"]/>