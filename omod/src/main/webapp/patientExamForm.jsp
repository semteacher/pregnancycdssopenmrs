<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<p>New patient exam form will be there!</p>
<p>encounterId=${encounterId}</p>
<p>patientId=${patientId}</p>
<p>All Encounter Data=${encounerdata}</p>
<p>model test - patient data: ${patientdata}</p>
<p>model test - patient form data: ${patientexamform}</p>

<table id="symptCatTable"class="display">
    <tbody>
        <tr>
            <td>
                <c:forEach var="symptcategory" items="${symptcategorylist}">
                    <c:choose>
                        <c:when test="${symptcategory.isSelected == true}">
                            <div>${symptcategory.catName}</div>
                            <c:forEach var="symptom" items="${symptcategory.symptoms}">
                                <c:choose>
                                    <c:when test="${symptom.isSelected == true}">
                                        <div>${symptom.symptName}</div>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>