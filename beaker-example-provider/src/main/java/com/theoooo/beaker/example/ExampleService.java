package com.theoooo.beaker.example;

import com.theoooo.beaker.example.api.ExampleCapability;
import com.theoooo.beaker.example.exception.ExampleException;
import com.theoooo.beaker.example.model.ExampleForm;
import com.theoooo.beaker.example.model.ExampleView;

import java.util.List;

/**
 * Created by WangYanJiong on 4/5/16.
 */
public class ExampleService implements ExampleCapability {

    public ExampleView createExample(ExampleForm form) throws ExampleException {
        throw new ExampleException(EC.name_is_null);
    }

    public List<ExampleView> queryExamples(String key, String value, int page, int size) throws ExampleException {
        return null;
    }

    public ExampleView findExample(String exampleId) throws ExampleException {
        return null;
    }

    public ExampleView updateExample(ExampleForm form) throws ExampleException {
        return null;
    }

    public ExampleView deleteExample(String exampleId) throws ExampleException {
        return null;
    }

    public ExampleView getExampleStatus(String exampleId) throws ExampleException {
        return null;
    }
}
