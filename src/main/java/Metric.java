public class Metric {
    public double Value;
    public String Unit;
    public int UnitType;

    @Override
    public String toString(){
        return Value+"°"+Unit;
    }
    public double valor(){
        return Value;
    }
}
