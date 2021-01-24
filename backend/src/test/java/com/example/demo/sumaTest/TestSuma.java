package com.example.demo.sumaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.example.demo.model.Suma;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import netscape.javascript.JSObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestSuma extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    private final Gson gson;

    TestSuma(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Test
    public void sumarOperandosTestUno() throws Exception {
        String uri = "/suma";
        Suma suma = new Suma();
        suma.setOperando1(0);
        suma.setOperando2(-1);
        //String inputJson = super.mapToJson(suma);
        String inputJson = gson.toJson(suma);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String sumaRes = mvcResult.getResponse().getContentAsString();
        Suma sumaFinal = gson.fromJson(sumaRes, Suma.class);

        assertEquals(sumaFinal.getResultado(),-1);
    }

    @Test
    public void sumarOperandosTestDos() throws Exception {
        String uri = "/suma";
        Suma suma = new Suma();
        suma.setOperando1(1000000);
        suma.setOperando2(1);
        //String inputJson = super.mapToJson(suma);
        String inputJson = gson.toJson(suma);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String sumaRes = mvcResult.getResponse().getContentAsString();
        Suma sumaFinal = gson.fromJson(sumaRes, Suma.class);

        assertEquals(sumaFinal.getResultado(),1000001);
    }

    @Test
    public void sumarOperandosTestTres() throws Exception {
        String uri = "/suma";
        Suma suma = new Suma();
        suma.setOperando1(100);
        suma.setOperando2(200);
        //String inputJson = super.mapToJson(suma);
        String inputJson = gson.toJson(suma);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String sumaRes = mvcResult.getResponse().getContentAsString();
        Suma sumaFinal = gson.fromJson(sumaRes, Suma.class);

        assertEquals(sumaFinal.getResultado(),300);
    }

    @Test
    public void sumarOperandosTestCuatro() throws Exception {
        String uri = "/suma";
        Suma suma = new Suma();
        suma.setOperando1(-1);
        suma.setOperando2(1);
        //String inputJson = super.mapToJson(suma);
        String inputJson = gson.toJson(suma);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        String sumaRes = mvcResult.getResponse().getContentAsString();
        Suma sumaFinal = gson.fromJson(sumaRes, Suma.class);

        assertEquals(sumaFinal.getResultado(),0);
    }
}
