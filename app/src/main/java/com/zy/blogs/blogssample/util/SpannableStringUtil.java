package com.zy.blogs.blogssample.util;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

/**
 * <p>
 * 作者：zhouyuan on  2016/6/21 16:13
 * <p>
 * 邮箱：244370114@qq.com
 * <p>
 * 地址 http://www.jianshu.com/p/84067ad289d2
 */
public class SpannableStringUtil {

    private SpannableString spannableString;

    /**
     * 为文本设置前景色，效果和TextView的setTextColor()类似
     *
     * @param textView
     * @param content  文本内容
     * @param color    字体颜色
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString foregroundColorSpan(TextView textView, String content, int color, int start) {
        spannableString = new SpannableString(content);
//        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        spannableString.setSpan(colorSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 为文本设置背景色，效果和TextView的setBackground()类
     *
     * @param textView
     * @param content  文本内容
     * @param color    字体颜色
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString backgroundColorSpan(TextView textView, String content, int color, int start) {
        spannableString = new SpannableString(content);
        BackgroundColorSpan colorSpan = new BackgroundColorSpan(color);
        spannableString.setSpan(colorSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 为文本设置中划线，也就是常说的删除线
     *
     * @param textView
     * @param content  文本内容
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString strikethroughSpan(TextView textView, String content, int start) {
        spannableString = new SpannableString(content);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 为文本设置下划线，也就是常说的下划线
     *
     * @param textView
     * @param content  文本内容
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString underlineSpan(TextView textView, String content, int start) {
        spannableString = new SpannableString(content);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 设置上标 比如  m ²  有一种数学公式的样式
     *
     * @param textView
     * @param content  文本内容
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString superscriptSpan(TextView textView, String content, int start) {
        spannableString = new SpannableString(content);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString.setSpan(superscriptSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 设置下标与上标相反
     *
     * @param textView
     * @param content  文本内容
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString subscriptSpan(TextView textView, String content, int start) {
        spannableString = new SpannableString(content);
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        spannableString.setSpan(subscriptSpan, start, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        return spannableString;
    }

    /**
     * 为文字设置风格（粗体、斜体），和TextView属性textStyle类似，
     *
     * @param textView
     * @param content  文本内容
     * @param start    从文本哪个位置开始
     * @return 需要的样式内容
     */
    public SpannableString styleSpan(TextView textView, String content, int start) {
        spannableString = new SpannableString(content);
        spannableString = new SpannableString("为文字设置粗体、斜体风格");
        StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_I = new StyleSpan(Typeface.ITALIC);
        spannableString.setSpan(styleSpan_B, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setHighlightColor(Color.parseColor("#36969696"));
        textView.setText(spannableString);
        return spannableString;
    }

}
