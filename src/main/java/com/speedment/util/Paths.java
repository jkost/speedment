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
package com.speedment.util;

import java.nio.file.Path;

/**
 *
 * @author Emil Forslund
 */
public class Paths implements PureStaticMethods {

    /**
     * This class contains only static methods and thus, no instance shall be
     * created.
     *
     * @see PureStaticMethods#instanceNotAllowed()
     */
    private Paths() {
        instanceNotAllowed();
    }

    public static String toString(Path path) {
        return path.toString().replace("\\", "/");
    }
}
