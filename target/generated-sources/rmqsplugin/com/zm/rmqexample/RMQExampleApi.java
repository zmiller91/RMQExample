package com.zm.rmqexample;

import com.zm.rmqexample.exception.*;
import com.zm.rmqexample.model.*;
import java.util.concurrent.TimeoutException;
import com.zm.rabbitmqservice.service.ServiceException;
import com.zm.rabbitmqservice.service.ServiceUnavailableException;
import java.io.IOException;
import com.zm.rabbitmqservice.client.ClientException;

public interface RMQExampleApi {
    public Person getPerson(int id) throws TimeoutException, IOException, ServiceUnavailableException, ServiceException, ClientException;
    public Person updatePerson(Person person) throws TimeoutException, IOException, ServiceUnavailableException, ServiceException, ClientException, PersonNotFoundException;
    public Person putPerson(Person person) throws TimeoutException, IOException, ServiceUnavailableException, ServiceException, ClientException;
}