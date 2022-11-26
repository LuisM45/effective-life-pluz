/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.epnmag9.effectivelifepluz.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
    static Date startDate = null;
    static Date endDate = null;
    public HistorialClinicoTest() {
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_two_dates_when_endDate_before_startDate_then_exception() throws ParseException {
        historialClinico.getEntradaInBetween(endDate,startDate);
    }
    
    @Test
    public void given_no_dates_when_endDate_before_startDate_then_ok() throws ParseException {
        assertArrayEquals(historialClinico.entradasDatosClinicos.toArray(), historialClinico.getEntradaInBetween(null,null).toArray());
    }
    
    @Test
    public void given_no_dates_when_not_same_list_then_ok(){
        assertNotSame(historialClinico.entradasDatosClinicos, historialClinico.getEntradaInBetween(null,null));
    }
    
    @Test
    public void given_startDate_when_accurate_list_then_ok() throws ParseException{
        List<EntradaDatosClinicos> resultList = historialClinico.getEntradaInBetween(startDate, null);
        assertEquals(resultList.size(), 3);
    }
    
    @Test
    public void given_endDate_when_accurate_list_then_ok() throws ParseException{
        List<EntradaDatosClinicos> resultList = historialClinico.getEntradaInBetween(null , endDate);
        assertEquals(resultList.size(), 3);
    }
    
    @Test
    public void given_two_dates_when_normal_dates_then_ok() throws ParseException{
        List<EntradaDatosClinicos> resultList = historialClinico.getEntradaInBetween(startDate , endDate);
        assertEquals(resultList.size(), 2);
    }
    
    @BeforeClass
    public static void setUpClass() throws ParseException {
        historialClinico = new HistorialClinico();
        startDate = (new SimpleDateFormat("yyyyMMdd").parse("20000101"));
        endDate  = (new SimpleDateFormat("yyyyMMdd").parse("20000102"));
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
        historialClinico.registerEntradaDatosClinicos(1, 1, 2, 1, 37, dateParser.parse("20000101"), "");
        historialClinico.registerEntradaDatosClinicos(1, 1, 2, 1, 37, dateParser.parse("20010101"), "");
        historialClinico.registerEntradaDatosClinicos(1, 1, 2, 1, 37, dateParser.parse("20020101"), "");
        historialClinico.registerEntradaDatosClinicos(1, 1, 2, 1, 37, dateParser.parse("20030101"), "");
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
