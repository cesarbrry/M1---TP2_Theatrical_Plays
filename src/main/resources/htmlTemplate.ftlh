<html>

<head>
    <title>INVOICE</title>
</head>

<body>
    <h1> FINAL INVOICE </h1>
    <table style="width : 700px">
        <tr>
            <th> PIECE </th>
            <th> SEATS SOLD </th>
            <th> PRICE </th>
        </tr>
        <tr>
        <#list invoice.performances as perf>
            
                <td>${perf.play.name}</td>
                <td>${perf.audience}</td>
                <td>${perf.play.getPrice(perf.audience)}</td>
        </#list>
        </tr>
    </table>
</body>

</html>