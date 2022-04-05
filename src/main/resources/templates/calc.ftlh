<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Calculator</title>
</head>
<body>

<p>Welcome to Calculator</p>
<p>Result is: ${res}</p>

<form action="/calculate">
    <label>A:</label><br/>
    <input name="a"/><br/>
    <label>B:</label><br/>
    <input name="b"/><br/>

    <label>Operation:</label><br/>
    <input name="operation"/>
    <br/><br/>


    <input type="submit" value="Calculate"/>


</form>

<p>
    History: <br/>
    <#list historyList as item>
        ${item} <br/>
    </#list>

</p>

</body>
</html>