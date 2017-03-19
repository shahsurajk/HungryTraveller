package com.example.hppc.mood.model;

/**
 * Created by madscientist on 19/3/17.
 */

public class NearByData
{
    private String[] venueChains;

    private Location location;

    private Stats stats;

    private String allowMenuUrlEdit;

    private String contact;

    private String id;

    private String referralId;

    private String verified;

    private String name;

    private String hasPerk;

    public String[] getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(String[] venueChains) {
        this.venueChains = venueChains;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(String allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(String hasPerk) {
        this.hasPerk = hasPerk;
    }
}

