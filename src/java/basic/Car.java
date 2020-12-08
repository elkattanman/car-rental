package basic;

public class Car {

    private String type;
    private String model;
    private String productionYear;
    private double priceDay;

    public Car() {
    }

    public Car(String type, String model, String productionYear, double priceDay) {
        this.type = type;
        this.model = model;
        this.productionYear = productionYear;
        this.priceDay = priceDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", priceDay=" + priceDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getType() != null ? !getType().equals(car.getType()) : car.getType() != null) return false;
        if (getModel() != null ? !getModel().equals(car.getModel()) : car.getModel() != null) return false;
        return getProductionYear() != null ? getProductionYear().equals(car.getProductionYear()) : car.getProductionYear() == null;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getProductionYear() != null ? getProductionYear().hashCode() : 0);
        return result;
    }
}