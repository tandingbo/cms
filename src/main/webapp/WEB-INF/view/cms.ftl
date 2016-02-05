<#-- 页头meta -->
<#macro meta keywords="" description="">
<#-- 平台名称 -->
    <#assign platFormName = platFormName?default("") />
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="author" content="Yowant FE Team"/>
    <meta name="Description" content="${description! }"/>
    <meta name="Keywords" content="${keywords! }"/>
    <script type="text/javascript">
        var BASE_PATH = '${staticPath! }';
    </script>
</#macro>

<#-- 页尾js -->
<#macro footjs>
<script type="text/javascript" src="${base}/resources/js/jquery-1.8.3.min.js"></script>
</#macro>