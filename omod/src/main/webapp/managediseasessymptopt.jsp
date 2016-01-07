<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />


<script type="text/javascript">
    $j(document).ready(function() {
        $j('#idseasesSsymptOptTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="idseasesSsymptOptTable"class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>SymptOptID</th>
            <th>Symptom Option</th>
            <th>Symptom</th>
            <th>Symptom Category</th>
            <th>Disease Name</th>
            <th>pY</th>
            <th>pN</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="diseasesBySymptOpt" items="${diseasesBySymptOptList}">
            <tr>
                <td>${diseasesBySymptOpt.diseasesSymptOptId}</td>
                <td>${diseasesBySymptOpt.symptOpt.symptOptId}</td>
                <td>${diseasesBySymptOpt.symptOpt.optName}</td>
                <td>${diseasesBySymptOpt.symptOpt.symptom.symptName}</td>
                <td>${diseasesBySymptOpt.symptOpt.symptom.symptCategory.catName}</td>
                <td>${diseasesBySymptOpt.disiase.diseasesName}</td>
                <td>${diseasesBySymptOpt.py}</td>
                <td>${diseasesBySymptOpt.pn}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>