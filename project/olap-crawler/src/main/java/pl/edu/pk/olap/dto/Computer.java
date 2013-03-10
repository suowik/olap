package pl.edu.pk.olap.dto;

import pl.edu.pk.olap.utils.StringUtils;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Paweł
 * Date: 10.03.13
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class Computer implements Serializable {
    private double price;
    private String model;
    private String os;
    private String cpu;
    private String ram;
    private String hdd;
    private String screen;

    public boolean isFilledCorrectly(){
        return price != 0.0 && !StringUtils.isAnyEmpty(this.os,this.model,this.cpu,this.ram,this.hdd,this.screen);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (Double.compare(computer.price, price) != 0) return false;
        if (cpu != null ? !cpu.equals(computer.cpu) : computer.cpu != null) return false;
        if (hdd != null ? !hdd.equals(computer.hdd) : computer.hdd != null) return false;
        if (model != null ? !model.equals(computer.model) : computer.model != null) return false;
        if (os != null ? !os.equals(computer.os) : computer.os != null) return false;
        if (ram != null ? !ram.equals(computer.ram) : computer.ram != null) return false;
        if (screen != null ? !screen.equals(computer.screen) : computer.screen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = price != +0.0d ? Double.doubleToLongBits(price) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (hdd != null ? hdd.hashCode() : 0);
        result = 31 * result + (screen != null ? screen.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", hdd='" + hdd + '\'' +
                ", screen='" + screen + '\'' +
                '}';
    }
}
