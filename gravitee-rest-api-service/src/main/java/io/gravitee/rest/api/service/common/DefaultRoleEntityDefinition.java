/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.rest.api.service.common;

import io.gravitee.rest.api.model.NewRoleEntity;
import io.gravitee.rest.api.model.permissions.ApiPermission;
import io.gravitee.rest.api.model.permissions.ApplicationPermission;
import io.gravitee.rest.api.model.permissions.ManagementPermission;
import io.gravitee.rest.api.model.permissions.PortalPermission;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.gravitee.rest.api.model.permissions.RolePermissionAction.*;
import static io.gravitee.rest.api.model.permissions.RoleScope.*;

public interface DefaultRoleEntityDefinition {

    public static final NewRoleEntity ROLE_MANAGEMENT_API_PUBLISHER = new NewRoleEntity(
            "API_PUBLISHER",
            "Management Role. Created by Gravitee.io.",
            MANAGEMENT,
            false,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ManagementPermission.API.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.APPLICATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.TAG.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.GROUP.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.TENANT.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.ROLE.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.PLATFORM.getName(), new char[]{READ.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity DEFAULT_ROLE_MANAGEMENT_USER = new NewRoleEntity(
            "USER",
            "Default Management Role. Created by Gravitee.io.",
            MANAGEMENT,
            true,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ManagementPermission.API.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.APPLICATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.ROLE.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ManagementPermission.GROUP.getName(), new char[]{READ.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity DEFAULT_ROLE_PORTAL_USER = new NewRoleEntity(
            "USER",
            "Default Portal Role. Created by Gravitee.io.",
            PORTAL,
            true,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(PortalPermission.APPLICATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(PortalPermission.DOCUMENTATION.getName(), new char[]{READ.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity DEFAULT_ROLE_API_USER = new NewRoleEntity(
            "USER",
            "Default API Role. Created by Gravitee.io.",
            API,
            true,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ApiPermission.DEFINITION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.PLAN.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.SUBSCRIPTION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.MEMBER.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.METADATA.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.EVENT.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.DOCUMENTATION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.RATING.getName(), new char[]{CREATE.getId(), READ.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity ROLE_API_OWNER = new NewRoleEntity(
            "OWNER",
            "API Role. Created by Gravitee.io.",
            API,
            false,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ApiPermission.DEFINITION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.GATEWAY_DEFINITION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.PLAN.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.SUBSCRIPTION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.MEMBER.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.METADATA.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.ANALYTICS.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.EVENT.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.HEALTH.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.LOG.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.DOCUMENTATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.AUDIT.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.RATING.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.RATING_ANSWER.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.DISCOVERY.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.NOTIFICATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.ALERT.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );

    public static final NewRoleEntity ROLE_API_REVIEWER = new NewRoleEntity(
            "REVIEWER",
            "API Role. Created by Gravitee.io.",
            API,
            false,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ApiPermission.DEFINITION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.GATEWAY_DEFINITION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.PLAN.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.METADATA.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.DOCUMENTATION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.DISCOVERY.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.NOTIFICATION.getName(), new char[]{READ.getId(), UPDATE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.ALERT.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApiPermission.REVIEWS.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity DEFAULT_ROLE_APPLICATION_USER = new NewRoleEntity(
            "USER",
            "Default Application Role. Created by Gravitee.io.",
            APPLICATION,
            true,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.DEFINITION.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.MEMBER.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.ANALYTICS.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.LOG.getName(), new char[]{READ.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.SUBSCRIPTION.getName(), new char[]{CREATE.getId(), READ.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
    
    public static final NewRoleEntity ROLE_APPLICATION_OWNER = new NewRoleEntity(
            "OWNER",
            "Application Role. Created by Gravitee.io.",
            APPLICATION,
            false,
            Stream.of(
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.DEFINITION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.MEMBER.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.ANALYTICS.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.LOG.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.SUBSCRIPTION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.NOTIFICATION.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()}),
                    new AbstractMap.SimpleEntry<>(ApplicationPermission.ALERT.getName(), new char[]{CREATE.getId(), READ.getId(), UPDATE.getId(), DELETE.getId()})
                  ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            );
}
