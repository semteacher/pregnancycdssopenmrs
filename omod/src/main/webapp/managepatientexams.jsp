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
    function gaeDecisionTreeSubmitFunction(){
        alert('attempt to submit all');
        jQuery.ajax({  
            type : 'GET',   
            url : '${pageContext.request.contextPath}/module/pregnancycdss/gAEDecisionTree.json_all',   
            //data : 'examId=' + examId + '&encounterId=' + encounterId + '&patientId=' + patientId,  
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

<p>Hello ${user.systemId}!</p>

<div id="addPtientExamForm">
    <openmrs:hasPrivilege privilege="Add Observations">
        <div>
            <input type="button" class="submitGAE" value="<spring:message code="pregnancycdss.manage.submitDecisionTreeGAE"/>" onclick="gaeDecisionTreeSubmitFunction()">
        </div>
    </openmrs:hasPrivilege>
</div>
<hr>
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
        </tr>
    </thead>
    <tbody>
        <c:forEach var="patientexamform" items="${patientexamformslist}">
            <tr>
                <td>${patientexamform.examId}</td>
                <td>${patientexamform.examDate}</td>
                <td>${patientexamform.patientId.familyName}</td>
                <td>${patientexamform.encounterId}</td>
                <td>${patientexamform.createDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${patientexamform.isFirstPregnancy == true}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${patientexamform.expectedDisease}</td>
                <td>${patientexamform.finalDisease}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br><hr>
<%@ include file="/WEB-INF/template/footer.jsp"%>