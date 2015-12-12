/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss;

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;

/**
 *
 * @author Admin
 */
public class PatientSymptomByExamModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer symptPatientId;
    private Integer examId;
    private Integer patientId;
    private Integer examUserId;
    private Integer symptomId;
    private Integer symptOptId;
    private Integer symptCatId;
    private Integer diseaseId;
    private Float py;
    private Float pn;
    private Integer idOrder;
    private String uuid;

    public PatientSymptomByExamModel() {
    }

    public PatientSymptomByExamModel(Integer symptPatientId) {
        this.symptPatientId = symptPatientId;
    }

    public Integer getSymptPatientId() {
        return symptPatientId;
    }

    public void setSymptPatientId(Integer symptPatientId) {
        this.symptPatientId = symptPatientId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
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

    public Integer getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Integer symptomId) {
        this.symptomId = symptomId;
    }

    public Integer getSymptOptId() {
        return symptOptId;
    }

    public void setSymptOptId(Integer symptOptId) {
        this.symptOptId = symptOptId;
    }

    public Integer getSymptCatId() {
        return symptCatId;
    }

    public void setSymptCatId(Integer symptCatId) {
        this.symptCatId = symptCatId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Float getPn() {
        return pn;
    }

    public void setPn(Float pn) {
        this.pn = pn;
    }

    public Float getPy() {
        return py;
    }

    public void setPy(Float py) {
        this.py = py;
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
        if (!(object instanceof PatientSymptomByExamModel)) {
            return false;
        }
        PatientSymptomByExamModel other = (PatientSymptomByExamModel) object;
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
