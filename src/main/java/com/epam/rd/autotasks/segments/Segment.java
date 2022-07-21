package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    double x1, y1, x2, y2, x3, y3, x4, y4, x, y;
    public Segment(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();

        if (x1==x2 && y1==y2) throw new IllegalArgumentException("segment is not exist");


    }

    double length() {
    double d = sqrt(pow((x2-x1),2 ) + pow((y2-y1),2));
    return d;
    }

    Point middle() {
    double x = (x1+x2)/2;
    double y = (y1+y2)/2;
    return new Point(x,y);
    }

    Point intersection(Segment another) {
        this.x3 = another.x1;
        this.y3 = another.y1;
        this.x4 = another.x2;
        this.y4 = another.y2;
        double denom = ((x1-x2)*(y3-y4))-((y1-y2)*(x3-x4));
        double t = ((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        double u = ((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
        if (denom==0) return null; else {
            if ((0<=t && t<=1) && (0<=u && u<=1)) {
                x = (((x1*y2-y1*x2)*(x3-x4))-((x1-x2)*(x3*y4-y3*x4)))/denom;
                y = (((x1*y2-y1*x2)*(y3-y4))-((y1-y2)*(x3*y4-y3*x4)))/denom;
            } else return null;
        }

        return new Point(x,y);
    }

}
