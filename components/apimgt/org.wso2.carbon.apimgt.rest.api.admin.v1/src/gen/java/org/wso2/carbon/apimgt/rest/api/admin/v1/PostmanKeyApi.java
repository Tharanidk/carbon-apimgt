package org.wso2.carbon.apimgt.rest.api.admin.v1;

import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.ErrorDTO;
import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.PostmanAPIKeyDTO;
import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.PostmanKeyListDTO;
import org.wso2.carbon.apimgt.rest.api.admin.v1.PostmanKeyApiService;
import org.wso2.carbon.apimgt.rest.api.admin.v1.impl.PostmanKeyApiServiceImpl;
import org.wso2.carbon.apimgt.api.APIManagementException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
@Path("/postmanKey")

@Api(description = "the postmanKey API")




public class PostmanKeyApi  {

  @Context MessageContext securityContext;

PostmanKeyApiService delegate = new PostmanKeyApiServiceImpl();


    @GET
    
    
    @Produces({ "application/json" })
    @ApiOperation(value = "Get all Postman Keys", notes = "Get all Postman API Keys ", response = PostmanKeyListDTO.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:admin_operations", description = "Manage API categories and Key Managers related operations")
        })
    }, tags={ "Postman Key",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK. Postman-Keys returned ", response = PostmanKeyListDTO.class),
        @ApiResponse(code = 404, message = "Not Found. The specified resource does not exist.", response = ErrorDTO.class) })
    public Response postmanKeyGet() throws APIManagementException{
        return delegate.postmanKeyGet(securityContext);
    }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @ApiOperation(value = "Add a Postman API Key", notes = "Add a new postman key under the tenant ", response = PostmanAPIKeyDTO.class, authorizations = {
        @Authorization(value = "OAuth2Security", scopes = {
            @AuthorizationScope(scope = "apim:admin", description = "Manage all admin operations"),
            @AuthorizationScope(scope = "apim:admin_operations", description = "Manage API categories and Key Managers related operations")
        })
    }, tags={ "Postman Key" })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created. Successful response with the newly created object as entity in the body. ", response = PostmanAPIKeyDTO.class),
        @ApiResponse(code = 400, message = "Bad Request. Invalid request or validation error.", response = ErrorDTO.class) })
    public Response postmanKeyPost(@ApiParam(value = "API Key value that should be added " ,required=true) PostmanAPIKeyDTO postmanAPIKeyDTO) throws APIManagementException{
        return delegate.postmanKeyPost(postmanAPIKeyDTO, securityContext);
    }
}
