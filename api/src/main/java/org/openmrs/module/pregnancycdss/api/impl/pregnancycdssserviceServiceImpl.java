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
package org.openmrs.module.pregnancycdss.api.impl;

import java.util.List;
import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.api.APIException;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.openmrs.module.pregnancycdss.api.db.pregnancycdssserviceDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * It is a default implementation of {@link pregnancycdssserviceService}.
 */
public class pregnancycdssserviceServiceImpl extends BaseOpenmrsService implements pregnancycdssserviceService {

    protected final Log log = LogFactory.getLog(this.getClass());
    private pregnancycdssserviceDAO dao;

    /**
     * @param dao the dao to set
     */
    public void setDao(pregnancycdssserviceDAO dao) {
        this.dao = dao;
    }

    /**
     * @return the dao
     */
    public pregnancycdssserviceDAO getDao() {
        return dao;
    }

    @Override
    public List<SymptCategoryModel> getAllSymptCategories() {
        System.out.println("semteacher: 1. Calling dao from service...");
        log.debug("semteacher: 1. Calling dao from service...");
        return getDao().getAllAppointments();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SymptomModel> getAllSymptoms() throws APIException {
        System.out.println("semteacher: 10000. Calling dao from service...");
        log.debug("semteacher: 10000. Calling dao from service...");
        return getDao().getAllSymptoms();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DiseasesModel> getAllDiseases() throws APIException {
        System.out.println("semteacher: 10. Calling dao from service...");
        log.debug("semteacher: 10. Calling dao from service...");
        return getDao().getAllDiseases();
    }

    @Override
    public List<PatientExamModel> getAllPatientExamForms() throws APIException {
        System.out.println("semteacher: 100. Calling dao from service...");
        log.debug("semteacher: 100. Calling dao from service...");
        return getDao().getAllPatientExamForms();
    }

    @Override
    public List<PatientExamModel> getPatientExamByEncouter(Encounter encounter) throws APIException {
        System.out.println("semteacher: 1010. Calling dao from service...");
        log.debug("semteacher: 1010. Calling dao from service...");
        return getDao().getPatientExamByEncouter(encounter);
    }

    @Override
    public List<SymptomOptionModel> getAllSymptOptions() throws APIException {
        System.out.println("semteacher: 20000. Calling dao from service...");
        log.debug("semteacher: 20000. Calling dao from service...");
        return getDao().getAllSymptOptions();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Transactional
    public PatientExamModel savePatientExam(PatientExamModel patientExam) throws APIException {
        //throw new UnsupportedOperationException("Not supported yet.");
        //ValidateUtil.validate(appointmentType);
        return (PatientExamModel) getDao().savePatientExam(patientExam);
    }

    @Override
    public List<PatientExamModel> getPatientExamByPatient(Patient patient) {
        System.out.println("semteacher: 1020. Calling dao from service...");
        log.debug("semteacher: 1020. Calling dao from service...");
        return getDao().getPatientExamByPatient(patient);
    }
}
