package org.wso2.carbon.apimgt.rest.api.admin.v1.impl;
import org.wso2.carbon.apimgt.api.APIAdmin;
import org.wso2.carbon.apimgt.rest.api.common.RestApiCommonUtil;
import org.wso2.carbon.apimgt.rest.api.util.utils.RestApiUtil;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.impl.utils.APIUtil;
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
    @Override
    public Response postmanKeyGet(MessageContext messageContext) {
                APIAdmin apiAdmin = new APIAdminImpl();
                String tenantDomain = RestApiCommonUtil.getLoggedInUserTenantDomain();
                int tenantID = APIUtil.getTenantIdFromTenantDomain(tenantDomain);

            return null;
        }
}
