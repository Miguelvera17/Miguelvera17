public class Vehicle {
    String brand;
    int doors;

    public Vehicle() {
        
    }
    public Vehicle(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getDoors() {
        return doors;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
}