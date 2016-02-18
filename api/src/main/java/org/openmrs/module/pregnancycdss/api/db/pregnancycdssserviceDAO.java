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
package org.openmrs.module.pregnancycdss.api.db;

import java.util.List;
import java.util.Set;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.DiseasesSymptOptModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;

/**
 * Database methods for {@link pregnancycdssserviceService}.
 */
public interface pregnancycdssserviceDAO {

    public List<SymptCategoryModel> getAllAppointments();

    public List<DiseasesModel> getAllDiseases();

    public List<PatientExamModel> getAllPatientExamForms();

    public List<PatientExamModel> getPatientExamByEncouter(Encounter encounter);

    public List<SymptomModel> getAllSymptoms();

    public List<SymptomOptionModel> getAllSymptOptions();
    
    public PatientExamModel savePatientExam(PatientExamModel patientExam);

    public List<PatientExamModel> getPatientExamByPatient(Patient patient);

    public PatientExamModel getPatientExamById(Integer patientExamFormId);

    public Set<DiseasesSymptOptModel> getAllDiseasesBySymptOpt();

    public List<DiseasesSymptOptModel> getDiseasesSymptOptBySymptoptId(Integer selectedSymptOptId);

    public SymptomOptionModel getSymptOptionById(Integer tmpSelectedSymptOptId);

    public DiseasesModel getDisease(Integer diseaseId);
}
