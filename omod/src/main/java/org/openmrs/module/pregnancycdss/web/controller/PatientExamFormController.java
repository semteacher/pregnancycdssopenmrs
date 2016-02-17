/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.DiseasesProbability;
import org.openmrs.module.pregnancycdss.DiseasesSymptOptModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.PatientSymptomByExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@Controller
public class PatientExamFormController {

    protected final Log log = LogFactory.getLog(getClass());
    private List<PatientSymptomByExamModel> patientSymptoms = new ArrayList<PatientSymptomByExamModel>();
    private List<PatientSymptomByExamModel> patientSymptoms1 = new ArrayList<PatientSymptomByExamModel>();

    @RequestMapping(value = "/module/pregnancycdss/patientExamForm", method = RequestMethod.GET)
    public void showForm(ModelMap model, HttpServletRequest request, @RequestParam("patientExamFormId") Integer patientExamFormId, @RequestParam("encounterId") Integer encounterId, @RequestParam("patientId") Integer patientId) {
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

            if (patientExamFormId != null) {
                patientExamForm = Context.getService(pregnancycdssserviceService.class).getPatientExamById(patientExamFormId);

            } else {
                //PatientExamModel patientExamForm = new PatientExamModel();
            }
            //texting
//            PatientExamModel patientExamForm = new PatientExamModel(new Date(), Context.getAuthenticatedUser(), pat, enc);
//            patientSymptoms.clear();
//            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 1, 3));
//            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 2, 8));
//            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 3, 12));
//            patientSymptoms.add(new PatientSymptomByExamModel(patientExamForm, pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 4, 13));
//            
//            patientSymptoms1.clear();
//            patientSymptoms1.add(new PatientSymptomByExamModel(pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 1, 2));
//            patientSymptoms1.add(new PatientSymptomByExamModel(pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 2, 7));
//            patientSymptoms1.add(new PatientSymptomByExamModel(pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 3, 11));
//            patientSymptoms1.add(new PatientSymptomByExamModel(pat.getId(), Context.getAuthenticatedUser().getUserId(), 1, 4, 14));
//                        
//            patientExamForm.setPatientSymptoms(patientSymptoms);
//            Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);

            ///patientExamForm = Context.getService(pregnancycdssserviceService.class).getPatientExamByEncouter(encounterId);

            //PatientSymptomByExamModel testsymptopt = patientExamForm.getPatientSymptoms().get(3);

            model.put("patientExamForm", patientExamForm);
            System.out.println("semteacher: 1650. completed model variable: ok or not?...");
            System.out.println(model.toString());
            List<String> selectedSymptOpt = new ArrayList();
            model.put("selectedSymptOpt", selectedSymptOpt);
            //model.put("Current encounter is:", Context.getUserContext().getLocation());
//            if (request.getParameter("patientId") != null) {
//                model.put("appointment", getAppointment(null, Integer.parseInt(request.getParameter("patientId"))));
//            }
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(HttpServletRequest request,
            @RequestParam(value = "patientId", required = false) Integer patientid,
            @RequestParam(value = "examId", required = false) Integer examFormId,
            @RequestParam(value = "encountId", required = false) Integer encounterId) throws Exception {

        HttpSession httpSession = request.getSession();

        if (Context.isAuthenticated()) {
            if (request.getParameter("save") != null) {
                System.out.println("semteacher: 1700. save reques ok...");
                //Get patient
                PatientExamModel patientExamForm = null;
                patientExamForm = Context.getService(pregnancycdssserviceService.class).getPatientExamById(examFormId);
                //prepare patient diseases probability list
                Set<DiseasesProbability> patientDiseasesProbability = PrepareSetPatientDiseasesProbability();

                //get patient symptom list
                List<PatientSymptomByExamModel> patientSymptomList = patientExamForm.getPatientSymptoms();
                //create map to store form responce data
                Map<Integer, Integer[]> selectedSymptOpt = new HashMap<Integer, Integer[]>();
                Map<Integer, List<Integer>> selectedSymptOpt1 = new HashMap<Integer, List<Integer>>();

                List<SymptomModel> symptomlist = Context.getService(pregnancycdssserviceService.class).getAllSymptoms();
                //loop through  all symptoms
                for (int sympt = 0; sympt < symptomlist.size(); sympt++) {
                    System.out.println(symptomlist.get(sympt).getSymptName());
                    //check is it symptom selected is?
                    if (request.getParameterMap().containsKey("selectedSymptOpt[" + symptomlist.get(sympt).getId().toString() + "][]")) {
                        System.out.println("symptom ID=" + symptomlist.get(sympt).getId().toString() + " is in POST!");
                        //Symptom is selected! Get it:                
                        String[] selStrArr = request.getParameterValues("selectedSymptOpt[" + symptomlist.get(sympt).getId().toString() + "][]");
                        //convert string array to integer 
                        Integer[] selIntArr = new Integer[selStrArr.length];
                        for (int j = 0; j < selStrArr.length; j++) {
                            // Note that this is assuming valid input
                            // If you want to check then add a try/catch 
                            // and another index for the numbers if to continue adding the others
                            selIntArr[j] = Integer.parseInt(selStrArr[j]);
                        }
                        List<Integer> selIntList = Arrays.asList(selIntArr);
                        //store selection as HashMap
                        selectedSymptOpt.put(symptomlist.get(sympt).getId(), selIntArr);
                        selectedSymptOpt1.put(symptomlist.get(sympt).getId(), selIntList);
                        //Get diseases form the current selection to the final list 
                        FillSetPatientDiseasesProbability(patientDiseasesProbability, selIntList);
                        //check symptom type:
                        if (symptomlist.get(sympt).getIsMulti()) {
                            System.out.println("multi-YES");
                            //Symptom has multiple options
                            //get list of symptom options and iterate each
                            List<SymptomOptionModel> tmpSymptOptList = symptomlist.get(sympt).getSymptOpt();
                            for (SymptomOptionModel tmpSymptOpt : tmpSymptOptList) {
                                if (tmpSymptOpt != null) {
                                    //is it symptom option in POST?
                                    Boolean isCurrSymptOptInPOST = selIntList.contains(tmpSymptOpt.getId());
                                    //is it symptom option in database?
                                    Boolean isCurrSymptOptInDB = false;
                                    PatientSymptomByExamModel currSymptOptInDB = null;
                                    for (PatientSymptomByExamModel tmpPatientSymptom : patientSymptomList) {
                                        if (tmpPatientSymptom != null) {
                                            Boolean testres = tmpPatientSymptom.getSymptOptId().intValue() == tmpSymptOpt.getSymptOptId().intValue();
                                            System.out.println("checkDB: is " + tmpPatientSymptom.getSymptOptId() + "=" + tmpSymptOpt.getId() + " ?:" + testres);
                                            if (testres) {
                                                System.out.println(tmpSymptOpt.getSymptOptId().toString() + " symptoptID found in DB!!!");
                                                isCurrSymptOptInDB = true;
                                                currSymptOptInDB = tmpPatientSymptom;
                                            }
                                        }
                                    }
                                    if (currSymptOptInDB != null) {
                                        if (isCurrSymptOptInPOST == false) {
                                            System.out.println(currSymptOptInDB.getSymptOptId().toString() + " symptoptID will be deleted");
                                            //symptom option is in database but not in POST:it is unchecked and will be deleted
                                            patientSymptomList.remove(currSymptOptInDB);
                                            patientExamForm.setExamDate(new Date());
                                            patientExamForm.setExamUserId(Context.getAuthenticatedUser());
                                            patientExamForm.setPatientSymptoms(patientSymptomList);
                                            Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                                            System.out.println(currSymptOptInDB.getSymptOptId().toString() + " delete and save ok");
                                        }
                                    } else {
                                        if (isCurrSymptOptInPOST != false) {
                                            System.out.println(tmpSymptOpt.getOptName() + " will be added");
                                            //Insert one new record
                                            patientSymptomList.add(new PatientSymptomByExamModel(patientExamForm, patientid, Context.getAuthenticatedUser().getUserId(), tmpSymptOpt.getSymptom().getSymptCategory().getId(), tmpSymptOpt.getSymptom().getId(), tmpSymptOpt.getId()));
                                            patientExamForm.setExamDate(new Date());
                                            patientExamForm.setExamUserId(Context.getAuthenticatedUser());
                                            patientExamForm.setPatientSymptoms(patientSymptomList);
                                            Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                                            System.out.println(tmpSymptOpt.getOptName() + " added and saved ok");
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("multi-NO");
                            List<Integer> patientSymptomsBySymptomIdPosList = getSymtomsPos(patientSymptomList, symptomlist.get(sympt).getSymptId());
                            if (patientSymptomsBySymptomIdPosList.size() > 0) {
                                if (patientSymptomsBySymptomIdPosList.size() > 1) {
                                    //delete all and insert new one
                                    for (Integer tmpPos : patientSymptomsBySymptomIdPosList) {
                                        patientSymptomList.remove(tmpPos.intValue());
                                    }
                                    //Insert one new record
                                    System.out.println(selIntList.get(0) + " symptOptId will be added");
                                    patientSymptomList.add(new PatientSymptomByExamModel(patientExamForm, patientid, Context.getAuthenticatedUser().getUserId(), symptomlist.get(sympt).getSymptCategory().getSymptCatId(), symptomlist.get(sympt).getSymptId(), selIntList.get(0)));
                                    patientExamForm.setExamDate(new Date());
                                    patientExamForm.setExamUserId(Context.getAuthenticatedUser());
                                    patientExamForm.setPatientSymptoms(patientSymptomList);
                                    Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                                    System.out.println(selIntList.get(0) + " symptOptId added and saved ok");
                                } else {
                                    //Update single record
                                    if (patientSymptomList.get(patientSymptomsBySymptomIdPosList.get(0).intValue()).getSymptOptId().intValue() != selIntList.get(0).intValue()) {
                                        System.out.println(selIntList.get(0) + " symptOptId will be updated");
                                        patientSymptomList.get(patientSymptomsBySymptomIdPosList.get(0).intValue()).setSymptOptId(selIntList.get(0));
                                        patientExamForm.setExamDate(new Date());
                                        patientExamForm.setExamUserId(Context.getAuthenticatedUser());
                                        patientExamForm.setPatientSymptoms(patientSymptomList);
                                        Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                                        System.out.println(selIntList.get(0) + " symptOptId added and saved ok");
                                    } else {
                                        System.out.println(selIntList.get(0) + " symptOptId will be skipped");
                                    }
                                }
                            } else {
                                //Insert one new record
                                System.out.println(selIntList.get(0) + " symptOptId will be added");
                                patientSymptomList.add(new PatientSymptomByExamModel(patientExamForm, patientid, Context.getAuthenticatedUser().getUserId(), symptomlist.get(sympt).getSymptCategory().getSymptCatId(), symptomlist.get(sympt).getSymptId(), selIntList.get(0)));
                                patientExamForm.setExamDate(new Date());
                                patientExamForm.setExamUserId(Context.getAuthenticatedUser());
                                patientExamForm.setPatientSymptoms(patientSymptomList);
                                Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                                System.out.println(selIntList.get(0) + " symptOptId added and saved ok");
                            }
                        }
                    }
                }
                //set expected disease with probability alghoritm
                patientExamForm.setExpectedDisease(GetExpectedDisease(patientDiseasesProbability));
                Context.getService(pregnancycdssserviceService.class).savePatientExam(patientExamForm);
                //generate diseases list
                //for (Map<Integer, List<Integer>> selection: selectedSymptOpt1){
                //}

//                if (request.getParameterMap().containsKey("selectedSymptOpt[71][]")) {
//                    String[] my_sel_arr = request.getParameterValues("selectedSymptOpt[71][]");
//                    System.out.println(my_sel_arr);
//                }

                //System.out.println("semteacher: 1710. request: " + request.getParameter("selectedSymptOpt").toString());
                //System.out.println("semteacher: 1710. request: " + request.getParameter("selectedSymptOpt[71][]").toString());
                //selectedSymptOpt = request.getParameter("selectedSymptOpt");
                //request.getParameterNames();
                //System.out.println("semteacher: 1720. request symptom_options: "+request.getParameter("symptom_options").toString());
//                if (result.hasErrors()) {
//                    return null;
//                } else {
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
//                    return null;
//                }
            }
//			if (request.getParameter("findAvailableTime") != null) {
//				if (fromDate != null && toDate != null && !fromDate.before(toDate))
//					result.rejectValue("timeSlot", "appointmentscheduling.Appointment.error.InvalidDateInterval");
//			}
        }
        //go back to encounter
        return "redirect:/admin/encounters/encounter.form?encounterId=" + encounterId.intValue();
    }

    public List<Integer> getSymtomsPos(List<PatientSymptomByExamModel> patientSymptomsList, Integer symptomId) {
        List<Integer> symtomsPos = new ArrayList<Integer>();
        for (PatientSymptomByExamModel tmpPatientSymptom : patientSymptomsList) {
            if (tmpPatientSymptom != null) {
                Boolean testres = tmpPatientSymptom.getSymptomId().intValue() == symptomId.intValue();
                System.out.println("PatModel - checkDB: is " + tmpPatientSymptom.getSymptomId() + "=" + symptomId.intValue() + " ?:" + testres);
                if (testres) {
                    int currpos = patientSymptomsList.indexOf(tmpPatientSymptom);
                    symtomsPos.add(new Integer(currpos));
                }
            }
        }
        return symtomsPos;
    }

    //fill patient diseases probability list with default values
    public Set<DiseasesProbability> PrepareSetPatientDiseasesProbability() {
        Set<DiseasesProbability> patientDiseasesProbability = new HashSet<DiseasesProbability>();
        List<DiseasesModel> diseaseslist = Context.getService(pregnancycdssserviceService.class).getAllDiseases();
        for (DiseasesModel currDisease : diseaseslist) {
            DiseasesProbability tmpDiseasesProbability = new DiseasesProbability(currDisease.getDiseasesId(), currDisease.getDiseasesName(), new Float(1), new Float(1), 0);
            patientDiseasesProbability.add(tmpDiseasesProbability);
        }
        return patientDiseasesProbability;
    }

    //calculate diseases probability by Guliaev algorithm
    public void FillSetPatientDiseasesProbability(Set<DiseasesProbability> patientDiseasesProbability, List<Integer> selIntList) {
        //process all selections
        for (Integer selectedSymptOptId : selIntList) {
            //TODO:get list of diseases related to given selected symptom option ID
            List<DiseasesSymptOptModel> diseasesSymptOptlist = Context.getService(pregnancycdssserviceService.class).getDiseasesSymptOptBySymptoptId(selectedSymptOptId);
            //check is it diseases list exist
            if (diseasesSymptOptlist.size() > 0) {
                //process all selected diseases
                for (DiseasesSymptOptModel tmpDiseasesSymptOpt : diseasesSymptOptlist) {
                    //process all patient diseases list items
                    for (DiseasesProbability tmpDiseasesProbability : patientDiseasesProbability) {
                        if (tmpDiseasesProbability.getDiseaseId().intValue() == tmpDiseasesSymptOpt.getDisiase().getDiseasesId().intValue()) {
                            tmpDiseasesProbability.setPy(tmpDiseasesProbability.getPy().floatValue() * tmpDiseasesSymptOpt.getPy().floatValue());
                            //tmpDiseasesProbability.pn.floatValue() = tmpDiseasesProbability.pn.floatValue()*tmpDiseasesSymptOpt.pn.floatValue();
                            tmpDiseasesProbability.setPn(tmpDiseasesProbability.getPn().floatValue() * tmpDiseasesSymptOpt.getPn().floatValue());
                            //tmpDiseasesProbability.selCount.intValue() = tmpDiseasesProbability.selCount.intValue()+1;
                            tmpDiseasesProbability.setSelcount(tmpDiseasesProbability.getSelcount().intValue() + 1);
                        }
                    }
                }
            }
        }

    }

    //get expected disease from the set
    public String GetExpectedDisease(Set<DiseasesProbability> diseasesProbabilityList) {
        String expectedDisease = "Not defined!";
        Integer maxSelCount = 0;
        for (DiseasesProbability diseasesProbability : diseasesProbabilityList) {
            if (diseasesProbability.getSelcount().intValue() > maxSelCount.intValue()) {
                maxSelCount = diseasesProbability.getSelcount().intValue();
                expectedDisease = diseasesProbability.getDisiaseName();
            }
        }
        return expectedDisease;
    }

    //Convert patient form data to JSON
    @RequestMapping(value = "/module/pregnancycdss/patientExamForm.json", method = RequestMethod.GET)
    public @ResponseBody
    String getPatientDataJson2(HttpServletRequest request, @RequestParam(value = "examId") String examId, @RequestParam(value = "encounterId") String encounterId,
            @RequestParam(value = "patientId") String patientId) {
        if (Context.isAuthenticated()) {
            System.out.println("portlet-ajax_examId=" + examId);
            System.out.println("portlet-ajax_encounterId=" + encounterId);
            System.out.println("portlet-ajax_patientId=" + patientId);
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
            List<PatientSymptomByExamModel> patientSymptomList = patientExamForm.getPatientSymptoms();
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
                                symptOptPatientRecord.put("symp_id", tmpSymptom.getSymptId().intValue());
                                symptOptPatientRecord.put("symp_name", tmpSymptom.getSymptName().toString());
                                symptOptPatientRecord.put("opt_id", patientId);
                                symptOptPatientRecord.put("opt_name", tmpSymptOption.getOptName().toString());
                                //add array item (data row)
                                clientData.add(symptOptPatientRecord);
                                symptOptPatientRecord.clear();
                            }
                        }
                    } else {
                        //TODO:implement
                        //SymptomOptionModel tmpSelectedSymptOpt = Context.getService(pregnancycdssserviceService.class).getSelectedSymptomOption(patientId, encounterId, tmpSymptom.getSymptId());
                        Integer tmpSelectedSymptOptId = patientExamForm.getSelectedSymptomOption(tmpSymptom.getSymptId());
                        //will look like multichoice mode in GAEDecission tree 
                        symptOptPatientRecord.put("symp_id", tmpSymptom.getSymptId().intValue());
                        symptOptPatientRecord.put("symp_name", tmpSymptom.getSymptName().toString());
                        symptOptPatientRecord.put("opt_id", tmpSelectedSymptOptId);
                        symptOptPatientRecord.put("opt_name", encounterId);
                        //add array item (data row)
                        clientData.add(symptOptPatientRecord);
                        symptOptPatientRecord.clear();
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
            //String result = "<br>portlet-ajax_examId=<b>" + examId + "</b><br>portlet-ajax_encounterId=<b>" + encounterId + "</b><br>portlet-ajax_patientId=<b>" + patientId + "</b>";
            //System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller..");
            return result;
        } else {
            return "";
        }
    }
}
