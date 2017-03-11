<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>
 
<sql:query var="rs" dataSource="jdbc/hesDB">
select id, branch from hes_locations 
</sql:query>

Count: ${rs.rowCount} <br/>

<c:forEach var="row" items="${rs.rows}">
	row ${row}<br/>
    id ${row.id}<br/>
    branch ${row.branch}<br/>
</c:forEach>

  </body>
</html>
