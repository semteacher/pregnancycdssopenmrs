/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;

/**
 * The form controller.
 */
@Controller
public class PregnancyCDSSEncounterFormConroller {

    protected final Log log = LogFactory.getLog(getClass());

    @RequestMapping(value = "/module/pregnancycdss/PregnancyCDSSEncounterForm.box", method = RequestMethod.GET)
    public String showForm(HttpServletRequest request, @RequestParam("encounterId") Integer encounterId, @RequestParam("action") String action) {
        System.out.println("1001: PregnancyCDSSEncounterFormConroller: show form action?");
        if (action.equals("newPatientExam")) {
            return "redirect:/module/pregnancycdss/patientExam.form?encounterId=" + encounterId;
        } else {
            return "";
        }

    }
}
