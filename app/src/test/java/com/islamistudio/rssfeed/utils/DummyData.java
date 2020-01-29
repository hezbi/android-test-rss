package com.islamistudio.rssfeed.utils;

import com.islamistudio.rssfeed.data.source.remote.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static List<Item> generateDummyFeeds() {

        List<Item> items = new ArrayList<>();
        items.add(new Item(
                "Title Dummy 01",
                "https://www.antaranews.com/",
                "2020-01-29",
                "Description Dummy 01",
                "https://www.antaranews.com/"));
        items.add(new Item(
                "Title Dummy 02",
                "https://www.antaranews.com/",
                "2020-01-29",
                "Description Dummy 02",
                "https://www.antaranews.com/"));
        items.add(new Item(
                "Title Dummy 03",
                "https://www.antaranews.com/",
                "2020-01-29",
                "Description Dummy 03",
                "https://www.antaranews.com/"));

        return items;
    }
}
