package de.upb.swt.soot.test.callgraph.typehierarchy.methoddispatchtestcase;


import categories.Java8Test;
import de.upb.swt.soot.callgraph.typehierarchy.MethodDispatchResolver;
import de.upb.swt.soot.callgraph.typehierarchy.TypeHierarchy;
import de.upb.swt.soot.callgraph.typehierarchy.ViewTypeHierarchy;
import de.upb.swt.soot.core.model.SootClass;
import de.upb.swt.soot.core.model.SootMethod;
import de.upb.swt.soot.core.signatures.MethodSignature;
import de.upb.swt.soot.core.types.ClassType;
import de.upb.swt.soot.test.callgraph.typehierarchy.MethodDispatchBase;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

/** @author: Hasitha Rajapakse **/

@Category(Java8Test.class)
public class ConcreteDispatchTest extends MethodDispatchBase {
    @Test
    public void method() {
        ClassType sootClassTypeA = getClassType("A");
        ClassType sootClassTypeB = getClassType("B");

        MethodSignature sootMethod1 = identifierFactory.getMethodSignature("method", sootClassTypeA, "void", Collections.emptyList());
        MethodSignature sootMethod2 = identifierFactory.getMethodSignature("method2", sootClassTypeA, "void", Collections.emptyList());
        MethodSignature sootMethod3 = identifierFactory.getMethodSignature("method2", sootClassTypeB, "void", Collections.emptyList());

        MethodSignature candidate1 = MethodDispatchResolver.resolveConcreteDispatch(customTestWatcher.getView(), sootMethod1);
        assertEquals(candidate1, sootMethod1);

        MethodSignature candidate2 = MethodDispatchResolver.resolveConcreteDispatch(customTestWatcher.getView(), sootMethod2);
        assertEquals(candidate2, sootMethod3);

    }
}
