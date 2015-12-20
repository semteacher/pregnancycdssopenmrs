/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.openmrs.web.controller.PortletController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;

/**
 *
 * @author Admin
 */
@Controller
public class EncounterPatientExamDataPortletController extends PortletController {

    protected final Log log = LogFactory.getLog(getClass());

    //@SuppressWarnings("unchecked")
    @Override
    @RequestMapping("/module/pregnancycdss/encounterPatientExamData.portlet")
    protected void populateModel(HttpServletRequest request, Map<String, Object> model) {
        System.out.println("1500: portlet populate model calling - request...");
        System.out.println(request.toString());
        System.out.println(request.getQueryString());
        
        Object op = request.getAttribute("org.openmrs.portlet.patientId");
        Patient p = null;
        if (op != null) {
            Integer patientId = (Integer) op;
            p = Context.getPatientService().getPatient(patientId);
            System.out.println("1510: patient data: "+p.toString());
            model.put("patientdata", p.toString());
        }
        Object oe = request.getAttribute("org.openmrs.portlet.encounterId");
        Encounter e = null;
        if (oe != null) {
            Integer EncounterId = (Integer) oe;
            e = Context.getEncounterService().getEncounter(EncounterId);
            System.out.println("1520: encounter data: "+e.toString());
            
            //PatientExamModel patientexamform = Context.getService(pregnancycdssserviceService.class).getPatientExamByEncouter(EncounterId);
            model.put("patientexamform", "Patient Form Data Currently does not Mapped properly - the Hibernate error occurd!");
            List<PatientExamModel> patientexamformslist = Context.getService(pregnancycdssserviceService.class).getAllPatientExamForms();
            model.put("patientexamformslist", patientexamformslist);
        }        
        
// your code here
    }
}
