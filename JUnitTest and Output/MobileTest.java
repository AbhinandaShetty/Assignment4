package com.example.mobile.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MobileTest {
   
    @Test
    void testConstructor() {
        Mobile actualMobile = new Mobile();
        actualMobile.setId(1);
        actualMobile.setName("Name");
        actualMobile.setPrice(1);
        actualMobile.setStatus("Status");
        assertEquals(1, actualMobile.getId());
        assertEquals("Name", actualMobile.getName());
        assertEquals(1, actualMobile.getPrice());
        assertEquals("Status", actualMobile.getStatus());
    }
}

