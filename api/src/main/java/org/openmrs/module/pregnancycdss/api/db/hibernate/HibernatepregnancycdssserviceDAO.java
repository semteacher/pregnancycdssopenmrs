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
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.module.pregnancycdss.DiseasesModel;
import org.openmrs.module.pregnancycdss.DiseasesSymptOptModel;
import org.openmrs.module.pregnancycdss.PatientExamModel;
import org.openmrs.module.pregnancycdss.SymptCategoryModel;
import org.openmrs.module.pregnancycdss.SymptomModel;
import org.openmrs.module.pregnancycdss.SymptomOptionModel;
import org.openmrs.module.pregnancycdss.api.db.pregnancycdssserviceDAO;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

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
    public List<SymptomModel> getAllSymptoms() {
        System.out.println("semteacher: 10002. dao-getting session...");
        log.debug("semteacher: 10002. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 10003. dao-begin callin data ...");
        log.debug("semteacher: 10003. dao-begin callin data ...");
        List<SymptomModel> symptomslist = session.createCriteria(SymptomModel.class).list();
        //List<SymptomModel> symptomslist = session.createCriteria(SymptomModel.class).addOrder(Order.asc("idOrder")).list();

        System.out.println("semteacher: 10004. dao-callin data succesfull...");
        System.out.println(symptomslist.get(0).getSymptName());
        log.debug("semteacher: 10004. dao-callin data succesfull...");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return symptomslist;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<SymptomOptionModel> getAllSymptOptions() {
        System.out.println("semteacher: 20002. dao-getting session...");
        log.debug("semteacher: 10002. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 20003. dao-begin callin data ...");
        log.debug("semteacher: 20003. dao-begin callin data ...");
        List<SymptomOptionModel> symptomoptionslist = session.createCriteria(SymptomOptionModel.class).list();
        //List<SymptomModel> symptomslist = session.createCriteria(SymptomModel.class).addOrder(Order.asc("idOrder")).list();

        System.out.println("semteacher: 20004. dao-callin data succesfull...");
        System.out.println(symptomoptionslist.get(0).getOptName());
        log.debug("semteacher: 20004. dao-callin data succesfull...");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return symptomoptionslist;
        //throw new UnsupportedOperationException("Not supported yet.");
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
        log.debug("semteacher: 400. dao-callin data succesfull? record count:" + patientexamformslist.size());
        System.out.println("semteacher: 400. dao-callin data succesfull? record count:");
        System.out.println(patientexamformslist.size());

        return patientexamformslist;
    }

    @Override
    //@Transactional(readOnly = true)
    public List<PatientExamModel> getPatientExamByEncouter(Encounter encounter) {
        System.out.println("semteacher: 1200. dao-getting session...");
        log.debug("semteacher: 1200. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 1300. dao-begin callin data ... encounter ID=" + encounter.getEncounterId().toString());
        log.debug("semteacher: 1300. dao-begin callin data ...");
        SymptCategoryModel symptcategoryone = (SymptCategoryModel) session.createCriteria(SymptCategoryModel.class).add(Restrictions.eq("symptCatId", 1)).uniqueResult();
        System.out.println("semteacher: 1310. test data: " + symptcategoryone.toString());
        //List<PatientExamModel> patientexamformslist = session.createCriteria(PatientExamModel.class).list();
        //log.debug("semteacher: 1320. dao-callin data succesfull? record count:" + patientexamformslist.size());
        //System.out.println("semteacher: 400. dao-callin data succesfull? record count=" + patientexamformslist.size());

        //PatientExamModel patientexamform = (PatientExamModel) session.createCriteria(PatientExamModel.class).add(Restrictions.eq("encounterId", EncouterId)).uniqueResult();
        List<PatientExamModel> patientexamformslist = session.createCriteria(PatientExamModel.class).add(Restrictions.eq("encounterId", encounter)).list();
        System.out.println("semteacher: 1350. test data: " + patientexamformslist.toString());
        //cr.add(Restrictions.eq("salary", 2000));
//        PatientExamModel patientexamform = (PatientExamModel) session.createQuery("from "+PatientExamModel.class.getSimpleName()+" AS pem WHERE pem.encounterId = :encounterId").setParameter("encounterId", EncouterId).uniqueResult();
//        
//        PatientExamModel patientexamform = session.createCriteria(PatientExamModel.class).list();
//        
//        	public Appointment getAppointmentByVisit(Visit visit) {
//		return (Appointment) super.sessionFactory
//				.getCurrentSession()
//				.createQuery(
//						"from " + mappedClass.getSimpleName()
//								+ " at where at.visit = :visit")
//				.setParameter("visit", visit).uniqueResult();
//	}

        return patientexamformslist;
    }

    @Override
    @Transactional
    public PatientExamModel savePatientExam(PatientExamModel patientExam) {
        Session session = sessionFactory.getCurrentSession();
        //session.saveOrUpdate(patientExam);
        session.persist(patientExam);
        return patientExam;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PatientExamModel> getPatientExamByPatient(Patient patient) {
        System.out.println("semteacher: 1400. dao-getting session...");
        log.debug("semteacher: 1400. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        List<PatientExamModel> patientexamformlist = null;
        patientexamformlist = session.createCriteria(PatientExamModel.class).add(Restrictions.eq("patientId", patient)).list();
        return patientexamformlist;
    }

    @Override
    public PatientExamModel getPatientExamById(Integer patientExamFormId) {
        log.debug("semteacher: 1500. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        PatientExamModel patientexamform = null;
        patientexamform = (PatientExamModel) session.createCriteria(PatientExamModel.class).add(Restrictions.eq("examId", patientExamFormId)).uniqueResult();
        return patientexamform;
    }

    @Override
    public Set<DiseasesSymptOptModel> getAllDiseasesBySymptOpt() {
        System.out.println("semteacher: 21002. dao-getting session...");
        log.debug("semteacher: 21002. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        System.out.println("semteacher: 21003. dao-begin callin data ...");
        log.debug("semteacher: 21003. dao-begin callin data ...");
        Set<DiseasesSymptOptModel> diseasessymptoptlist = (Set) session.createCriteria(DiseasesSymptOptModel.class).list();
        //List<SymptomModel> symptomslist = session.createCriteria(SymptomModel.class).addOrder(Order.asc("idOrder")).list();

        System.out.println("semteacher: 21004. dao-callin data succesfull... object count:" + diseasessymptoptlist.size());
        log.debug("semteacher: 21004. dao-callin data succesfull...object count:" + diseasessymptoptlist.size());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return diseasessymptoptlist;
    }

    @Override
    public List<DiseasesSymptOptModel> getDiseasesSymptOptBySymptoptId(Integer selectedSymptOptId) {
        System.out.println("semteacher: 24000. dao-getting session...");
        log.debug("semteacher: 24000. dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        List<DiseasesSymptOptModel> diseasesSymptOptBySymptoptIdlist = null;
        diseasesSymptOptBySymptoptIdlist = session.createCriteria(DiseasesSymptOptModel.class).add(Restrictions.eq("symptOpt.symptOptId", selectedSymptOptId)).list();
        return diseasesSymptOptBySymptoptIdlist;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SymptomOptionModel getSymptOptionById(Integer tmpSelectedSymptOptId) {
        System.out.println("semteacher: 20010. getSymptOptionById dao-getting session...");
        log.debug("semteacher: 20010. getSymptOptionById dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        SymptomOptionModel tmpSymptomOption = null;
        tmpSymptomOption = (SymptomOptionModel) session.createCriteria(SymptomOptionModel.class).add(Restrictions.eq("symptOptId", tmpSelectedSymptOptId)).uniqueResult();
        return tmpSymptomOption;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DiseasesModel getDisease(Integer diseaseId) {
        System.out.println("semteacher: 12. getDisease dao-getting session...");
        log.debug("semteacher: 12. getDisease dao-getting session...");
        Session session = sessionFactory.getCurrentSession();
        DiseasesModel tmpDisease = null;
        tmpDisease = (DiseasesModel) session.createCriteria(DiseasesModel.class).add(Restrictions.eq("diseasesId", diseaseId)).uniqueResult();
        return tmpDisease;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
