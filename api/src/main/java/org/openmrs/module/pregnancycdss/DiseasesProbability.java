/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.pregnancycdss;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.BaseOpenmrsObject;

/**
 *
 * @author SemenetsA
 */
public class DiseasesProbability extends BaseOpenmrsObject implements Serializable{
        
    private Integer diseaseId;
    private String disiaseName;
    private Float py;
    private Float pn;
    private Integer selCount;
    
    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDisiaseName() {
        return disiaseName;
    }

    public void setDisiaseName(String disiaseName) {
        this.disiaseName = disiaseName;
    }

    public Float getPy() {
        return py;
    }

    public void setPy(Float py) {
        this.py = py;
    }

    public Float getPn() {
        return pn;
    }

    public void setPn(Float pn) {
        this.pn = pn;
    }
    
    public Integer getSelcount() {
        return selCount;
    }

    public void setSelcount(Integer selCount) {
        this.selCount = selCount;
    }
    
    public DiseasesProbability() {
    }
    
    public DiseasesProbability(Integer diseaseId, String disiaseName, Float py, Float pn, Integer selCount) {
        this.diseaseId = diseaseId;
        this.disiaseName = disiaseName;
        this.py = py;
        this.pn = pn;
        this.selCount = selCount;
    }
    
}
