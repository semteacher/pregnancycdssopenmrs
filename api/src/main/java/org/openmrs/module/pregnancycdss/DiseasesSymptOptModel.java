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
/**
 *
 * @author SemenetsA
 */
package org.openmrs.module.pregnancycdss;

import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or
 * {@link BaseOpenmrsMetadata}.
 */
public class DiseasesSymptOptModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    //private static final Log log = LogFactory.getLog(SymptCategoryModel.class);
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private Integer diseasesSymptOptId;
    private DiseasesModel disiase;
    private SymptomOptionModel symptOpt;
    private Float py;
    private Float pn;
    
    public Integer getDiseasesSymptOptId() {
        return diseasesSymptOptId;
    }

    public void setDiseasesSymptOptId(Integer diseasesSymptOptId) {
        this.diseasesSymptOptId = diseasesSymptOptId;
    }

    public SymptomOptionModel getSymptOpt() {
        return symptOpt;
    }

    public void setSymptOpt(SymptomOptionModel symptOpt) {
        this.symptOpt = symptOpt;
    }
    
    public DiseasesModel getDisiase() {
        return disiase;
    }

    public void setDisiase(DiseasesModel disiase) {
        this.disiase = disiase;
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

    @Override
    public Integer getId() {
        return getDiseasesSymptOptId();
    }

    @Override
    public void setId(Integer id) {
        setDiseasesSymptOptId(id);
    }

}
