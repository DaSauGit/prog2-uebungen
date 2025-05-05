package aufgabe5;

import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class PythagorasBaum {
    static void draw(double x, double y, double w, double a) {
        double sigma = Math.toRadians(30);
        if (w >= 0.02) {
            if (w >= 0.3) {
                StdDraw.setPenColor(new Color(0x5b3a29));
            } else if (w >= 0.05) {
                StdDraw.setPenColor(new Color(0x974C26));
            } else {
                StdDraw.setPenColor(new Color(0x20C320));
            }
            double alpha = a;
            double s = w * Math.sin(alpha);
            double c = w * Math.cos(alpha);
            //Koordinaten Quadrat
            double xa = x;
            double ya = y;
            double xb = x + c;
            double yb = y + s;
            double xc = x + c - s;
            double yc = y + s + c;
            double xd = x - s;
            double yd = y + c;
            //Quadrat zeichnen
            //StdDraw.line(xa, ya, xb, yb);
            StdDraw.line(xb, yb, xc, yc);
            //StdDraw.line(xc, yc, xd, yd);
            StdDraw.line(xd, yd, xa, ya);
            //Koordinaten Dreieck
            double u = w * Math.cos(sigma);
            double v = w * Math.sin(sigma);
            double xe = xd + (u * Math.cos(sigma + alpha));
            double ye = yd + (u * Math.sin(sigma + alpha));
            //Dreieck zeichnen
            //StdDraw.line(xd, yd, xe, ye);
            //StdDraw.line(xe, ye, xc, yc);
            //Rekursion
            double alpha1 = alpha + sigma;
            draw(xd, yd, u, alpha1);
            double alpha2 = (alpha + sigma) + Math.toRadians(270);
            draw(xe, ye, v, alpha2 );
        }
    }

    public static void main(String[] args) {
        StdDraw.setXscale(-6, 6);
        StdDraw.setYscale(-1, 11);
        draw(0, 0, 1, Math.toRadians(0));
    }
}
