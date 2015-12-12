<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>
<p>New patient exam form will be there!</p>
<p>encounterId=${encounterId}</p>
<p>patientId=${patientId}</p>
<p>All Encounter Data=${encounerdata}</p>
<p>model test - patient data: ${patientdata}</p>
<p>model test - patient form data: ${patientexamform}</p>
<p>${symptcategorylist}</p>

<form:form modelAttribute="patientExamForm" method="post" id="editPatientExamForm" name="pregnancy_cdss_form" >
    <fieldset>
        <table id="symptCatTable"class="display">
            <tbody>
                <tr>
                    <td>
                        <c:forEach var="symptcategory" items="${symptcategorylist}">
                            <c:choose>
                                <c:when test="${symptcategory.isSelected == true}">
                                    <div class="symptcategory" rel="cat${symptcategory.symptCatId}" >
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
                                                                        <span class="formtext"><input type="${sel_type}" id="${symptomOption.symptOptId}" name="symptom_options[${symptom.symptId}][]" value="${symptomOption.symptOptId}" />${symptomOption.optName}</span>
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
        <input type="button" class="saveButton" name="save" 
               value="<spring:message code='pregnancycdss.patientExamForm.Edit.save'/>" />
    </fieldset>
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp"%>