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
public class SymptomOptionModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    //private static final Log log = LogFactory.getLog(SymptCategoryModel.class);
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private Integer symptOptId;
    private String optName;
    private Integer idOrder;
    private Boolean isSelected;
    private SymptomModel symptom;

    public Integer getSymptOptId() {
        return symptOptId;
    }

    public void setSymptOptId(Integer symptOptId) {
        this.symptOptId = symptOptId;
    }

    @Override
    public Integer getId() {
        return getSymptOptId();
    }

    @Override
    public void setId(Integer id) {
        setSymptOptId(id);
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public SymptomModel getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomModel symptom) {
        this.symptom = symptom;
    }
}
