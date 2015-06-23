/**
 * Copyright (c) 2012-2013 Reficio (TM) - Reestablish your software!. All Rights Reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.reficio.ws.common;

import org.reficio.ws.SoapMultiValuesProvider;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Bujok
 * @since 1.0.0
 */
public class SimpleValuesProvider implements SoapMultiValuesProvider {

    private Map<QName, Set<String>> multiValues;

    public SimpleValuesProvider() {
        multiValues = new HashMap<QName, Set<String>>();
    }

    public SimpleValuesProvider(Map<QName, Set<String>> multiValues) {
        multiValues = new HashMap<QName, Set<String>>();
        for (Map.Entry<QName, Set<String>> entry : multiValues.entrySet()) {
            multiValues.put(entry.getKey(), new HashSet<String>(entry.getValue()));
        }
    }

    @Override
    public Set<String> getMultiValues(QName name) {
        Set<String> result = multiValues.get(name);
        return result != null ? result : new HashSet<String>();
    }

    public void addMultiValues(QName name, Set<String> values) {
        multiValues.put(name, new HashSet<String>(values));
    }

}
