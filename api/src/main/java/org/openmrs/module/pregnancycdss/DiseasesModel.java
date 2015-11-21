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
public class DiseasesModel extends BaseOpenmrsObject implements Serializable {

    private static final long serialVersionUID = 1L;
    protected final Log log = LogFactory.getLog(this.getClass());
    private Integer diseasesId;
    private String diseasesName;
    private String diseasesNotes;
    private String diseasesICD10;
    private Float pValue;

    public Integer getDiseasesId() {
        return diseasesId;
    }

    public void setDiseasesId(Integer diseasesId) {
        this.diseasesId = diseasesId;
    }

    public String getDiseasesName() {
        return diseasesName;
    }

    public void setDiseasesName(String diseasesName) {
        this.diseasesName = diseasesName;
    }

    public String getDiseasesNotes() {
        return diseasesNotes;
    }

    public void setDiseasesNotes(String diseasesNotes) {
        this.diseasesNotes = diseasesNotes;
    }

    public String getDiseasesICD10() {
        return diseasesICD10;
    }

    public void setDiseasesICD10(String diseasesICD10) {
        this.diseasesICD10 = diseasesICD10;
    }

    public Float getpValue() {
        return pValue;
    }

    public void setpValue(Float pValue) {
        this.pValue = pValue;
    }

    @Override
    public Integer getId() {
        return getDiseasesId();
    }

    @Override
    public void setId(Integer id) {
        setDiseasesId(id);
    }
}
