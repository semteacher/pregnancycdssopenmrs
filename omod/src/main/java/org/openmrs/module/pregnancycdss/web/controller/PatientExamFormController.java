/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class PatientExamFormController {

    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/pregnancycdss/patientExamForm", method = RequestMethod.GET)
    public void showForm(ModelMap model, HttpServletRequest request, @RequestParam("encounterId") Integer encounterId, @RequestParam("patientId") Integer patientId) {
        if (Context.isAuthenticated()) {
//            Object oe = request.getAttribute("org.openmrs.portlet.encounterId");
//            Encounter e = null;
//            if (oe != null) {
//                Integer EncounterId = (Integer) oe;
//            }
            model.put("encounterId", encounterId);
            model.put("patientId", patientId);

            Patient pat = null;
            pat = Context.getPatientService().getPatient(patientId);
            System.out.println("1610: patient data: " + pat.toString());
            model.put("patientdata", pat);

            Encounter enc = null;
            enc = Context.getEncounterService().getEncounter(encounterId);
            System.out.println("1620: encounter data: " + enc.toString());
            model.put("encounerdata", enc);

            List<SymptCategoryModel> symptcategorylist = Context.getService(pregnancycdssserviceService.class).getAllSymptCategories();
            System.out.println("semteacher: 1630. Got symptcategorylist from db: ok or not?...");
            System.out.println(symptcategorylist.get(0).getCatName());
            //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
            model.put("symptcategorylist", symptcategorylist);
            System.out.println("semteacher: 1640. completed model variable: ok or not?...");
            System.out.println(model.toString());
            
            PatientExamModel patientExamForm = null;
            //patientExamForm = Context.getService(pregnancycdssserviceService.class).getPatientExamByEncouter(encounterId);
            model.put("patientExamForm", patientExamForm);
            System.out.println("semteacher: 1650. completed model variable: ok or not?...");
            System.out.println(model.toString());            
            //model.put("Current encounter is:", Context.getUserContext().getLocation());
//            if (request.getParameter("patientId") != null) {
//                model.put("appointment", getAppointment(null, Integer.parseInt(request.getParameter("patientId"))));
//            }
        }
    }
}
