package javari.animal;

public abstract class Animal {

    private Integer id;
    private String type;
    private String name;
    private Body body;
    private Condition condition;

    public Animal(Integer id, String type, String name, Gender gender, double length,
                  double weight, Condition condition) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.body = new Body(length, weight, gender);
        this.condition = condition;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return body.getGender();
    }

    public double getLength() {
        return body.getLength();
    }

    public double getWeight() {
        return body.getWeight();
    }

    public Condition getCondition() {
        return condition;
    }

    public boolean isShowable() {
        return condition == Condition.HEALTHY && specificCondition();
    }

    protected abstract boolean specificCondition();
}
