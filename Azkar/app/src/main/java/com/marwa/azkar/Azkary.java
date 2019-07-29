package com.marwa.azkar;

public class Azkary {

    private String azkarname;
    private int count;


    public Azkary() {

    }

    public Azkary(String azkarname, int count) {
        this.azkarname = azkarname;
        this.count = count;

    }


    public String getAzkarName() {

        return azkarname;
    }

    public void setAzkarName(String name) {
        if (name != "") {
            this.azkarname = name;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count != 0) {
            this.count = count;
        }
    }

/*    public static final Comparator<Azkary> BY_AZKARNAME_ASCENDING = new Comparator<Azkary>() {

        @Override
        public int compare(Azkary t0, Azkary t1) {
            //return t0.getAzkarName().compareTo(t1.azkarname);
             return Integer.valueOf(t0.azkarname).compareTo(Integer.valueOf(t1.azkarname));
        }
    };*/
}




