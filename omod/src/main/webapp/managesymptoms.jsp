<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />


<script type="text/javascript">
    $j(document).ready(function() {
        $j('#symptomsTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="symptomsTable"class="display">
    <thead>
        <tr>
            <th>SymptID</th>
            <th>Symptom Name</th>
            <th>Symptom Description</th>
            <th>Category</th>
            <th>Order</th>
            <th>Multi</th>
            <th>Selected</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="symptom" items="${symptomslist}">
            <tr>
                <td>${symptom.symptId}</td>
                <td>${symptom.symptName}</td>
                <td>${symptom.symptNotes}</td>
                <td>${symptom.symptCategory.catName}</td>
                <td>${symptom.idOrder}</td>
                <td>
                    <c:choose>
                        <c:when test="${symptom.isMulti == true}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${symptom.isSelected == true}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>