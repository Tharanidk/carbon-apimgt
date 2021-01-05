/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.wso2.carbon.apimgt.api.model;
/**
 * This class represents Postman API Keys
 */
public class PostmanAPIKey {
    private String id;
    private String keyName;
    private String keyValue;
    private int tenantID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * Name,TenantID combination is unique and cannot be duplicated. Hence two API category objects t1 and t2 are
     * considered equal if both have the same name and same tenant id
     *
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        return this.tenantID == ((PostmanAPIKey)obj).getTenantID() && this.getKeyValue().equals(((PostmanAPIKey) obj).getKeyValue());
    }
}
