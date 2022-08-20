<html>
<head>
    <title>Create</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/styles/atom-one-dark.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.6/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<textarea id="code_snippet"></textarea>
<br>
<br>
Time restriction: <input id="time_restriction" type="text"/>
<br>
<br>
Views restriction: <input id="views_restriction" type="text"/>
<br>
<br>
<button id="send_snippet" type="submit" onclick="send()">Submit</button>
<style>
    body{
        border: 5px solid grey;
        background: yellowgreen;
        height: 300px ;
        font-family: sans-serif;
        width: 200px ;
        padding: 40px;
        margin: auto;
    }
</style>
</body>

<script>
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value,
            "time": document.getElementById("time_restriction").value,
            "views": document.getElementById("views_restriction").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status == 200) {
            alert("Success!");
        }
    }
</script>
</html>