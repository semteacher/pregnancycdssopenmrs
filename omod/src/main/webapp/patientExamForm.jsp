<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<openmrs:htmlInclude file="/moduleResources/pregnancycdss/modulestyle.css" />
<%@ include file="template/localHeader.jsp"%>

<p>Survey for the patient: Id=${patientId} name=${patientdata.names}</p>
<p>Is it first pregnancy: ${patientExamForm.isFirstPregnancy}</p>
<p>Encounter Id=${encounterId} Form Id=${patientExamForm.examId}</p>
<p>Form created=${patientExamForm.createDate} by user ${patientExamForm.createUserId.name} ${patientExamForm.createUserId.familyName}</p>
<p>Form updated= ${patientExamForm.examDate} by user ${patientExamForm.examUserId.name} ${patientExamForm.examUserId.familyName}</p>
<p>All Encounter Data=${encounerdata}</p>

<form:form method="post" id="editPatientExamForm" name="pregnancy_cdss_form" >
    <fieldset>
        <input type="hidden" name="patientId" value="${patientId}" />
        <input type="hidden" name="encountId" value="${encounterId}" />
        <input type="hidden" name="examId" value="${patientExamForm.examId}" />
        <input type="hidden" name="isFirstPregnancy" value="${patientExamForm.isFirstPregnancy}" />
        <input type="hidden" name="process" value="true" />       
        <c:choose>
            <c:when test="${patientExamForm.finaldiseaseId < 1}">
                <c:set var="first_row_sel" scope="page" value="selected"/>
            </c:when>
            <c:otherwise>
                <c:set var="first_row_sel" scope="page" value=""/>
            </c:otherwise>
        </c:choose> 
        <div class="bold warningtext deceases">Final Disease (if known)???: 
            <select id="final_deceasedd" name="finaldeceasedd">
                <option value="0" ${first_row_sel}>---Choose Final Disease:---</option>
                <c:forEach var="disease" items="${diseasesList}">
                    <c:choose>
                        <c:when test="${patientExamForm.finaldiseaseId == disease.diseasesId}">
                            <c:set var="dis_row_sel" scope="page" value="selected"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="dis_row_sel" scope="page" value=""/>
                        </c:otherwise>
                    </c:choose> 
                    <option value="${disease.diseasesId}" ${dis_row_sel}>${disease.diseasesName}</option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" class="saveButton" name="save" value="<spring:message code='pregnancycdss.patientExamForm.Edit.save'/>" />
        <table id="symptCatTable"class="display">
            <tbody>
                <tr>
                    <td>
                        <c:forEach var="symptcategory" items="${symptcategorylist}">
                            <c:choose>
                                <c:when test="${symptcategory.isSelected == true}">
                                    <c:choose>
                                        <c:when test="${patientExamForm.isFirstPregnancy==true&&symptcategory.symptCatId==3}">
                                            <c:set var="hidden_status" scope="page" value="hidden"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="hidden_status" scope="page" value=""/>
                                        </c:otherwise>
                                    </c:choose>    
                                    <div class="symptcategory" rel="cat${symptcategory.symptCatId}" ${hidden_status} >
                                        <span class="symptcattitletext">${symptcategory.catName}</span>
                                        <c:forEach var="symptom" items="${symptcategory.symptoms}">
                                            <c:choose>
                                                <c:when test="${symptom.isSelected == true}">                                                
                                                    <div class="symptom" rel="sympt${symptom.symptId}">
                                                        <span class="symptomtext">${symptom.symptName}</span>
                                                        <c:forEach var="symptomOption" items="${symptom.symptOpt}">
                                                            <c:choose>
                                                                <c:when test="${symptomOption.isSelected == true}">
                                                                    <div class="symptoption" rel="opt${symptomOption.symptOptId}">
                                                                        <c:choose>
                                                                            <c:when test="${symptom.isMulti == true}">
                                                                                <c:set var="sel_type" scope="page" value="checkbox"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <c:set var="sel_type" scope="page" value="radio"/>
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <c:choose>
                                                                            <c:when test="${patientExamForm.patientSymptoms[symptomOption.symptOptId].symptOptId == symptomOption.symptOptId}">
                                                                                <c:set var="sel_status" scope="page" value="checked"/>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <c:set var="sel_status" scope="page" value=""/>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <span class="formtext"><input type="${sel_type}" id="${symptomOption.symptOptId}" name="selectedSymptOpt[${symptom.symptId}][]" value="${symptomOption.symptOptId}" ${sel_status} />${symptomOption.optName}</span>
                                                                    </div>
                                                                </c:when>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                </c:when>
                            </c:choose> 
                        </c:forEach>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" class="saveButton" name="save" value="<spring:message code='pregnancycdss.patientExamForm.Edit.save'/>" />        
    </fieldset>
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>