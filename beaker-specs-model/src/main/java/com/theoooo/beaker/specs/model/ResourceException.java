package com.theoooo.beaker.specs.model;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public abstract class ResourceException extends AbstractException {

    protected ResourceException(int code) {
        super(code);
    }

    protected ResourceException(int code, String message) {
        super(code, message);
    }

}
