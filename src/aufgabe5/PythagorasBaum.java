package aufgabe5;

public class PythagorasBaum {
    static void draw(double x, double y, double w, double alpha) {
        double sigma = Math.toRadians(30);
        if (w >= 0.1) {
            double s = w * Math.cos(alpha);
            double c = w * Math.sin(alpha);
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
            StdDraw.line(xa, ya, xb, yb);
            StdDraw.line(xb, yb, xc, yc);
            StdDraw.line(xc, yc, xd, yd);
            StdDraw.line(xd, yd, xa, ya);
            //Koordinaten Dreieck
            double u = w * Math.cos(sigma);
            double v = w * Math.sin(sigma);
            double xe = xd + u * Math.cos(sigma + alpha);
            double ye = yd + u * Math.sin(sigma + alpha);
            //Dreieck zeichnen
            StdDraw.line(xd, yd, xe, ye);
            StdDraw.line(xe, ye, xc, yc);
        }
    }

    public static void main(String[] args) {
        StdDraw.setXscale(-6, 6);
        StdDraw.setYscale(-1, 11);
        draw(0, 0, 1, 1);
    }
}
