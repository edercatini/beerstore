package com.ec.beerstore.model;

import java.net.URI;

public class CustomResponse<T> {

    private T entity;
    private URI uri;

    public CustomResponse() {

    }

    public CustomResponse(T entity, URI uri) {
        this.entity = entity;
        this.uri = uri;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}