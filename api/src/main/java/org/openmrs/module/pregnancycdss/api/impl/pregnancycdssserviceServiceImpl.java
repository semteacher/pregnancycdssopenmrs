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
package org.openmrs.module.pregnancycdss.api.impl;

import java.util.List;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.pregnancycdssserviceService;
import org.openmrs.module.pregnancycdss.api.db.pregnancycdssserviceDAO;

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
        log.debug("semteacher: 1. Calling dao from service...");
        return dao.getAllAppointments();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}