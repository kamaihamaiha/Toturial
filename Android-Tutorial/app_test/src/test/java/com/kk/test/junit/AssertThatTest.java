package com.kk.test.junit;

import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * assertThat(T actual, Matcher<? super T> matcher);
 * assertThat(String reason,T actual, Matcher<? super T> matcher);
 * <p>
 * reason: 断言的输出信息
 * actual: 断言的值
 * matcher: 断言的匹配器
 * <p>
 * 常用的匹配器：
 * is, not, equalTo, equalToIgnoringCase, containsString, startsWith, endsWith, nullValue, notNullValue,
 * greaterThan, lessThan, greaterThanOrEqualTo, lessThanOrEqualTo, closeTo, allOf, anyOf, hasKey, hasValue, hasItem
 * <p>
 * 可以自定义匹配器
 */
public class AssertThatTest {

    @Rule
    public MyRule rule = new MyRule();

    @Test
    public void test1() {
        Assert.assertThat(1, Is.is(1));
    }

    @Test
    public void test2() {
        Assert.assertThat(1, IsNot.not(2));
    }

    @Test
    public void test3() {
        Assert.assertThat(1, IsEqual.equalTo(1));
    }

    @Test
    public void test4() {
        Assert.assertThat(null, nullValue());

    }

    @Test
    public void testCellPhoneNumber() {
        Assert.assertThat("13386432205", new CellPhoneMatcher());
    }
}
