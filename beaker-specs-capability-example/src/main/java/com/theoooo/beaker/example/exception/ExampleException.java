package com.theoooo.beaker.example.exception;

import com.theoooo.beaker.example.api.ExampleCapability;
import com.theoooo.beaker.specs.model.CapabilityException;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public class ExampleException extends CapabilityException {


    protected static final int BASE_Example = 1000000;

    public ExampleException(ExampleCapability.EC code) {
        super(BASE_Example, code.ordinal());
    }

}
