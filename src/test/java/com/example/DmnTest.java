package com.example;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class DmnTest {

    @Test
    public void test1() throws FileNotFoundException {
        Dmn dmn = new Dmn();
        assertNotEquals(null, dmn);
    }

    @Test
    public void test2() throws FileNotFoundException {
        Dmn dmn = new Dmn();
        DmnDecisionTableResult result = dmn.eval(1234567.89);

        System.out.println(result.getFirstResult().toString());
        assertNotEquals(null, result.getFirstResult());
    }

}