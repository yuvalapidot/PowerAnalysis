package model;

/**
 * Created by Michael on 10/06/2017.
 */
public class Trace
{
    private String PlainText;
    private double [] traices = new double[64];

    public void SetPlainText(String TmpPlain)
    {
        PlainText = TmpPlain;
    }

    public void SetTraices(double [] TmpTraices)
    {
        traices = TmpTraices;
    }

    public String GetPlainText()
    {
        return PlainText;
    }

    public double [] GetTraices()
    {
        return traices;
    }

}
