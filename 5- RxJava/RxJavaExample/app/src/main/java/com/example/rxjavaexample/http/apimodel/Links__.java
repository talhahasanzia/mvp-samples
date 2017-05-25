
package com.example.rxjavaexample.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("featured")
    @Expose
    private String featured;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("followed")
    @Expose
    private String followed;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

}
