/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.common.usermodel;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.Internal;

/**
 * @since POI 3.15 beta 3
 */
public enum HyperlinkType {
    /** Not a hyperlink */
    @Internal
    NONE(-1),
    
    /**
     * Link to an existing file or web page
     */
    URL(1),

    /**
     * Link to a place in this document
     */
    DOCUMENT(2),

    /**
     * Link to an E-mail address
     */
    EMAIL(3),

    /**
     * Link to a file
     */
    FILE(4);
    
    private final int code;
    private HyperlinkType(int code) {
        this.code = code;
    }
    
    private static final Map<Integer, HyperlinkType> map = new HashMap<Integer, HyperlinkType>();
    static {
        for (HyperlinkType type : values()) {
            map.put(type.getCode(), type);
        }
    }
    
    public int getCode() {
        return code;
    }
    
    public static HyperlinkType forInt(int code) {
        HyperlinkType type = map.get(code);
        if (type == null) {
            throw new IllegalArgumentException("Invalid type: " + code);
        }
        return type;
    }
}
