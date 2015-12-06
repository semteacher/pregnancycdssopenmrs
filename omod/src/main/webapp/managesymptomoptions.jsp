<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery/jquery.min.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.min.js" />


<script type="text/javascript">
    $j(document).ready(function() {
        $j('#symptomOptionsTable').dataTable();
    } );
</script>

<p>Hello ${user.systemId}!</p>


<table id="symptomOptionsTable"class="display">
    <thead>
        <tr>
            <th>OptionID</th>
            <th>Option Name</th>
            <th>Symptom</th>
            <th>Order</th>
            <th>Selected</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="symptomoption" items="${symptomoptionslist}">
            <tr>
                <td>${symptomoption.symptOptId}</td>
                <td>${symptomoption.optName}</td>
                <td>${symptomoption.symptom.symptName}</td>
                <td>${symptomoption.idOrder}</td>
                <td>
                    <c:choose>
                        <c:when test="${symptomoption.isSelected == true}">
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

<%@ include file="/WEB-INF/template/footer.jsp"%>