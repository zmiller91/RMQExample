package com.zm.rmqexample;

import com.zm.rmqexample.exception.*;
import com.zm.rmqexample.model.*;
import java.util.concurrent.TimeoutException;
import com.zm.rabbitmqservice.client.RMQClient;
import com.zm.rabbitmqservice.service.ServiceException;
import com.zm.rmqexample.configuration.RMQExampleConfiguration;
import com.google.gson.Gson;
import com.zm.rabbitmqservice.service.ServiceUnavailableException;
import java.io.IOException;
import com.zm.rabbitmqservice.client.ClientException;
import com.google.gson.JsonArray;
import java.util.concurrent.ExecutorService;

public class RMQExampleClient extends RMQClient implements RMQExampleApi {
    public RMQExampleClient(RMQExampleConfiguration.Host host, RMQExampleConfiguration.Channel channel) {
        super(host.getValue(), channel.getValue());
    }

    @Override
    public Person getPerson(int id) throws IOException, TimeoutException, ServiceUnavailableException, ServiceException, ClientException {
        try {
            Gson gson = new Gson();
            JsonArray json = new JsonArray();
            json.add(gson.toJsonTree(id));
            return this.call("getPerson", json, Person.class);
        } catch (IOException | TimeoutException | ServiceUnavailableException | ServiceException | ClientException e) {
            throw e;
        } catch (Throwable t) { 
            throw new ClientException("Unknown exception thrown: " + t.getMessage(), t);
        }
    }

    @Override
    public Person updatePerson(Person person) throws PersonNotFoundException, IOException, TimeoutException, ServiceUnavailableException, ServiceException, ClientException {
        try {
            Gson gson = new Gson();
            JsonArray json = new JsonArray();
            json.add(gson.toJsonTree(person));
            return this.call("updatePerson", json, Person.class);
        } catch (PersonNotFoundException | IOException | TimeoutException | ServiceUnavailableException | ServiceException | ClientException e) {
            throw e;
        } catch (Throwable t) { 
            throw new ClientException("Unknown exception thrown: " + t.getMessage(), t);
        }
    }

    @Override
    public Person putPerson(Person person) throws IOException, TimeoutException, ServiceUnavailableException, ServiceException, ClientException {
        try {
            Gson gson = new Gson();
            JsonArray json = new JsonArray();
            json.add(gson.toJsonTree(person));
            return this.call("putPerson", json, Person.class);
        } catch (IOException | TimeoutException | ServiceUnavailableException | ServiceException | ClientException e) {
            throw e;
        } catch (Throwable t) { 
            throw new ClientException("Unknown exception thrown: " + t.getMessage(), t);
        }
    }
}