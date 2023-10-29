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
    <h1 style="text-align: center;">[ FINAL INVOICE ]</h1>
    <h2 style="text-align: center;">Customer : ${invoice.getCustomerName()}</h2>
    <h2 style="text-align: center;">Base Fidelity Points : ${invoice.customer.getPointDeFidelite()}</h2>
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

        <#if invoice.customer.getPointDeFidelite() gte 150 >

        <tr class="lastcell">
            <td colspan="2">Total owed (- $15 of fidelity points) : </td>
            <td>$${invoice.SommePrix()}</td>
        </tr>

        <#else>
        <tr class="lastcell">
            <td colspan="2">Total owed : </td>
            <td>$${invoice.SommePrix()}</td>
        </tr>
        </#if>

        <tr class="lastcell">
            <td colspan="2">Fidelity points earned : </td>
            <td>${invoice.SommeCred()}</td>
        </tr>

        <tr class="lastcell">
            <td colspan="2">Fidelity points final credit : </td>
            <td>${invoice.CreditFinal()}</td>
        </tr>
        
    </table>
</body>

</html>