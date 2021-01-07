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

package org.wso2.carbon.apimgt.rest.api.admin.v1.utils.mappings;

import org.wso2.carbon.apimgt.api.model.PostmanAPIKey;
import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.PostmanAPIKeyDTO;
import org.wso2.carbon.apimgt.rest.api.admin.v1.dto.PostmanKeyListDTO;
import org.wso2.carbon.core.util.CryptoException;

import java.util.ArrayList;
import java.util.List;

public class PostmanAPIKeyMappingUtil {

    /**
     * Convert list of Postman API Keys to PostmanKeyListDTO
     *
     * @param postmankeys List of api categories
     * @return PostmanAPIKeyListDTO list contain list of Postman API Keys
     */
    public static PostmanKeyListDTO fromPostmanAPIKeyListToPostmanAPIKeyListDTO(List<PostmanAPIKey> postmankeys) {
        PostmanKeyListDTO postmanAPIKeyListDTO = new PostmanKeyListDTO();
        postmanAPIKeyListDTO.setCount(postmankeys.size());
        postmanAPIKeyListDTO.setList(fromPostmanAPIKeyListToPostmanAPIKeyDTOList(postmankeys));
        return postmanAPIKeyListDTO;
    }

    /**
     * Converts Postman API Key List to PostmanAPIKeyDTO List.
     *
     * @param postmankeys List of Postman API Keys
     * @return PostmanAPIKeyDTO list
     */
    private static List<PostmanAPIKeyDTO> fromPostmanAPIKeyListToPostmanAPIKeyDTOList(List<PostmanAPIKey> postmankeys) {
        List<PostmanAPIKeyDTO> APIKeyDTOs = new ArrayList<>();
        for (PostmanAPIKey postmankey : postmankeys) {
            PostmanAPIKeyDTO APIKeyDTO = new PostmanAPIKeyDTO();
            APIKeyDTO.setId(postmankey.getId());
            APIKeyDTO.setKeyName(postmankey.getKeyName());
            APIKeyDTO.setKeyValue(postmankey.getKeyValue());
            APIKeyDTOs.add(APIKeyDTO);
        }
        return APIKeyDTOs;
    }

    /**
     * Converts a PostmanAPIKeyDTO to PostmanAPIKey
     *
     * @param PostmanAPIKeyDTO
     * @return PostmanAPIKey
     */
    public static PostmanAPIKey fromPostmanAPIKeyDTOToPostmanAPIKey(PostmanAPIKeyDTO PostmanAPIKeyDTO) throws CryptoException {
        PostmanAPIKey postmanKey = new PostmanAPIKey();
        postmanKey.setId(PostmanAPIKeyDTO.getId());
        postmanKey.setKeyName(PostmanAPIKeyDTO.getKeyName());
        postmanKey.setKeyValue(PostmanAPIKeyDTO.getKeyValue());
        return postmanKey;
    }

    /**
     * Converts a PostmanAPIKey to PostmanAPIKeyDTO
     *
     * @param postmanKey
     * @return postmanKeyDTO
     */
    public static PostmanAPIKeyDTO fromPostmanAPIKeyToPostmanAPIKeyDTO(PostmanAPIKey postmanKey) throws CryptoException {
        PostmanAPIKeyDTO postmanKeyDTO = new PostmanAPIKeyDTO();
        postmanKeyDTO.setId(postmanKey.getId());
        postmanKeyDTO.setKeyName(postmanKey.getKeyName());
        postmanKeyDTO.setKeyValue(postmanKey.getKeyValue());
        return postmanKeyDTO;
    }
}
