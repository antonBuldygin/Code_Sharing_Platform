<html>
<head>
    <title>Latest</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/styles/atom-one-dark.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.6/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<table>
    <#list latest as item>
        <tr>
            <td><span id="load_date">${item.date}</span></td>
        </tr>
        <tr>
            <td><pre id="code_snippet"><code>${item.code}</code></pre></td>
        </tr>
    </#list>
</table>

<style>
    pre{
        border: 5px solid grey;
        background: yellowgreen;
        height: 75px ;
        font-family: sans-serif;
        width: 500px ;
    }

    #load_date{color: darkgreen;
        font-family: Calibri;
        size: auto}
</style>
</body>
</html>