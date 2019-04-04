package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class ApplicationPart {
    public final String name;
    private double state;

    public ApplicationPart(String name){
        this.name = name;
    }

    public double getState() {
        return state;
    }

    public void complete(double state) {
        if (state > 0) {
            this.state += state;
        }
        if (state > 1){
            this.state = 1;
        }
    }

    public boolean isComplete(){
        return getState() == 1;
    }

}
