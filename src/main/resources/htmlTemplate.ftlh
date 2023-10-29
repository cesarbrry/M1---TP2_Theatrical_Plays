<html>

<head>
    <title>Invoice</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap');

        *
        {
            font-family: 'Roboto Condensed', sans-serif;
        }

        table
        {
            margin: auto;
            table-layout: fixed;
            width : 700px;
            text-align: center;
        }

        .highcell th
        {
            border-radius: 100px;
            background-color: rgb(56, 56, 56);
            color: rgb(255, 255, 255);
            padding: 5px;
        }


        .lastcell th
        {
            border-radius: 100px;
            background-color: rgb(129, 129, 129);
            color: white;
            padding: 3px;
        }

    </style>
</head>

<body>
    <h1 style="text-align: center;"> FINAL INVOICE </h1>
    <h2 style="text-align: center;">CUSTOMER : ${invoice.getCustomerName()}</h2>
    <table>
        <tr class="highcell">
            <th> PIECE </th>
            <th> SEATS SOLD </th>
            <th> PRICE </th>
        </tr>
        
        <#list invoice.performances as perf>
        
        <tr class="middlecell">
            <td>${perf.play.name}</td>
            <td>${perf.audience}</td>
            <td>$${perf.play.getPrice(perf.audience)}</td>
        </tr>
        
        </#list>

        <tr class="lastcell">
            <td colspan="2">Total owed : </td>
            <td>$${invoice.SommePrix()}</td>
        </tr>

        <tr class="lastcell">
            <td colspan="2">Fidelity points earned : </td>
            <td>${invoice.SommeCred()}</td>
        </tr>
        
    </table>
</body>

</html>