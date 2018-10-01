package edu.counterview;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CounterView extends LinearLayout implements View.OnClickListener {


    public static final String TAG = CounterView.class.getSimpleName();
    private TextView itemCounterValue;
    private Button incButton;
    private Button decButton;
    private LinearLayout rootView;
    private CounterListener listener;


    public CounterView(Context context) {
        super(context);
        init(context, null, 0);

    }

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);

    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        inflate(context, R.layout.item_counter, this);
        this.rootView = (LinearLayout) findViewById(R.id.root_view);
        this.itemCounterValue = (TextView) findViewById(R.id.item_counter_value);
        this.incButton = (Button) findViewById(R.id.inc_button);
        this.decButton = (Button) findViewById(R.id.dec_button);
        this.incButton.setOnClickListener(this);
        this.decButton.setOnClickListener(this);

    }


    public CounterView setStartCounterValue(String startValue) {
        if (this.itemCounterValue != null)
            this.itemCounterValue.setText(startValue);
        return this;
    }

    public CounterView setStartCounterValue(@StringRes int startValue) {
        if (this.itemCounterValue != null)
            this.itemCounterValue.setText(getString(startValue));
        return this;
    }

    public CounterView setCounterListener(CounterListener counterListener) {
        listener = counterListener;
        return this;
    }

    public String getCounterValue() {
        String text = "";
        if (this.itemCounterValue != null)
            text = this.itemCounterValue.getText().toString();
        return text;
    }

    private String getString(@StringRes int textResourceValue) {
        return getContext().getString(textResourceValue);
    }

    public CounterView setColor(@ColorRes int left, @ColorRes int right, @ColorRes int text) {

        this.incButton.setBackgroundColor(getColor(right));
        this.decButton.setBackgroundColor(getColor(left));
        this.itemCounterValue.setTextColor(getColor(text));
        return this;
    }

    private int getColor(@ColorRes int colorRes) {
        return getContext().getResources().getColor(colorRes);
    }

    @Override
    public void onClick(View view) {
        int value = 0;
        value = Integer.parseInt(this.itemCounterValue.getText().toString());
        int i = view.getId();
        if (i == R.id.inc_button) {
            value++;
            this.itemCounterValue.setText(String.valueOf(value));
            if (this.listener != null)
                this.listener.onIncClick(this.itemCounterValue.getText().toString());
        } else if (i == R.id.dec_button) {
            value--;
            if (value < 1) {
                value = 1;
            }
            this.itemCounterValue.setText(String.valueOf(value));
            if (this.listener != null)
                this.listener.onDecClick(this.itemCounterValue.getText().toString());
        }
    }


}
