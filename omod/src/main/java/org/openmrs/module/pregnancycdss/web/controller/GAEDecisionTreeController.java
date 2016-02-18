/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class GAEDecisionTreeController {

    protected final Log log = LogFactory.getLog(getClass());

    //Convert patient form data to JSON
    @RequestMapping(value = "/module/pregnancycdss/gAEDecisionTree.json", method = RequestMethod.GET)
    public void getPatientDataJson2(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "examId") String examId, @RequestParam(value = "encounterId") String encounterId,
            @RequestParam(value = "patientId") String patientId) throws IOException {
        if (Context.isAuthenticated()) {
            System.out.println("portlet-ajax_examId=" + examId);
            System.out.println("portlet-ajax_encounterId=" + encounterId);
            System.out.println("portlet-ajax_patientId=" + patientId);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            //init json objects: array and row
            JSONArray jsonPatientGAEDataArr = new JSONArray();
            JSONObject jsonPatientGAEDataObj = new JSONObject();

            JSONObject clientDescription = new JSONObject();
            clientDescription.put("url", request.getContextPath().toString());
            clientDescription.put("form_name", "Pregnancy CDSS Form");
            clientDescription.put("patient_id", patientId);
            clientDescription.put("encounter_id", encounterId);
            clientDescription.put("exam_id", examId);

            JSONArray clientDecease = new JSONArray();

            JSONArray clientData = new JSONArray();

            //Get patient
            PatientExamModel patientExamForm = null;
            patientExamForm = Context.getService(pregnancycdssserviceService.class).getPatientExamById(Integer.parseInt(examId));
            //get patient symptom list
            //List<PatientSymptomByExamModel> patientSymptomList = patientExamForm.getPatientSymptoms();
            //get symptom list
            List<SymptomModel> symptomList = Context.getService(pregnancycdssserviceService.class).getAllSymptoms();
            //process all symptoms
            for (SymptomModel tmpSymptom : symptomList) {
                if (tmpSymptom != null) {
                    //prepare arrayitem (data row) object
                    JSONObject symptOptPatientRecord = new JSONObject();
                    //check symptom type
                    if (tmpSymptom.getIsMulti()) {
                        //get symptom options list
                        List<SymptomOptionModel> symptOptionList = tmpSymptom.getSymptOpt();
                        //precess each symptom option
                        for (SymptomOptionModel tmpSymptOption : symptOptionList) {
                            if (tmpSymptOption != null) {
                                //will look like YES/NO mode in GAEDecission tree
                                //TODO:implement
                                //Boolean isSelectedSymptOpt = Context.getService(pregnancycdssserviceService.class).isSymptomOptionSelected(patientId, encounterId, tmpSymptom.getSymptId());
                                Integer isSelectedSymptOptId = patientExamForm.isSymptomOptionSelected(tmpSymptOption.getSymptOptId());
                                symptOptPatientRecord.put("symp_id", tmpSymptom.getSymptId().intValue());
                                symptOptPatientRecord.put("symp_name", tmpSymptom.getSymptName().toString());
                                symptOptPatientRecord.put("opt_id", isSelectedSymptOptId);
                                symptOptPatientRecord.put("opt_name", tmpSymptOption.getOptName().toString());
                                //add array item (data row)
                                clientData.add(symptOptPatientRecord);
                                //symptOptPatientRecord.clear();
                            }
                        }
                    } else {                        
                        String tmpSymptOptName = null;
                        //get selected option for iven symptom
                        Integer tmpSelectedSymptOptId = patientExamForm.getFirstSelectedSymptomOption(tmpSymptom.getSymptId());
                        //get symptom name fr the existed selections
                        if (tmpSelectedSymptOptId != null) {
                            SymptomOptionModel tmpSelectedSymptOpt = Context.getService(pregnancycdssserviceService.class).getSymptOptionById(tmpSelectedSymptOptId);
                            tmpSymptOptName = tmpSelectedSymptOpt.getOptName().toString();
                        }
                        //will look like multichoice mode in GAEDecission tree 
                        symptOptPatientRecord.put("symp_id", tmpSymptom.getSymptId().intValue());
                        symptOptPatientRecord.put("symp_name", tmpSymptom.getSymptName().toString());
                        symptOptPatientRecord.put("opt_id", tmpSelectedSymptOptId);
                        symptOptPatientRecord.put("opt_name", tmpSymptOptName);
                        //add array item (data row)
                        clientData.add(symptOptPatientRecord);
                        //symptOptPatientRecord.clear();
                    }
                }
            }
            //construct row object
            jsonPatientGAEDataObj.put("client_description", clientDescription);
            jsonPatientGAEDataObj.put("client_decease", clientDecease);
            jsonPatientGAEDataObj.put("client_data", clientData);
            //insert row into the array
            jsonPatientGAEDataArr.add(jsonPatientGAEDataObj);

            String result = jsonPatientGAEDataArr.toJSONString();
            System.out.println("portlet-ajax_json= " + result);

            //response.getWriter().write(result);
            response.getWriter().println(jsonPatientGAEDataArr);
        } else {
            //return null;
        }
    }
}
