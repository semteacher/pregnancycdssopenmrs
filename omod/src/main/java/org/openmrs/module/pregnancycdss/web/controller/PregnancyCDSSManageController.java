/**
 * The contents of this file are subject to the OpenMRS Public License Version
 * 1.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 *
 * Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;

/**
 * The main controller.
 */
@Controller
public class PregnancyCDSSManageController {

    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/pregnancycdss/manage", method = RequestMethod.GET)
    public void manage(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 0. Try to get symptcategorylist from db: invoke service call...");
        System.out.println("semteacher: 0. Try to get symptcategorylist from db: invoke service call...");
        List<SymptCategoryModel> symptcategorylist = Context.getService(pregnancycdssserviceService.class).getAllSymptCategories();
        System.out.println("semteacher: 0.1. Got symptcategorylist from db: ok or not?...");
        System.out.println(symptcategorylist.get(0).getCatName());
        //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
        model.addAttribute("symptcategorylist", symptcategorylist);
        System.out.println("semteacher: 0.2. completed model variable: ok or not?...");
        System.out.println(model.toString());
    }

    @RequestMapping(value = "/module/pregnancycdss/managesymptoms", method = RequestMethod.GET)
    public void managesymptoms(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 10000.0 Try to get symptomslist from db: invoke service call...");
        System.out.println("semteacher: 10000.0 Try to get symptomslist from db: invoke service call...");
        List<SymptomModel> symptomslist = Context.getService(pregnancycdssserviceService.class).getAllSymptoms();
        System.out.println("semteacher: 10000.1. Got symptomslist from db: ok or not?...");
        System.out.println(symptomslist.get(0).getSymptName());
        //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
        model.addAttribute("symptomslist", symptomslist);
        System.out.println("semteacher: 10000.2. completed symptomslist model variable: ok or not?...");
        System.out.println(model.toString());
    }

    @RequestMapping(value = "/module/pregnancycdss/managesymptomoptions", method = RequestMethod.GET)
    public void managesymptomoptions(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 20000.0 Try to get symptomoptionslist from db: invoke service call...");
        System.out.println("semteacher: 20000.0 Try to get symptomoptionslist from db: invoke service call...");
        List<SymptomOptionModel> symptomoptionslist = Context.getService(pregnancycdssserviceService.class).getAllSymptOptions();
        System.out.println("semteacher: 20000.1. Got symptomoptionslist from db: ok or not?...");
        System.out.println(symptomoptionslist.get(0).getOptName());
        //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
        model.addAttribute("symptomoptionslist", symptomoptionslist);
        System.out.println("semteacher: 20000.2. completed symptomoptionslist model variable: ok or not?...");
        System.out.println(model.toString());
    }

    @RequestMapping(value = "/module/pregnancycdss/managediseases", method = RequestMethod.GET)
    public void managediseases(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 00. Try to get diseaseslist from db: invoke service call...");
        System.out.println("semteacher: 00. Try to get diseaseslist from db: invoke service call...");
        List<DiseasesModel> diseaseslist = Context.getService(pregnancycdssserviceService.class).getAllDiseases();
        System.out.println("semteacher: 00.10. Got diseaseslist from db: ok or not?...");
        System.out.println(diseaseslist.get(0).getDiseasesName());
        //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
        model.addAttribute("diseaseslist", diseaseslist);
        System.out.println("semteacher: 00.20. completed model variable: ok or not?...");
        System.out.println(model.toString());
    }
    
    @RequestMapping(value = "/module/pregnancycdss/managediseasessymptopt", method = RequestMethod.GET)
    public void managediseasessymptopt(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 22000.0 Try to get diseasesBySymptOptList from db: invoke service call...");
        System.out.println("semteacher: 22000.0 Try to get diseasesBySymptOptList from db: invoke service call...");
        Set<DiseasesSymptOptModel> diseasesBySymptOptList = Context.getService(pregnancycdssserviceService.class).getAllDiseasesBySymptOpt();
        System.out.println("semteacher: 22000.1. Got diseasesBySymptOptList from db: ok or not?...");
        System.out.println(diseasesBySymptOptList.get(0).getDiseasesSymptOptId());
        model.addAttribute("diseasesBySymptOptList", diseasesBySymptOptList);
        System.out.println("semteacher: 22000.2. completed diseasesBySymptOptList model variable: ok or not?...");
        System.out.println(model.toString());
    }

    @RequestMapping(value = "/module/pregnancycdss/managepatientexams", method = RequestMethod.GET)
    public void managepatientexams(ModelMap model) {
        model.addAttribute("user", Context.getAuthenticatedUser());
        log.debug("semteacher: 000. Try to get patientexamformslist from db: invoke service call...");
        System.out.println("semteacher: 000. Try to get patientexamformslist from db: invoke service call...");
        List<PatientExamModel> patientexamformslist = Context.getService(pregnancycdssserviceService.class).getAllPatientExamForms();
        System.out.println("semteacher: 000.100. Got patientexamformslist from db: ok or not?...");
        System.out.println(patientexamformslist.size());
        //model.addAttribute("symptcategorylist", Context.getService(pregnancycdssserviceService.class).getAllSymptCategories());
        model.addAttribute("patientexamformslist", patientexamformslist);
        System.out.println("semteacher: 000.200. completed model variable: ok or not?...");
        System.out.println(model.toString());
    }
}
