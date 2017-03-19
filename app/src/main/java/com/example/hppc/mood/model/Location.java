package com.example.hppc.mood.model;

/**
 * Created by madscientist on 19/3/17.
 */


public class Location
{
    private String distance;


    private String address;

    private String state;

    private String[] formattedAddress;

    private String lng;

    private String cc;

    private String lat;

    private String country;

    private String city;

    private String crossStreet;

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String[] getFormattedAddress ()
    {
        return formattedAddress;
    }

    public void setFormattedAddress (String[] formattedAddress)
    {
        this.formattedAddress = formattedAddress;
    }

    public String getLng ()
    {
        return lng;
    }

    public void setLng (String lng)
    {
        this.lng = lng;
    }

    public String getCc ()
    {
        return cc;
    }

    public void setCc (String cc)
    {
        this.cc = cc;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCrossStreet ()
    {
        return crossStreet;
    }

    public void setCrossStreet (String crossStreet)
    {
        this.crossStreet = crossStreet;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [distance = "+distance+", address = "+address+", state = "+state+", formattedAddress = "+formattedAddress+", lng = "+lng+", cc = "+cc+", lat = "+lat+", country = "+country+", city = "+city+", crossStreet = "+crossStreet+"]";
    }
}
