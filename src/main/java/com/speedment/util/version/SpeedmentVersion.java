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
package com.speedment.util.version;

import com.speedment.core.annotations.Api;
import com.speedment.util.PureStaticMethods;

/**
 * This class holds the parameters normally held in the JAR MANIFEST. By holding
 * the values here, they will survive any jar modification process such as the
 * Maven Shade Plugin.
 *
 * @author pemi
 * @since 2.0
 */
@Api(version = "2.0")
public class SpeedmentVersion implements PureStaticMethods {
    
    private static final String IMPLEMENTATION_TITLE = "Speedment";
    private static final String IMPLEMENTATION_VENDOR = "Speedment Inc."; // "Speedment, Inc." difficult to enter into POM because of ','
    private static final String IMPLEMENTATION_VERSION = "2.0.0-EA2-SNAPSHOT";

//    private static final String SPECIFICATION_TITLE = "Speedment";
//    private static final String SPECIFICATION_VENDOR = "Speedment Inc.";
    private static final String SPECIFICATION_VERSION = "2.0";

    /**
     * This class contains only static methods and thus, no instance shall be
     * created.
     *
     * @see PureStaticMethods#instanceNotAllowed()
     */
    private SpeedmentVersion() {
        instanceNotAllowed();
    }

    /**
     * Returns the non-null title of the Speedment framework.
     *
     * @return the non-null title of the Speedment framework
     */
    public static String getImplementationTitle() {
        return IMPLEMENTATION_TITLE;
    }

    /**
     * Returns the non-null name of the organization, vendor or company that
     * provided this Speedment implementation.
     *
     * @return the non-null name of the organization, vendor or company that
     * provided this Speedment implementation
     */
    public static String getImplementationVendor() {
        return IMPLEMENTATION_VENDOR;

    }

    /**
     * Return the non-null version of this Speedment implementation. It consists
     * of any string assigned by the vendor of this implementation and does not
     * have any particular syntax specified or expected by the Java runtime. It
     * may be compared for equality with other package version strings used for
     * this implementation by this vendor for this package.
     *
     * @return the non-null version of this Speedment implementation
     */
    public static String getImplementationVersion() {
        return IMPLEMENTATION_VERSION;
    }

//    public static String getSpecificationTitle() {
//        return SPECIFICATION_TITLE;
//    }
//
//    public static String getSpecificationVendor() {
//        return SPECIFICATION_VENDOR;
//    }
//
    /**
     * Returns the non-null version number of the specification that this
     * Speedment implements. This version string must be a sequence of
     * nonnegative decimal integers separated by "."'s and may have leading
     * zeros. When version strings are compared the most significant numbers are
     * compared.
     *
     * @return the non-null version number of the specification that this
     * Speedment implements
     */
    public static String getSpecificationVersion() {
        return SPECIFICATION_VERSION;
    }
}
