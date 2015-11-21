<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#patientexamformslistTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="patientexamformslistTable"class="display">
    <thead>
        <tr>
            <th>ExamForm ID</th>
            <th>Exam Date</th>
            <th>Patient ID</th>
            <th>Encounter ID</th>
            <th>Create Date</th>
            <th>Patient ID</th>
            <th>First Pregnancy</th>
            <th>Expected Disease</th>
            <th>Final Disease</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="patientexamform" items="${patientexamformslist}">
            <tr>
                <td>${patientexamform.examId}</td>
                <td>${patientexamform.examDate}</td>
                <td>${patientexamform.patientId}</td>
                <td>${patientexamform.encounterId}</td>
                <td>${patientexamform.createDate}</td>
                <td>${patientexamform.isFirstPregnancy}</td>
                <td>${patientexamform.expectedDisease}</td>
                <td>${patientexamform.finalDisease}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>