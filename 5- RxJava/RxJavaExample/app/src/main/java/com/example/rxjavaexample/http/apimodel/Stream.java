
package com.example.rxjavaexample.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stream {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("viewers")
    @Expose
    private Integer viewers;
    @SerializedName("video_height")
    @Expose
    private Integer videoHeight;
    @SerializedName("average_fps")
    @Expose
    private Integer averageFps;
    @SerializedName("delay")
    @Expose
    private Integer delay;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("is_playlist")
    @Expose
    private Boolean isPlaylist;
    @SerializedName("stream_type")
    @Expose
    private String streamType;
    @SerializedName("preview")
    @Expose
    private Preview preview;
    @SerializedName("channel")
    @Expose
    private Channel channel;
    @SerializedName("_links")
    @Expose
    private Links_ links;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public Integer getAverageFps() {
        return averageFps;
    }

    public void setAverageFps(Integer averageFps) {
        this.averageFps = averageFps;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsPlaylist() {
        return isPlaylist;
    }

    public void setIsPlaylist(Boolean isPlaylist) {
        this.isPlaylist = isPlaylist;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

}
