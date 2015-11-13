<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>


<table>
	<tr>
		<th>ID</th>
		<th>Symptom Category Name</th>
		<th>Symptom Category Description</th>
                <th>Selected</th>
	</tr>
	<c:forEach var="symptcategory" items="${symptcategorylist}">
		<tr>
			<td>${symptcategorylist.id}</td>
			<td>${symptcategorylist.cat_name}</td>
			<td>${symptcategorylist.cat_note}</td>
                        <td>${symptcategorylist.is_selected}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>