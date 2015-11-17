<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#symptCatTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="symptCatTable"class="display">
    <thead>
        <tr>
            <th>CatID</th>
            <th>Symptom Category Name</th>
            <th>Symptom Category Description</th>
            <th>Selected</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="symptcategory" items="${symptcategorylist}">
            <tr>
                <td>${symptcategory.symptCatId}</td>
                <td>${symptcategory.catName}</td>
                <td>${symptcategory.catNotes}</td>
                <td>
                    <c:choose>
                        <c:when test="${symptcategory.isSelected == true}">
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