/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.identity.user.ekyc.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.configuration.mgt.core.ConfigurationManager;
import org.wso2.carbon.identity.user.ekyc.exception.IDVException;
import org.wso2.carbon.identity.user.ekyc.idv.IDVService;
import org.wso2.carbon.identity.user.ekyc.idv.IDVServiceImpl;
import org.wso2.carbon.user.core.service.RealmService;

/**
 * Holder for osgi and local services
 */
public class EKYCServiceDataHolder {
    private RealmService realmService;
    private ConfigurationManager configurationManager;
    private IDVService idvService;

    private static final Log log = LogFactory.getLog(EKYCServiceDataHolder.class);

    private static EKYCServiceDataHolder instance = new EKYCServiceDataHolder();

    private EKYCServiceDataHolder() {
    }

    public static EKYCServiceDataHolder getInstance() {
        return instance;
    }

    public RealmService getRealmService() {
        if (realmService == null) {
            throw new RuntimeException("Realm Service cannot be null. Component has not initialized properly.");
        }
        return realmService;
    }

    public void setRealmService(RealmService realmService) {
        this.realmService = realmService;
    }

    public ConfigurationManager getConfigurationManager() {
        if (configurationManager == null) {
            throw new RuntimeException("Configuration Manager cannot be null. Component has not initialized properly.");
        }
        return configurationManager;
    }

    public void setConfigurationManager(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public IDVService getIdvService() throws IDVException {
        if (idvService == null) {
            idvService = new IDVServiceImpl();
        }
        return idvService;
    }

    public void setIdvService(IDVService idvService) {
        this.idvService = idvService;
    }
}

