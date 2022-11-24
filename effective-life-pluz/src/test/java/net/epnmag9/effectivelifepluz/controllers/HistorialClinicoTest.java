/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.epnmag9.effectivelifepluz.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class HistorialClinicoTest {
    static HistorialClinico historialClinico = null;
    public HistorialClinicoTest() {
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_two_dates_when_endDate_before_startDate_then_exception() throws ParseException {
        Date startDate = (new SimpleDateFormat("yyyyMMdd").parse("20000101"));
        Date endDate = (new SimpleDateFormat("yyyyMMdd").parse("20000102"));
        historialClinico.getEntradaInBetween(endDate,startDate);
    }
    @BeforeClass
    public static void setUpClass() throws ParseException {
        historialClinico = new HistorialClinico();
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        historialClinico.registerEntradaDatosClinicos(0, 0, 0, 0, dateParser.parse("20000101"), "");
        historialClinico.registerEntradaDatosClinicos(0, 0, 0, 0, dateParser.parse("20010101"), "");
        historialClinico.registerEntradaDatosClinicos(0, 0, 0, 0, dateParser.parse("20020101"), "");
        historialClinico.registerEntradaDatosClinicos(0, 0, 0, 0, dateParser.parse("20030101"), "");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
}
