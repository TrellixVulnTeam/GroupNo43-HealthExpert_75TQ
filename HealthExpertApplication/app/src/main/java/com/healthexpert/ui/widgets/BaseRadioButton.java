package com.healthexpert.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.healthexpert.R;


/**
 * Created by Shivani on 10/06/2016.
 */

public class BaseRadioButton extends AppCompatRadioButton {

    public BaseRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public BaseRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.BaseFont);

        String fontName = attributeArray.getString(R.styleable.BaseFont_font_name);

        Typeface customFont = selectTypeface(context, fontName);
        setTypeface(customFont);

        attributeArray.recycle();
    }

    private Typeface selectTypeface(Context context, String fontName) {
        if (fontName != null) {
            if (fontName.contentEquals(context.getString(R.string.font_name_montserrat))) {
                return FontCache.getTypeface("fonts/MONTSERRAT-REGULAR.TTF", context);
            } else if (fontName.contentEquals(context.getString(R.string.font_name_montserrat_bold))) {
                return FontCache.getTypeface("fonts/MONTSERRAT-BOLD.TTF", context);
            } else
                return FontCache.getTypeface("fonts/MONTSERRAT-REGULAR.TTF", context);
        } else {
            // no matching font found
            // return null so Android just uses the standard font (Roboto)
            return null;
        }
    }
}
