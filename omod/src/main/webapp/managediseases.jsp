<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#diseasesTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="diseasesTable"class="display">
    <thead>
        <tr>
            <th>DiseaseID</th>
            <th>Disease Name</th>
            <th>Disease Description</th>
            <th>ICD10 Disease</th>
            <th>p Value</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="disease" items="${diseaseslist}">
            <tr>
                <td>${disease.diseasesId}</td>
                <td>${disease.diseasesName}</td>
                <td>${disease.diseasesNotes}</td>
                <td>${disease.diseasesICD10}</td>
                <td>${disease.pValue}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>