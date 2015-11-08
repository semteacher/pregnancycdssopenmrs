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
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or
 * {@link BaseOpenmrsMetadata}.
 */
public class PregnancyCDSSSymptCategoryModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cat_name;
    private String cat_notes;
    private Integer is_selected;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public void setCat_notes(String cat_notes) {
        this.cat_notes = cat_notes;
    }

    public String getCat_notes() {
        return cat_notes;
    }

    public Integer getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(Integer is_selected) {
        this.is_selected = is_selected;
    }
}
