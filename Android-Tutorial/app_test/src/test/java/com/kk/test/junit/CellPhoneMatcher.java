package com.kk.test.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CellPhoneMatcher extends BaseMatcher<String> {
    @Override
    public boolean matches(Object item) {
        if (item == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18\\d)\\d{8}");
        Matcher matcher = pattern.matcher((String) item);
        return matcher.matches();
    }

    /**
     * 断言成功
     * @param description
     */
    @Override
    public void describeTo(Description description) {
        description.appendText("是手机号码！");
    }

    /**
     * 断言失败
     * @param item
     * @param description
     */
    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText(item.toString() + " 不是手机号码！");
    }
}
