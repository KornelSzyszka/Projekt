package com.simulation.projekt;
import java.util.Random;

public class Environment implements IEvents{
    protected double temperature;
    protected double pollution;
    protected double light;
    protected boolean dayTime;
    protected double dayTimeLength;
    private final double nightTimeLength = 2*dayTimeLength;
    private final Random roll = new Random();

    public Environment(double temperature, double pollution, int dayTimeLength){
        this.temperature = temperature;
        this.pollution = pollution;
        this.dayTimeLength = dayTimeLength;
    }

    @Override
    public void randomEvents(){
            int eventID = roll.nextInt(99);
            int amplitude = roll.nextInt(99);
            if(eventID < 20)
                this.temperature += (double)(amplitude+1)/100;
            else if(eventID > 79)
                this.temperature -= (double)(amplitude+1)/100;
    }
    @Override
    public void periodicEvents(int turnsAmount){
            if((double)turnsAmount % this.dayTimeLength == 0)
                this.dayTime = true;
            if((double)turnsAmount % this.nightTimeLength == 0)
                this.dayTime = false;

            if(this.dayTime){
                this.temperature += 0.1;
                this.light += 1/dayTimeLength;
            }else{
                this.temperature -= 0.1;
                this.light -= 1/dayTimeLength;
            }
    }
}
