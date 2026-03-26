<!doctype html>
<html>
<head>
    <title>catalog report</title>
    <style>
        body { font-family: sans-serif; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
    </style>
</head>
<body>
    <h1>bibliographic resources</h1>
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>location</th>
        </tr>
        <#list resources as res>
        <tr>
            <td>${res.id}</td>
            <td>${res.title}</td>
            <td><a href="${res.location}">${res.location}</a></td>
        </tr>
        </#list>
    </table>
</body>
</html>