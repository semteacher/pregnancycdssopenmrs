<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<p>encounterPatientExamData Portlet: The current patient Pregnancy Exam Form data will be there!</p>
<p>encounterId=${encounter.encounterId}</p>
<p>patientId=${encounter.patient.patientId}</p>
<p>All Encounter Data=${encounter}</p>
<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <a href="${pageContext.request.contextPath}/module/pregnancycdss/patientExam.form?encounterId=${encounter.encounterId}">
                link: <spring:message code="pregnancycdss.managepatientexams"/>
            </a>
        </div>
    </openmrs:hasPrivilege>
</div>