<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<p>encounterPatientExamData Portlet: The current patient Pregnancy Exam Form data will be there!</p>
<p>encounterId=${encounter.encounterId}</p>
<p>patientId=${encounter.patient.patientId}</p>
<p>All Encounter Data=${encounter}</p>
<p>model test - patient data: ${model.patientdata}</p>
<p>model test - patient form data: ${model.patientexamform}</p>
<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExamForm.form?encounterId=${encounter.encounterId}&patientId=${encounter.patient.patientId}">
                link: <spring:message code="pregnancycdss.managepatientexams"/>
            </a>
        </div>
    </openmrs:hasPrivilege>
</div>