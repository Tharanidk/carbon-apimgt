/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.apimgt.impl.endpoint.registry.util;

import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.api.endpoint.registry.api.DefinitionValidationException;
import org.wso2.carbon.apimgt.impl.utils.APIMWSDLReader;

import java.io.ByteArrayInputStream;
import java.net.URL;

/**
 * This class provides the functionality of validating WSDL definitions
 */
public class WSDLDefinitionValidator implements DefinitionValidator {

    @Override
    public boolean validate(URL definitionUrl) throws DefinitionValidationException {
        boolean isValid;
        try {
            isValid = APIMWSDLReader.validateWSDLUrl(definitionUrl).isValid();
        } catch (APIManagementException e) {
            throw new DefinitionValidationException("Unable to parse the WSDL definition", e);
        }
        return isValid;
    }

    @Override
    public boolean validate(byte[] definition) throws DefinitionValidationException {
        boolean isValid;
        try {
            ByteArrayInputStream definitionFileByteStream = new ByteArrayInputStream(definition);
            isValid = APIMWSDLReader.validateWSDLFile(definitionFileByteStream).isValid();
        } catch (APIManagementException e) {
            throw new DefinitionValidationException("Unable to parse the WSDL definition", e);
        }
        return isValid;
    }

    @Override
    public boolean validate(String definition) throws DefinitionValidationException {
        return validate(definition.getBytes());
    }
}
