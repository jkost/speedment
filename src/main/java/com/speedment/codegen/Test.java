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
package com.speedment.codegen;

import com.speedment.codegen.control.AccessorImplementer;
import com.speedment.codegen.control.AutomaticDependencies;
import com.speedment.codegen.model.Statement_;
import com.speedment.codegen.model.annotation.Annotation_;
import com.speedment.codegen.model.field.Field_;
import static com.speedment.codegen.model.Type_.STRING;
import com.speedment.codegen.model.block.Block_;
import com.speedment.codegen.model.class_.Class_;
import com.speedment.codegen.model.method.Method_;
import static com.speedment.codegen.model.modifier.ClassModifier_.*;
import com.speedment.codegen.model.modifier.MethodModifier_;
import com.speedment.codegen.model.package_.Package_;
import com.speedment.codegen.view.java.JavaCodeGen;

/**
 *
 * @author pemi
 */
public class Test {
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Package_ package_ = new Package_("test")
			.setPackage(new Package_("codegen")
			.setPackage(new Package_("speedment")
			.setPackage(new Package_("org"))));

        final Field_ field = new Field_(STRING, "foo").private_();
		
		CodeUtil.tab("   ");

        final Class_ class_ = new Class_()
			.setPackage(package_)
			.add(PUBLIC, STATIC)
			.add(field)
			.add(new Field_(STRING, "bar"))
			.add(new Method_(
				STRING, "getFooBar"
				).add(MethodModifier_.PUBLIC, MethodModifier_.FINAL)
				.add(new Statement_(
					"return (foo + bar);"
				))
			);
		class_.setName("TestClass");
			
        new AccessorImplementer().apply(class_);
		new AutomaticDependencies().apply(class_);

        class_.add(Annotation_.DEPRECATED);
        JavaCodeGen gen = new JavaCodeGen();
        System.out.println(gen.on(class_));

    }

}
