package com.resource.util;


import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/16
 *
 * 字符串类型/正则表达式
 */

public class RegexUtil {


    /**
     * 验证字母
     * @param str 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isLetters(String str){
        Pattern compile = Pattern.compile("[a-zA-Z]");
        Matcher matcher = compile.matcher(str);
        return matcher.matches();
    }


    //判断输入框是否为空
    public static boolean isEditNull(EditText editText) {
            return TextUtils.isEmpty(editText.getText().toString().trim());
    }

    //判断文本是否为空
    public static boolean isTextNull(TextView textView){
        return TextUtils.isEmpty(textView.getText().toString().trim());
    }


    //判断单选是否选择任意一个
    public static boolean isRaidoButtonNull(RadioButton radioButton1, RadioButton radioButton2) {
            return !radioButton1.isChecked() && !radioButton2.isChecked();
    }


    //EditText转换字符串
    public static String getEditStr(EditText editText) {
        String str = editText.getText().toString().trim();
        return str;
    }

    //特殊字符提交时需要转换为utf-8
    public static String strToUtf8(String str){
        String utfStr = "";
        try {
            String path = new String(str.getBytes(), "utf-8");
            utfStr = URLEncoder.encode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return utfStr;
    }

    //data格式转换
    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return format.format(date);
    }

    //EditText转int
    public static int getEditInt(EditText editText){
            return TextUtils.isEmpty(editText.getText().toString().trim())?0:Integer.parseInt(editText.getText().toString().trim());
    }

    /**
     * 验证手机号码正则表达式
     * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
     * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
     * 电信号段: 133,149,153,170,173,177,180,181,189
     * @param phoneNumber
     * @return 待检测的字符串
     */
    public static boolean isPhoneNumber(String phoneNumber) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(16[^6])|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8,9]))\\d{8}$";// "[1]"代表下一位为数字可以是几，"[0-9]"代表可以为0-9中的一个，"[5,7,9]"表示可以是5,7,9中的任意一位,[^4]表示除4以外的任何一个,\\d{9}"代表后面是可以是0～9的数字，有8位。
        return Pattern.matches(regex,phoneNumber);
    }

    /**
     * 验证是否为ip地址
     */
    public static boolean isIp(String ip){
        String regex = "[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}:[0-9]{1,4}+[0-9,A-Z,a-z,/,?]{1,30}";
        return Pattern.matches(regex,ip);
    }

    /**
     * 验证是否为小数
     */
    public static boolean  isNumberDouble (String balance){
       String regex  = "((^[1-9]+[0-9]*[.]?)|(^[0]+[.]))[0-9]*$";
       return Pattern.matches(regex,balance);
    }

    //判断字符串是否为数字
    public static boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 是否为邮政编码
     * 首数字不能为0,并且为6位数
     * @param postCode
     * @return
     */
    public static boolean isPostCode(String postCode){
        String regex = "^[1-9]\\d{5}$";
        return Pattern.matches(regex,postCode);
    }

    /**
     * 验证银卡卡号
     *
     * @param cardNo
     * @return
     */
    public static final boolean isBankCard(String cardNo) {
        Pattern p = Pattern
                .compile("^\\d{16,19}$|^\\d{6}[- ]\\d{10,13}$|^\\d{4}[- ]\\d{4}[- ]\\d{4}[- ]\\d{4,7}$");
        Matcher m = p.matcher(cardNo);

        return m.matches();
    }

    /**
     * 时间戳转日期
     * @param time
     * @return
     */
    public static String timestampToDate(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(time));
        return times;
    }

    /**
     * 时间戳转日期时分秒
     * @param time
     * @return
     */
    public static String timestampToDateHourMinutesSecond(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(time));
        return times;
    }

    //日期转时间戳
    public static Long dataToTimestamp(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Long.valueOf(times);
    }


    /**
     * 获取当前日期
     *
     * @return
     */
    public static final String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    /**
     * String转为double,保留两位小数
     * @param str
     * @return
     */
    public static String stringFormatDouble(String str){
        DecimalFormat df = new DecimalFormat("0.00");
        Double d = new Double(str);
        return df.format(d);
    }

    /**
     * 验证身份证号码
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isIdNumber(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex,idCard);
    }

    /**
     * 验证中文
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }

    /**
     * 判断字段是否为邮编 符合返回ture
     * @param str
     * @return boolean
     */
    public static  boolean isCode(String str) {
        /**
         * 邮编正则表达式  [0-9]\d{5}(?!\d) 国内6位邮编
         */
        String regex = "[0-9]\\d{5}(?!\\d)";
        return Pattern.matches(regex,str);
    }

}
