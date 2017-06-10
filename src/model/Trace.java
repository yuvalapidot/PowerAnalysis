package model;

/**
 * Created by Michael on 10/06/2017.
 */
public class Trace
{
    private String PlainText;
    private double [] traces;

    public Trace()
    {
        this.PlainText = "";
        this.traces = new double[64];
    }

    public void SetPlainText(String TmpPlain)
    {
        PlainText = TmpPlain;
    }

    public void SetTraices(double [] TmpTraices)
    {
        traces = TmpTraices;
    }

    public String GetPlainText()
    {
        return PlainText;
    }

    public double [] GetTraices()
    {
        return traces;
    }

}
