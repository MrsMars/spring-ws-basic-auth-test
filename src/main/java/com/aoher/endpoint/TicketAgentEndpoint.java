package com.aoher.endpoint;

import com.aoher.ticketagent.ObjectFactory;
import com.aoher.ticketagent.TFlightsResponse;
import com.aoher.ticketagent.TListFlights;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import java.math.BigInteger;

@Endpoint
public class TicketAgentEndpoint {

    @PayloadRoot(
            namespace = "http://aoher.com/TicketAgent.xsd",
            localPart = "listFlightsRequest"
    )
    @ResponsePayload
    public JAXBElement<TFlightsResponse> listFlights(@RequestPayload JAXBElement<TListFlights> request) {
        ObjectFactory factory = new ObjectFactory();
        TFlightsResponse tFlightsResponse = factory.createTFlightsResponse();
        tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(101));

        return factory.createListFlightsResponse(tFlightsResponse);
    }
}
