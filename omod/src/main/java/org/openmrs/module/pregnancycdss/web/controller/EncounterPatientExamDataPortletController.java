/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss.web.controller;

import org.openmrs.web.controller.PortletController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/module/pregnancycdss/encounterPatientExamData.portlet")
public class EncounterPatientExamDataPortletController extends PortletController {

    protected final Log log = LogFactory.getLog(getClass());
}
