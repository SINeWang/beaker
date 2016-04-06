package com.theoooo.beaker.specs.model;

/**
 * Created by WangYanJiong on 4/3/16.
 */
public abstract class AbstractException extends Exception {

    private int code;

    protected AbstractException(int code) {
        this.code = code;
    }

    protected AbstractException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
