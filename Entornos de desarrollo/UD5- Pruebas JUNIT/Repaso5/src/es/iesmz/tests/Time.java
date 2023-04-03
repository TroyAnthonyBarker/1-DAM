package es.iesmz.tests;

import java.util.Objects;

public class Time {
    private int h;
    private int m;
    private int s;

    public Time(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public Time nextSecond() {
        if (s+1 < 60){
            return new Time(h, m, s+1);
        } else if (m+1 < 60){
            return new Time(h, m+1, 0);
        } else if (h+1 < 24){
            return new Time(h+1, 0, 0);
        } else return new Time(0, 0, 0);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Time time)) return false;
        return h == time.h && m == time.m && s == time.s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(h, m, s);
    }
}
