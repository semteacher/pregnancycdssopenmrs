<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<openmrs:htmlInclude
    file="/moduleResources/pregnancycdss/Scripts/jquery.dataTables.js" />
<openmrs:htmlInclude
    file="/moduleResources/pregnancycdss/Styles/createSurveyStyle.css" />
<openmrs:htmlInclude
    file="/moduleResources/pregnancycdss/Styles/symptCatList_jQueryDatatable.css" />
<openmrs:htmlInclude
    file="/moduleResources/pregnancycdss/Styles/jQuerySmoothness/jquery-ui-1.9.2.custom.css" />

<script type="text/javascript">
    $j(document)
    .ready(
    function() {
        //Datatables.net
        $j('#symptCatTable')
        .dataTable(
        {
            "aoColumns" : [ {
                    "bSortable" : true
                }, {
                    "bSortable" : false
                }, {
                    "bSortable" : true
                } ],
            "aLengthMenu" : [
                [ 5, 10, 25, 50, -1 ],
                [ 5, 10, 25, 50, "All" ] ],
            "iDisplayLength" : 10,
            "sDom" : "<'fg-toolbar ui-toolbar ui-widget-header ui-corner-tl ui-corner-tr ui-helper-clearfix'l<'addons'>>t<'fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix'ipT<'toolbar'>>",
            "bLengthChange" : true,
            "bFilter" : false,
            "bInfo" : true,
            "bPaginate" : true,
            "bJQueryUI" : true,

            "fnDrawCallback" : function() {
                $j(".addons").html("");
                $j(".addons").prepend(
                "<openmrs:hasPrivilege privilege='Manage Symptoms Categories'> <input type='button' value='<spring:message code='pregnancycdss.SymptomCategories.add'/>' class='saveButton' style='margin:10px; float:right; display:block;' onclick='addNewSymptomCategory()'/></openmrs:hasPrivilege>");
            }
        });

    });
    </script>

    <p>Hello ${user.systemId}!</p>


<table id="symptCatTable">
    <tr>
        <th>CatID</th>
        <th>Symptom Category Name</th>
        <th>Symptom Category Description</th>
        <th>Selected</th>
    </tr>
    <c:forEach var="symptcategory" items="${symptcategorylist}">
        <tr>
            <td>${symptcategory.symptCatId}</td>
            <td>${symptcategory.catName}</td>
            <td>${symptcategory.catNotes}</td>
            <td>
                <c:choose>
                    <c:when test="${symptcategory.isSelected == true}">
                        Enabled
                    </c:when>
                    <c:otherwise>
                        Disabled
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/template/footer.jsp"%>