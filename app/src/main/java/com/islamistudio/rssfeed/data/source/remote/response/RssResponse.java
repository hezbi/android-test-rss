package com.islamistudio.rssfeed.data.source.remote.response;

import com.islamistudio.rssfeed.data.source.remote.entity.Channel;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss")
public class RssResponse {

    @Element
    private Channel channel;

    @Attribute
    private String version;

    public Channel getChannel() {
        return channel;
    }
}
