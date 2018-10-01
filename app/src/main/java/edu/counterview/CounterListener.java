package edu.counterview;

/**
 * Created by Ankit on 06/12/17.
 */



public interface CounterListener {
    void onIncClick(String value);

    void onDecClick(String value);
}