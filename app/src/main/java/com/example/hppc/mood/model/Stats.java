package com.example.hppc.mood.model;

/**
 * Created by madscientist on 19/3/17.
 */

public class Stats
{
    private String checkinsCount;

    private String usersCount;

    private String tipCount;

    public String getCheckinsCount ()
    {
        return checkinsCount;
    }

    public void setCheckinsCount (String checkinsCount)
    {
        this.checkinsCount = checkinsCount;
    }

    public String getUsersCount ()
    {
        return usersCount;
    }

    public void setUsersCount (String usersCount)
    {
        this.usersCount = usersCount;
    }

    public String getTipCount ()
    {
        return tipCount;
    }

    public void setTipCount (String tipCount)
    {
        this.tipCount = tipCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [checkinsCount = "+checkinsCount+", usersCount = "+usersCount+", tipCount = "+tipCount+"]";
    }
}
