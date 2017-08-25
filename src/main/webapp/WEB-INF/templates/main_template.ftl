<#macro main title scripts=[] styles=[]>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <title>${title}</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="../../resources/img/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

    <script type="application/javascript" src="/resources/js/lib/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" src="/resources/js/lib/bootstrap.min.js"></script>

    <#list styles as style>
      <link rel="stylesheet" type="text/css" href="${style}">
    </#list>
  </head>

  <body>
    <@content/>

    <#list scripts as script>
      <script type="application/javascript" src="${script}"></script>
    </#list>
  </body>
</#macro>