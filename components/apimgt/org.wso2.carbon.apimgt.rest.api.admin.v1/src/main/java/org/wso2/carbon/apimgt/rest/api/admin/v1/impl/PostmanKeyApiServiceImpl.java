package org.wso2.carbon.apimgt.rest.api.admin.v1.impl;
import org.wso2.carbon.apimgt.api.APIAdmin;
import org.wso2.carbon.apimgt.rest.api.admin.v1.utils.mappings.PostmanAPIKeyMappingUtil;
import org.wso2.carbon.apimgt.rest.api.common.RestApiCommonUtil;
import org.wso2.carbon.apimgt.rest.api.common.RestApiConstants;
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
import org.wso2.carbon.core.util.CryptoException;

import java.net.URI;
import java.net.URISyntaxException;
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
            PostmanKeyListDTO keyListDTO= PostmanAPIKeyMappingUtil.fromPostmanAPIKeyListToPostmanAPIKeyListDTO(KeysList);
            return Response.ok().entity(keyListDTO).build();

        } catch (APIManagementException e) {
            String errorMessage = "Error while retrieving API categories";
            RestApiUtil.handleInternalServerError(errorMessage, e, log);
        }

        return null;
        }

    @Override
    public Response postmanKeyPost(PostmanAPIKeyDTO postmanAPIKeyDTO, MessageContext messageContext) throws APIManagementException {
            PostmanAPIKey postmanKey = null;
            try {
                APIAdmin apiAdmin = new APIAdminImpl();
                String userName = RestApiCommonUtil.getLoggedInUsername();
                postmanKey = PostmanAPIKeyMappingUtil.fromPostmanAPIKeyDTOToPostmanAPIKey(postmanAPIKeyDTO);

                PostmanAPIKeyDTO PostmanKeyDTO = PostmanAPIKeyMappingUtil.
                        fromPostmanAPIKeyToPostmanAPIKeyDTO(apiAdmin.addPostmanAPIKey(postmanKey, userName));
                URI location = new URI(RestApiConstants.RESOURCE_PATH_POSTMAN_API_KEY  + "/" + PostmanKeyDTO.getId());
                return Response.created(location).entity(PostmanKeyDTO).build();

            } catch (APIManagementException | URISyntaxException | CryptoException e) {
                String errorMessage = "Error while adding new API Category '" + postmanAPIKeyDTO.getKeyName() + "' - " + e.getMessage();
                RestApiUtil.handleInternalServerError(errorMessage, e, log);
            }
            return null;
        }


}
