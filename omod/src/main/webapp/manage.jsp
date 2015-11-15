<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>


<table>
	<tr>
		<th>CatID</th>
		<th>Symptom Category Name</th>
		<th>Symptom Category Description</th>
                <th>Selected</th>
	</tr>
	<c:forEach var="symptcategory" items="${symptcategorylist}">
		<tr>
			<td>${symptcategory.symptCatId}</td>
			<td>${symptcategory.catName}</td>
			<td>${symptcategory.catNotes}</td>
                        <td>${symptcategory.isSelected}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>