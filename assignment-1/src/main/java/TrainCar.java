public class TrainCar {

    public static final double EMPTY_WEIGHT = 20; // In kilograms

    WildCat cat;
    TrainCar next = null;

    public TrainCar(WildCat cat) {
        this.cat = cat;
    }

    public TrainCar(WildCat cat, TrainCar next) {
        this.cat = cat;
        this.next = next;
    }

    public double computeTotalWeight() {
        return helperWeight(this);
    }

    public double computeTotalMassIndex() {
        return helperMassIndex(this);
    }

    public void printCar() {
        System.out.println(helperPrintCar(this));
    }

    private double helperWeight(TrainCar train){
        if (train.next == null){
            return train.cat.weight;
        }else{
            return train.cat.weight + helperWeight(train.next);
        }
    }

    private double helperMassIndex(TrainCar train){
        if (train.next == null){
            return train.cat.computeMassIndex();
        }else{
            return train.cat.computeMassIndex() + helperMassIndex(train.next);
        }
    }

    private String helperPrintCar(TrainCar train){
        if (train.next == null){
            return "(" + train.cat.name + ")";
        }else{
            return "(" + train.cat.name + ")--" + helperPrintCar(train.next);
        }
    }
}
