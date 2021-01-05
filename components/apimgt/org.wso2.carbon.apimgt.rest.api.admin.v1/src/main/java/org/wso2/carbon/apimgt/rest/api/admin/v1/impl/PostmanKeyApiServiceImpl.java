package org.wso2.carbon.apimgt.rest.api.admin.v1.impl;
import org.wso2.carbon.apimgt.api.APIAdmin;
import org.wso2.carbon.apimgt.rest.api.admin.v1.utils.mappings.PostmanAPIKeyMappingUtil;
import org.wso2.carbon.apimgt.rest.api.common.RestApiCommonUtil;
import org.wso2.carbon.apimgt.rest.api.util.utils.RestApiUtil;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.impl.utils.APIUtil;
import org.wso2.carbon.apimgt.api.model.PostmanAPIKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.impl.APIAdminImpl;
import org.wso2.carbon.apimgt.rest.api.admin.v1.*;
import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.*;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.MessageContext;

import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.PostmanKeyListDTO;

import java.util.List;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public class PostmanKeyApiServiceImpl implements PostmanKeyApiService {
    private static final Log log = LogFactory.getLog(ApiCategoriesApiServiceImpl.class);

    @Override
    public Response postmanKeyGet(MessageContext messageContext) {
        try {
                APIAdmin apiAdmin = new APIAdminImpl();
                String tenantDomain = RestApiCommonUtil.getLoggedInUserTenantDomain();
                int tenantID = APIUtil.getTenantIdFromTenantDomain(tenantDomain);
            List<PostmanAPIKey> KeysList = apiAdmin.getAPIKeysOftenant(tenantID);
            PostmanKeyListDTO keyListDTO= PostmanAPIKeyMappingUtil.fromPostmanAPTKeyListToPostmanAPIKeyListDTO(KeysList);
            return Response.ok().entity(keyListDTO).build();

        } catch (APIManagementException e) {
            String errorMessage = "Error while retrieving API categories";
            RestApiUtil.handleInternalServerError(errorMessage, e, log);
        }

        return null;
        }
}
