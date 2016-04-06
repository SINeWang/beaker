package com.theoooo.beaker.specs.model;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public abstract class CapabilityException extends AbstractException {

    protected CapabilityException(int base, int code) {
        super(base + code);
    }

    protected CapabilityException(int base, int code, String message) {
        super(base + code, message);
    }

    protected CapabilityException(int base, int code, ResourceException re) {
        super(base + code, "[" + re.getCode() + "]" + re.getMessage());
    }

}
