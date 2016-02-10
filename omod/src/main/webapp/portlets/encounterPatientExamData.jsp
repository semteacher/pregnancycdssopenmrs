<%@ include file="/WEB-INF/template/include.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#patientexamformslistTable').dataTable();
    } );
</script>

<p>
<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                <spring:message code="pregnancycdss.patientExamForm.New.form"/>
            </a>
        </div>
    </openmrs:hasPrivilege>
</div>
</p>
<div id="ptientExamTable">
    <table id="patientexamformslistTable"class="display">
        <thead>
            <tr>
                <th>Exam ID</th>
                <th>Form Created</th>
                <th>Patient ID</th>                
                <th>Last Updated</th>            
                <th>First Pregnancy</th>
                <th>Final Disease</th>
                <th>Expected Disease</th>
                <th>DecisionTree Disease</th>
                <th>submit to DecisionTree</th>
                <th>Edit survey form </th>
                <th>Delete survey form </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patientexamformlst" items="${model.patientexamformslist}">
                <tr>
                    <td>${patientexamformlst.examId}</td>
                    <td>${patientexamformlst.createDate}</td>
                    <td>${patientexamformlst.patientId.familyName}</td>                    
                    <td>${patientexamformlst.examDate}</td>
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
                    <td>${patientexamformlst.finalDisease}</td>
                    <td>${patientexamformlst.expectedDisease}</td>
                    <td>${patientexamformlst.decisionTreeDiseasesList}</td>
                    
                    <td>
                        <div id="addPtientExamForm">
                            <openmrs:hasPrivilege privilege="Add Observations">
                                <div>
                                    <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.decisionTreeGAE?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                                        <spring:message code="pregnancycdss.patientExamForm.Submit.decisionTreeGAE"/>
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
                                        <spring:message code="pregnancycdss.patientExamForm.Edit.open"/>
                                    </a>
                                </div>
                            </openmrs:hasPrivilege>
                        </div>
                    </td>
                    <td>
                        <div id="addPtientExamForm">
                            <openmrs:hasPrivilege privilege="Add Observations">
                                <div>
                                    <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.delete?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                                        <spring:message code="pregnancycdss.patientExamForm.Delete.form"/>
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
<p>
<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?patientExamFormId=${patientexamformlst.examId}&encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                <spring:message code="pregnancycdss.patientExamForm.New.form"/>
            </a>
        </div>
    </openmrs:hasPrivilege>
</div>
<a href="${pageContext.request.contextPath}/admin/encounters/encounter.form?encounterId=${encounter.encounterId}&gaesubmit=true&patientExamFormId=${patientexamformlst.examId}&&patientId=${encounter.patient.patientId}">
                <spring:message code="pregnancycdss.patientExamForm.New.form"/>
            </a>
<div id="tmpSymtomTableBlock">
<table id="symptomsTable" class="display">
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
        <c:forEach var="symptom" items="${model.symptomList}">
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
</div>
</p>