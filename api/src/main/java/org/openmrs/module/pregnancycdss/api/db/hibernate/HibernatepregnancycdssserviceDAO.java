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
package org.openmrs.module.pregnancycdss.api.db.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.db.pregnancycdssserviceDAO;

/**
 * It is a default implementation of  {@link pregnancycdssserviceDAO}.
 */
public class HibernatepregnancycdssserviceDAO implements pregnancycdssserviceDAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private SessionFactory sessionFactory;
	
	/**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
    }
    
	/**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
	    return sessionFactory;
    }

    @Override
    public List<SymptCategoryModel> getAllAppointments() {
        log.debug("semteacher: 2. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        log.debug("semteacher: 3. dao-begin callin data ...");
        List<SymptCategoryModel> symptcategorylist = session.createCriteria(SymptCategoryModel.class).addOrder(Order.asc("cat_name")).list();
        log.debug("semteacher: 4. dao-callin data succesfull...");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return symptcategorylist;
    }
}