package com.example.hppc.mood.model;

/**
 * Created by madscientist on 19/3/17.
 */

public class NearByDataRoot
{
    private Response response;

    private Meta meta;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Meta getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta meta)
    {
        this.meta = meta;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response = "+response+", meta = "+meta+"]";
    }
}

