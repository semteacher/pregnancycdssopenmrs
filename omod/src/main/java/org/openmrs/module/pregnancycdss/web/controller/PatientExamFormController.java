/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.api.context.Context;
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
            model.put("Current encounter is:", encounterId);
            model.put("Current patient is:", patientId);
            //model.put("Current encounter is:", Context.getUserContext().getLocation());
//            if (request.getParameter("patientId") != null) {
//                model.put("appointment", getAppointment(null, Integer.parseInt(request.getParameter("patientId"))));
//            }
        }
    }
}
