package com.kk.test.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                //相当于 @Before
                System.out.println(description.getMethodName() + " test start...");

                //运行测试方法
                base.evaluate();

                //相当于 @After
                System.out.println(description.getMethodName() + " test end");
            }
        };
    }
}
