package com.aoher.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TicketAgentClientTest {

    @Autowired
    private TicketAgentClient ticketAgentClient;

    @Test
    public void listFlights() {
        List<BigInteger> flights = ticketAgentClient.listFlights();
        assertEquals(101, flights.get(0).intValue());
    }
}