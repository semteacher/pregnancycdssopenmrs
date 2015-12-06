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
public class SymptomModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    //private static final Log log = LogFactory.getLog(SymptCategoryModel.class);
    protected final Log log = LogFactory.getLog(this.getClass());
    
    private Integer symptId;
    private String symptName;
    private String symptNotes;
    private Integer idOrder;
    private Boolean isMulti;
    private Boolean isSelected;
    private SymptCategoryModel symptCategory;

    public Integer getSymptId() {
        return symptId;
    }

    public void setSymptId(Integer symptId) {
        this.symptId = symptId;
    }

    @Override
    public Integer getId() {
        return getSymptId();
    }

    @Override
    public void setId(Integer id) {
        setSymptId(id);
    }

    public String getSymptName() {
        return symptName;
    }

    public void setSymptName(String symptName) {
        this.symptName = symptName;
    }

    public void setSymptNotes(String symptNotes) {
        this.symptNotes = symptNotes;
    }

    public String getSymptNotes() {
        return symptNotes;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Boolean getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(Boolean isMulti) {
        this.isMulti = isMulti;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public SymptCategoryModel getSymptCategory() {
        return symptCategory;
    }

    public void setSymptCategory(SymptCategoryModel symptCategory) {
        this.symptCategory = symptCategory;
    }
}
