<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<#include "../main_template.ftl"/>

<#macro content>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4" style="padding-top: 100px">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Sign up, please</h3>
          </div>
          <div class="panel-body">
            <@sf.form action="/" method="post" modelAttribute="user">
              <fieldset>
                <div class="form-group">
                  <@sf.input path="name" cssClass="form-control" placeholder="Name"/>
                  <@sf.errors path="name" cssClass="help-block"/>
                </div>
                <div class="form-group">
                  <@sf.input path="email" type="email" cssClass="form-control" placeholder="Email"/>
                  <@sf.errors path="email" cssClass="help-block"/>
                </div>
                <div class="form-group">
                  <@sf.input path="password" type="password" cssClass="form-control" placeholder="Password"/>
                  <@sf.errors path="password" cssClass="help-block"/>
                </div>
                <div class="form-group">
                  <@sf.input path="passwordConfirmation" type="password" cssClass="form-control" placeholder="Confirm password"/>
                  <@sf.errors path="passwordConfirmation" cssClass="help-block"/>
                </div>
                <div class="form-group">
                  <input class="btn btn-block btn-info" type="submit" value="Sign up">
                </div>
                <div class="form-group">
                  <a href="/login" class="btn btn-block btn-success">Sign in</a>
                </div>
              </fieldset>
            </@sf.form>
          </div>
        </div>
      </div>
    </div>
  </div>
</#macro>

<@main title="Sign up"/>