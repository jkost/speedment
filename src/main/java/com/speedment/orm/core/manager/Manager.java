/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.speedment.orm.core.manager;

import com.speedment.orm.annotations.Api;
import com.speedment.orm.config.model.Column;
import com.speedment.orm.config.model.Table;
import com.speedment.orm.core.Buildable;
import java.util.stream.Stream;

/**
 *
 * @author pemi
 */
@Api(version = 0)
public interface Manager<PK, ENTITY, BUILDER extends Buildable<ENTITY>> {
    
    // Inspection
    PK primaryKeyFor(ENTITY entity);
    
    Object get(ENTITY entity, Column column);

    // Metadata
    Table getTable();
    
    String getTableName(); // TODO Remove.
    
    <M extends Manager<PK, ENTITY, BUILDER>> Class<M> getManagerClass();
    
    Class<ENTITY> getEntityClass();
    
    Class<BUILDER> getBuilderClass();

    <B extends BUILDER> B builder();
    
    <B extends BUILDER> B toBuilder(ENTITY model);

    // Retrieval
    Stream<ENTITY> stream();

    default long size() {
        return stream().count();
    }
    
    // Add and remove
    void insert(ENTITY entity);
    
    void update(ENTITY entity);
    
    void delete(ENTITY primaryKey);

    // Persistence
//    void load();

    ENTITY persist(ENTITY entity);
    
    ENTITY remove(ENTITY entity);
}