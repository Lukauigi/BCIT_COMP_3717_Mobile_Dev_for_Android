package com.bcit.lukaszbednarek.myapplication;

import java.util.ArrayList;
import java.util.Date;

public class OffLeashParks {

    public static class Parameters{
        public String dataset;
        public int rows;
        public int start;
        public ArrayList<String> facet;
        public String format;
        public String timezone;
    }

    public static class Geom{
        public ArrayList<ArrayList<ArrayList<Double>>> coordinates;
        public String type;
    }

    public static class Fields{
        public String geo_local_area;
        public Geom geom;
        public String url;
        public String address;
        public String name;
    }

    public static class Record{
        public String datasetid;
        public String recordid;
        public Fields fields;
        public Date record_timestamp;
    }

    public static class Facet{
        public String name;
        public int count;
        public String state;
        public String path;
    }

    public static class FacetGroup{
        public String name;
        public ArrayList<Facet> facets;
    }

    public static class Root{
        public int nhits;
        public Parameters parameters;
        public ArrayList<Record> records;
        public ArrayList<FacetGroup> facet_groups;
    }
}
