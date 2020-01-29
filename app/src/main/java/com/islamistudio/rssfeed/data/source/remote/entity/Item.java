package com.islamistudio.rssfeed.data.source.remote.entity;

import org.simpleframework.xml.Element;

public class Item {

    @Element
    private String title;

    @Element private String link;

    @Element
    private String pubDate;

    @Element
    private String description;

    @Element
    private String guid;

    public Item() {
    }

    public Item(String title, String link, String pubDate, String description, String guid) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
