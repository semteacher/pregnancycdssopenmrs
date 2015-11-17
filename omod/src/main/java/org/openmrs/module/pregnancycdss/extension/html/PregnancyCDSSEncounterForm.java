/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.pregnancycdss.extension.html;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openmrs.module.Extension;
//import org.openmrs.module.web.extension.AdministrationSectionExt;
import org.openmrs.module.web.extension.BoxExt;

/**
 * This class defines the links that will appear Adds link between encounter metadata and obs list
 */
/**
 *
 * @author Admin
 */
public class PregnancyCDSSEncounterForm extends org.openmrs.module.web.extension.BoxExt {

    /**
     * @see AdministrationSectionExt#getTitle()
     */
    @Override
    public String getTitle() {
        return "pregnancycdss.title";
    }

    @Override
    public String getPortletUrl() {
        return "pregnancycdss.portlet";
    }

    @Override
    public String getContent() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return "<p>Content will be there!</p>";
    }
}
