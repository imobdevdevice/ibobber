package com.reelsonar.ibobber.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.reelsonar.ibobber.R;
import com.reelsonar.ibobber.databinding.TitleViewBinding;

/**
 * Created by Rujul Gandhi.
 */

public class TitleView extends LinearLayout {

    private String subHeaderTitle;
    public TitleViewBinding binding;

    public TitleView(Context context) {
        super(context);
        init(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, R.layout.title_view, this, true);
        binding.tvAppName.setText(getResources().getString(R.string.app_name));
        if (attributeSet != null) {
            TypedArray a = getContext().obtainStyledAttributes(attributeSet, R.styleable.TitleView);
            subHeaderTitle = a.getString(R.styleable.TitleView_SubTitleText);
            a.recycle();
            binding.tvTitle.setText(subHeaderTitle);

            TypedArray attrs = getContext().obtainStyledAttributes(attributeSet, R.styleable.Netfish);
            if (attrs.getBoolean(R.styleable.Netfish_isNetFish, false)) {
                binding.titleViewImage.setImageResource(R.drawable.netfish_banner);
            }
        }
    }

    public void setText(String text) {
        binding.tvTitle.setText(text);
    }
}