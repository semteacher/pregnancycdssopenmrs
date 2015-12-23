<%@ include file="/WEB-INF/template/include.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#patientexamformslistTable').dataTable();
    } );
</script>

<p>encounterId=${encounter.encounterId} patientId=${encounter.patient.patientId}</p>

<div id="ptientExamTable">
    <table id="patientexamformslistTable"class="display">
        <thead>
            <tr>
                <th>ExamForm ID</th>
                <th>Exam Date</th>
                <th>Patient ID</th>
                <th>Encounter ID</th>
                <th>Create Date</th>            
                <th>First Pregnancy</th>
                <th>Expected Disease</th>
                <th>Final Disease</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patientexamformlst" items="${model.patientexamformslist}">
                <tr>
                    <td>${patientexamformlst.examId}</td>
                    <td>${patientexamformlst.examDate}</td>
                    <td>${patientexamformlst.patientId.familyName}</td>
                    <td>${patientexamformlst.encounterId}</td>
                    <td>${patientexamformlst.createDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${patientexamformlst.isFirstPregnancy == true}">
                                Yes
                            </c:when>
                            <c:otherwise>
                                No
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${patientexamformlst.expectedDisease}</td>
                    <td>${patientexamformlst.finalDisease}</td>
                    <td>
                        <div id="addPtientExamForm">
                            <openmrs:hasPrivilege privilege="Add Observations">
                                <div>
                                    <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                                        link: <spring:message code="pregnancycdss.patientExamForm.Delete.form"/>
                                    </a>
                                </div>
                            </openmrs:hasPrivilege>
                        </div>
                    </td>
                    <td>
                        <div id="addPtientExamForm">
                            <openmrs:hasPrivilege privilege="Add Observations">
                                <div>
                                    <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                                        link: <spring:message code="pregnancycdss.patientExamForm.Edit.open"/>
                                    </a>
                                </div>
                            </openmrs:hasPrivilege>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                link: <spring:message code="pregnancycdss.patientExamForm.New.form"/>
            </a>
        </div>
    </openmrs:hasPrivilege>
</div>