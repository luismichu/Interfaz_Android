package com.luismichu.interfazandroid;

import com.luismichu.interfazandroid.Data.Factura;
import com.luismichu.interfazandroid.JSONmanager.JSONreader;
import com.luismichu.interfazandroid.XMLmanager.XMLparser;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterfazTest {
    @Test
    public void test1(){
        fail("Datos incorrectos");
        //new Factura(1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    public void test2(){
        fail("Datos incorrectos");
        //new Proveedor(1, 1, 1, 1, 1, 1);
    }

    @Test(expected = AssertionError.class)
    public void test3(){
        JSONreader.readFactura("");
    }

    @Test
    public void test4(){
        XMLparser.parseProveedor(null);
    }
}