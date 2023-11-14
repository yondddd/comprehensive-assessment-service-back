package com.lm.assessment.common.constant;

import java.util.regex.Pattern;

/**
 * @author yond
 * @date 2023/10/22
 * @description 正则表达式
 */
public class RegexConstant {


    public final static Pattern MOBILE_PATTERN = Pattern.compile("((^1[0-9]{10}$)|(^0[0-9A-Za-z]{10}$))");

    public final static Pattern EMAIL_PATTERN = Pattern.compile("^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$");

    public final static Pattern PASSWORD_MATCHER = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{10,20}$");

    public final static Pattern NAME_PATTERN = Pattern.compile("^.{1,63}$");


}
