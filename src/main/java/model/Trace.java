package model;

/**
 * Created by Michael on 10/06/2017.
 */
public class Trace
{
    private String plaintext;
    private double [] leaks;

    public Trace() {
    }

    public Trace(String plaintext, double[] leaks) {
        this.plaintext = plaintext;
        this.leaks = leaks;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public double[] getLeaks() {
        return leaks;
    }

    public void setLeaks(double[] leaks) {
        this.leaks = leaks;
    }
}
