package com.theoooo.beaker.example;

import com.theoooo.beaker.example.api.SampleCapability;
import com.theoooo.beaker.example.exception.SampleException;
import com.theoooo.beaker.example.model.SampleForm;
import com.theoooo.beaker.example.model.SampleView;
import com.theoooo.beaker.specs.model.CapabilityException;

import java.util.List;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public class SampleService implements SampleCapability {

    public SampleView createSample(SampleForm form) throws SampleException {
        return null;
    }

    public List<SampleView> querySamples(String key, String value, int page, int size) throws CapabilityException {
        return null;
    }

    public SampleView findSample(String exampleId) throws CapabilityException {
        return null;
    }

    public SampleView updateSample(SampleForm form) throws SampleException {
        return null;
    }

    public SampleView deleteSample(String exampleId) throws CapabilityException {
        return null;
    }

    public SampleView getSampleStatus(String exampleId) throws CapabilityException {
        return null;
    }
}
