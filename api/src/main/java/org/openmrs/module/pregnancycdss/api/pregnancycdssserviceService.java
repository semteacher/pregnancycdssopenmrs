/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.pregnancycdss.api;

import java.util.List;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(pregnancycdssserviceService.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface pregnancycdssserviceService extends OpenmrsService {
     
	/*
	 * Add service methods here
	 * 
	 */
    public List<SymptCategoryModel> getAllSymptCategories() throws APIException;
    public List<SymptomModel> getAllSymptoms() throws APIException;
    public List<DiseasesModel> getAllDiseases() throws APIException;
    public List<PatientExamModel> getAllPatientExamForms() throws APIException;
    
    public PatientExamModel getPatientExamByEncouter(Integer EncouterId);

}