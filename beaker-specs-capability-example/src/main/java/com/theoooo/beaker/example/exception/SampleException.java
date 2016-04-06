package com.theoooo.beaker.example.exception;

import com.theoooo.beaker.example.api.SampleCapability;
import com.theoooo.beaker.specs.model.CapabilityException;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public class SampleException extends CapabilityException {

    protected static final int BASE_Sample = 2000000;

    public SampleException(SampleCapability.EC code) {
        super(BASE_Sample, code.ordinal());
    }

}
