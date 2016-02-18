<%@ include file="/WEB-INF/template/include.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />

<script type="text/javascript">
    $j(document).ready(function() {
        $j('#patientexamformslistTable').dataTable();
    } );
    function submitData2GAE(formData){
        alert('formData='+JSON.stringify(formData));
        jQuery.ajax({  
            type : 'GET',   
            url : 'http://contactmgr.loc/site/yii2curltest',   
            data : formData,  
            dataType : 'json',
            success : function(response) {
                var mystr = JSON.stringify(response);
                console.log(response);
                console.log(mystr);
                alert(mystr);
                //return response;
            },  
            error : function(e) {  
                alert('Error: ' + e);
                //return null;
            }  
        }); 
    };
    function gaeDecisionTreeSubmitFunction(examId,encounterId,patientId){
        alert('examId='+examId+', encounterId='+encounterId+', patientId='+patientId);
        jQuery.ajax({  
            type : 'GET',   
            url : '${pageContext.request.contextPath}/module/pregnancycdss/gAEDecisionTree/single.json',   
            data : 'examId=' + examId + '&encounterId=' + encounterId + '&patientId=' + patientId,  
            dataType : 'json',
            success : function(response) {
                var mystr = JSON.stringify(response);
                console.log(response);
                console.log(mystr);
                //alert(mystr);
                submitData2GAE(response);
            },  
            error : function(e) {  
                alert('Error: ' + e);
            }  
        }); 
    };
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
    <table id="patientexamformslistTable" class="display">
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
                <th>GAEDecisionTree submit</th>                
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
                        <div id="submitPtientExamForm2GAE2">
                            <openmrs:hasPrivilege privilege="Add Observations">
                                <div>
                                    <input type="button" class="submitGAE" value="<spring:message code="pregnancycdss.patientExamForm.Submit.decisionTreeGAE"/>" onclick="gaeDecisionTreeSubmitFunction(${patientexamformlst.examId}, ${encounter.encounterId}, ${encounter.patient.patientId})">
                                </div>
                            </openmrs:hasPrivilege>
                        </div>
                    </td>
                    <td>
                        <div id="edittPtientExamForm">
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
                        <div id="deletePtientExamForm">
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
</p>