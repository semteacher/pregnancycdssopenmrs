/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss;

import java.io.Serializable;
import java.util.Date;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.Encounter;
import org.openmrs.Patient;

/**
 *
 * @author Admin
 */
public class PatientExamModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer examId;
    private Date examDate;
    private Integer patientId;
    private Integer examUserId;
    private String groupName;
    private Integer authorized;
    private Integer activityId;
    private Integer encounterId;
    private Integer createUserId;
    private Date createDate;
    private Short isFirstPregnancy;
    //private String expectDisease;
    private String expectedDisease;
    private String diseasesList;
    private Integer finaldiseaseId;
    private String finalDisease;
    private String finalDiseaseICD10;
    private Integer decisionTreeDiseaseId;
    private String decisionTreeDiseasesList;
    private String decisionTreeImg;
    private String uuid;
    private Patient patient;
    private Encounter encounter;

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public PatientExamModel() {
    }

    public PatientExamModel(Integer examId) {
        this.examId = examId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getExamUserId() {
        return examUserId;
    }

    public void setExamUserId(Integer examUserId) {
        this.examUserId = examUserId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Integer authorized) {
        this.authorized = authorized;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(Integer encounterId) {
        this.encounterId = encounterId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createdate) {
        this.createDate = createdate;
    }

    public Short getIsFirstPregnancy() {
        return isFirstPregnancy;
    }

    public void setIsFirstPregnancy(Short isFirstPregnancy) {
        this.isFirstPregnancy = isFirstPregnancy;
    }

    public String getExpectedDisease() {
        return expectedDisease;
    }

    public void setExpectedDisease(String expectedDisease) {
        this.expectedDisease = expectedDisease;
    }

    public String getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(String diseasesList) {
        this.diseasesList = diseasesList;
    }

    public Integer getFinaldiseaseId() {
        return finaldiseaseId;
    }

    public void setFinaldiseaseId(Integer finaldiseaseId) {
        this.finaldiseaseId = finaldiseaseId;
    }

    public String getFinalDisease() {
        return finalDisease;
    }

    public void setFinalDisease(String finalDisease) {
        this.finalDisease = finalDisease;
    }

    public String getFinalDiseaseICD10() {
        return finalDiseaseICD10;
    }

    public void setFinalDiseaseICD10(String finalDiseaseICD10) {
        this.finalDiseaseICD10 = finalDiseaseICD10;
    }

    public Integer getDecisionTreeDiseaseId() {
        return decisionTreeDiseaseId;
    }

    public void setDecisionTreeDiseaseId(Integer decisionTreeDiseaseId) {
        this.decisionTreeDiseaseId = decisionTreeDiseaseId;
    }

    public String getDecisionTreeDiseasesList() {
        return decisionTreeDiseasesList;
    }

    public void setDecisionTreeDiseasesList(String decisionTreeDiseasesList) {
        this.decisionTreeDiseasesList = decisionTreeDiseasesList;
    }

    public String getDecisionTreeImg() {
        return decisionTreeImg;
    }

    public void setDecisionTreeImg(String decisionTreeImg) {
        this.decisionTreeImg = decisionTreeImg;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examId != null ? examId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientExamModel)) {
            return false;
        }
        PatientExamModel other = (PatientExamModel) object;
        if ((this.examId == null && other.examId != null) || (this.examId != null && !this.examId.equals(other.examId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.openmrs.module.pregnancycdss.PatientExamModel[ examId=" + examId + " ]";
    }

    @Override
    public Integer getId() {
        return getExamId();
    }

    @Override
    public void setId(Integer id) {
        setExamId(id);
    }

    @Override
    public String getUuid() {
        return super.getUuid();
    }
}
