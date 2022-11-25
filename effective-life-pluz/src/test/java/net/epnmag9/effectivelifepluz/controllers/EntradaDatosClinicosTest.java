/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package net.epnmag9.effectivelifepluz.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntradaDatosClinicosTest {
    
    public EntradaDatosClinicosTest() {
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_constructor_when_negative_weight_then_exception() throws ParseException{
        Date d = new SimpleDateFormat("yyyyMMdd").parse("20000222");
        EntradaDatosClinicos edc = new EntradaDatosClinicos(-200, 170, 120, 80, 37.5, d, "");
    }
    

    @BeforeClass
    public static void setUpClass() {
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
