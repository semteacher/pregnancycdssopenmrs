/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.PatientSymptomByExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    private List<PatientSymptomByExamModel> patientSymptoms = new ArrayList<PatientSymptomByExamModel>();

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

            //PatientExamModel patientExamForm = null;
            PatientExamModel patientExamForm = new PatientExamModel(new Date(), Context.getAuthenticatedUser(), pat, enc);
            
            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 1, 3));
            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 2, 8));
            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 3, 12));
            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 4, 13));
            
            patientExamForm.setPatientSymptoms(patientSymptoms);
            
            //patientExamForm.
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

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(HttpServletRequest request, PatientExamModel patientExamForm, BindingResult result) throws Exception {
        HttpSession httpSession = request.getSession();

        if (Context.isAuthenticated()) {
            //AppointmentService appointmentService = Context.getService(AppointmentService.class);

            if (request.getParameter("save") != null) {
                System.out.println("semteacher: 1700. save reques ok...");
                //new AppointmentValidator().validate(appointment, result);
                System.out.println("semteacher: 1710. request: " + request.toString());
                request.getParameterNames();
                //System.out.println("semteacher: 1720. request symptom_options: "+request.getParameter("symptom_options").toString());
                if (result.hasErrors()) {
                    return null;
                } else {
//					appointment.setDateCreated(new Date());
//					if (flow != null) {
//						appointment.setStatus(AppointmentStatus.WALKIN);
//						//Start a new visit
//						String visitTypeIdString = Context.getAdministrationService().getGlobalProperty(
//						    AppointmentUtils.GP_DEFAULT_VISIT_TYPE);
//						Integer visitTypeId = Integer.parseInt(visitTypeIdString);
//						VisitType defaultVisitType = Context.getVisitService().getVisitType(visitTypeId);
//						
//						Visit visit = new Visit(appointment.getPatient(), defaultVisitType, new Date());
//						visit.setLocation(appointment.getTimeSlot().getAppointmentBlock().getLocation());
//						visit = Context.getVisitService().saveVisit(visit);
//						appointment.setVisit(visit);
//					} else
//						appointment.setStatus(AppointmentStatus.SCHEDULED);
//					appointmentService.saveAppointment(appointment);
//					httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "appointmentscheduling.Appointment.saved");
//					//Check whether to redirect to appointments manage form (origin=null) or to patientDashboard (origin=dashboard)
//					if (origin == null)
//						return "redirect:appointmentList.list";
//					else if (origin.equals("dashboard"))
//						return "redirect:/patientDashboard.form?patientId=" + appointment.getPatient().getId().toString();
//                                        
                    return null;
                }
            }
//			if (request.getParameter("findAvailableTime") != null) {
//				if (fromDate != null && toDate != null && !fromDate.before(toDate))
//					result.rejectValue("timeSlot", "appointmentscheduling.Appointment.error.InvalidDateInterval");
//			}
        }
        return null;
    }
}
