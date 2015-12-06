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
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or
 * {@link BaseOpenmrsMetadata}.
 */
public class SymptCategoryModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;

    //private static final Log log = LogFactory.getLog(SymptCategoryModel.class);
    protected final Log log = LogFactory.getLog(this.getClass());

    private Integer symptCatId;
    private String catName;
    private String catNotes;
    private Boolean isSelected;
    private List<SymptomModel> symptoms;

    public List<SymptomModel> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SymptomModel> symptoms) {
        this.symptoms = symptoms;
    }

    public Integer getSymptCatId() {
        return symptCatId;
    }

    public void setSymptCatId(Integer symptCatId) {
        this.symptCatId = symptCatId;
    }

    @Override
    public Integer getId() {
        return getSymptCatId();
    }

    @Override
    public void setId(Integer id) {
        setSymptCatId(id);
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setCatNotes(String catNotes) {
        this.catNotes = catNotes;
    }

    public String getCatNotes() {
        return catNotes;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
}
