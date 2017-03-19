package com.example.hppc.mood.model;

/**
 * Created by madscientist on 19/3/17.
 */


public class Location
{
    private String distance;

    private String[] formattedAddress;

    private String lng;

    private String cc;

    private String lat;

    private String country;

    public String getDistance ()
    {
        return distance;
    }

    public void setDistance (String distance)
    {
        this.distance = distance;
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

    @Override
    public String toString()
    {
        return "ClassPojo [distance = "+distance+",  formattedAddress = "+formattedAddress+", lng = "+lng+", cc = "+cc+", lat = "+lat+", country = "+country+"]";
    }
}

