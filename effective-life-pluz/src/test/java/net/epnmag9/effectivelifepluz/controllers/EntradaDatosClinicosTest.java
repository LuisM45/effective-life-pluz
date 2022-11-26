/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package net.epnmag9.effectivelifepluz.controllers;

import java.lang.reflect.Array;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EntradaDatosClinicosTest {
    float sisPressure, diaPressure;
    boolean isValid;
    static Date d = null;
    
    public EntradaDatosClinicosTest(float diaPressure, float sisPressure) {
        super();
        this.sisPressure = sisPressure;
        this.diaPressure = diaPressure;
        
    }
    
    @Parameterized.Parameters
    public static Collection inputNotReversed() {
        return Arrays.asList(new Object[][]{
            {60,60},
            {120,80},
            {-80,120},
            {-100,-60},
            {-90,110},
            {120,-80}
        });
    }
    

    
    @Test(expected = IllegalArgumentException.class)
    public void given_constructor_when_negative_weight_then_exception() throws ParseException{
        EntradaDatosClinicos edc = new EntradaDatosClinicos(-200, 170, 120, 80, 37.5, d, "");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_constructor_when_negative_height_then_exception() throws ParseException{
        EntradaDatosClinicos edc = new EntradaDatosClinicos(100, -1, 120, 80, 37.5, d, "");
    }
    
    @Test
    public void given_pressure_when_inverted_pressure_then_exception() throws ParseException, Throwable{
        ThrowingRunnable r = ()->{
            EntradaDatosClinicos edc = new EntradaDatosClinicos(100, 170, sisPressure, diaPressure, 37.5, d, "");
        };
        
        if(isValid){
            r.run();
        }
        else{
            assertThrows("",IllegalArgumentException.class, r);
        }
        
    }
    
    @Test()
    public void given_pressure_when_negative_pressure_then_exception() throws ParseException, Throwable{        
        ThrowingRunnable r = ()->{
            EntradaDatosClinicos edc = new EntradaDatosClinicos(100, 170, sisPressure, diaPressure, 37.5, d, "");
        };
        
        if(isValid){
            r.run();
        }
        else{
            assertThrows("",IllegalArgumentException.class, r);
        }
    }
                
    

    @BeforeClass
    public static void setUpClass() throws ParseException {
        Date d =(new SimpleDateFormat("yyyyMMdd").parse("20000222"));
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

