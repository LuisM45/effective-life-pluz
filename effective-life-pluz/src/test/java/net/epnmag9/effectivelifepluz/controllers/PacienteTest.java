/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package net.epnmag9.effectivelifepluz.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static net.epnmag9.effectivelifepluz.controllers.HistorialClinicoTest.historialClinico;
import net.epnmag9.effectivelifepluz.ui.CLIInteractiveIOManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author luism
 */
public class PacienteTest {
    Date birthdate = null;
    static CLIInteractiveIOManager cLII = null;
    public PacienteTest() {
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_blood_type_when_not_valid_then_exception() throws ParseException {
        Date birthdate = (new SimpleDateFormat("yyyyMMdd").parse("20000101"));
        Paciente p = new Paciente(new Cedula("1234567897"), "Marcelo Monty Rojas Sasa", birthdate, cLII.readBloodTypeUntilSuccess(null, null, null), "H");

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void given_identifier_when_not_valid_then_exception() throws ParseException {
        Date birthdate = (new SimpleDateFormat("yyyyMMdd").parse("20000101"));
        Paciente p = new Paciente(cLII.readIdentificadorUntilSuccess(), "Marcelo Monty Rojas Sasa", birthdate, TipoSanguineo.AB_NEG, "H");
    }
    
    @BeforeClass
    public static void setUpClass() throws ParseException {
        
        //birthdate = (new SimpleDateFormat("yyyyMMdd").parse("20000101"));
        
        cLII = Mockito.mock(CLIInteractiveIOManager.class);
        Mockito.when(cLII.readBloodTypeUntilSuccess(null, null, null)).thenReturn(null);
        Mockito.when(cLII.readIdentificadorUntilSuccess()).thenReturn(null);
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
