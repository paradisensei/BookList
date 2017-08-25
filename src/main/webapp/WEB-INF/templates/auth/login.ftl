<#include "../main_template.ftl"/>

<#macro content>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4" style="padding-top: 100px">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">Sign in, please</h3>
          </div>
          <div class="panel-body">
            <form action="${submitUrl}" method="post">
              <fieldset>
                <div class="form-group">
                  <input name="email" type="email" class="form-control" placeholder="Email" autofocus>
                </div>
                <div class="form-group">
                  <input name="password" type="password" class="form-control" placeholder="Password">
                  <#if error??>
                    <p class="help-block">Bad credentials, try again</p>
                  </#if>
                </div>
                <div class="form-group">
                  <input class="btn btn-block btn-success" type="submit" value="Sign in">
                </div>
                <div class="form-group">
                  <a href="/" class="btn btn-block btn-info">Sign up</a>
                </div>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</#macro>

<@main title="Sign in"/>