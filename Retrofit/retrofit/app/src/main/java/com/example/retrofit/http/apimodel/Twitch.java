
package com.example.retrofit.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Twitch {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("streams")
    @Expose
    private List<Stream> streams = null;
    @SerializedName("_links")
    @Expose
    private Links__ links;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public Links__ getLinks() {
        return links;
    }

    public void setLinks(Links__ links) {
        this.links = links;
    }

}
