package com.robinhood.ticker.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.robinhood.ticker.TickerView;

import java.util.Random;

public class MainActivity extends BaseActivity {
    private final String alphabetlist = "abcdefghijklmnopqrstuvwxyz";

    private TickerView ticker1, ticker2, ticker3, ticker4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticker1 = findViewById(R.id.ticker1);
        ticker2 = findViewById(R.id.ticker2);
        ticker3 = findViewById(R.id.ticker3);
        ticker4 = findViewById(R.id.ticker4);

        ticker1.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);
        ticker2.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
        ticker3.setPreferredScrollingDirection(TickerView.ScrollingDirection.ANY);

        findViewById(R.id.perfBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PerfActivity.class));
            }
        });

        findViewById(R.id.slideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SlideActivity.class));
            }
        });
    }

    @Override
    protected void onUpdate() {
        final int digits = RANDOM.nextInt(2) + 6;

        ticker1.setText(getRandomNumber(digits));
        final String currencyFloat = Float.toString(RANDOM.nextFloat() * 100);
        ticker2.setText("$" + currencyFloat.substring(0, Math.min(digits, currencyFloat.length())));
        ticker3.setText(generateChars(RANDOM, alphabetlist, digits));
        setTicker4(ticker4, "$" + RANDOM.nextInt(10000) + ".00");
    }

    private String generateChars(Random random, String list, int numDigits) {
        final char[] result = new char[numDigits];
        for (int i = 0; i < numDigits; i++) {
            result[i] = list.charAt(random.nextInt(list.length()));
        }
        return new String(result);
    }

    private static void setTicker4(TickerView tickerView, String number) {
        String text = tickerView.getText();
        if (text == null) {
            tickerView.setText(number);
            return;
        }
        if (text.compareTo(number) < 0) {
            tickerView.setPreferredScrollingDirection(TickerView.ScrollingDirection.DOWN);
        } else {
            tickerView.setPreferredScrollingDirection(TickerView.ScrollingDirection.UP);
        }
        tickerView.setText(number);
    }
}
