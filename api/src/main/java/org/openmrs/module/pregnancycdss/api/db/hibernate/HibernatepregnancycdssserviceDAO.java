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
package org.openmrs.module.pregnancycdss.api.db.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.api.db.pregnancycdssserviceDAO;

/**
 * It is a default implementation of {@link pregnancycdssserviceDAO}.
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
        System.out.println("semteacher: 2. dao-getting session...");
        log.debug("semteacher: 2. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 3. dao-begin callin data ...");
        log.debug("semteacher: 3. dao-begin callin data ...");
        List<SymptCategoryModel> symptcategorylist = session.createCriteria(SymptCategoryModel.class).addOrder(Order.asc("symptCatId")).list();
        //List<SymptCategoryModel> symptcategorylist = session. createCriteria(SymptCategoryModel.class).list();
        System.out.println("semteacher: 4. dao-callin data succesfull...");
        System.out.println(symptcategorylist.get(0).getCatName());
        log.debug("semteacher: 4. dao-callin data succesfull...");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return symptcategorylist;
    }

    @Override
    public List<DiseasesModel> getAllDiseases() {
        System.out.println("semteacher: 20. dao-getting session...");
        log.debug("semteacher: 20. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 30. dao-begin callin data ...");
        log.debug("semteacher: 30. dao-begin callin data ...");
        List<DiseasesModel> diseaseslist = session.createCriteria(DiseasesModel.class).list();
        System.out.println("semteacher: 40. dao-callin data succesfull...");
        System.out.println(diseaseslist.get(0).getDiseasesName());
        log.debug("semteacher: 40. dao-callin data succesfull...");
        return diseaseslist;
    }

    @Override
    public List<PatientExamModel> getAllPatientExamForms() {
        System.out.println("semteacher: 200. dao-getting session...");
        log.debug("semteacher: 200. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 300. dao-begin callin data ...");
        log.debug("semteacher: 300. dao-begin callin data ...");
        List<PatientExamModel> patientexamformslist = session.createCriteria(PatientExamModel.class).list();
        log.debug("semteacher: 400. dao-callin data succesfull? record count:"+patientexamformslist.size());
        System.out.println("semteacher: 400. dao-callin data succesfull? record count:");
        System.out.println(patientexamformslist.size());
        
        return patientexamformslist;
    }
}
