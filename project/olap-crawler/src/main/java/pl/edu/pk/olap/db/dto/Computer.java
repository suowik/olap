package pl.edu.pk.olap.db.dto;

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
    private int price;
    private String model;
    private String os = "Brak";
    private String cpu;
    private String ram;
    private String hdd = "SSD";
    private String screen;
    private String graphics = "zintegrowana";
    private Long timestamp;
    private String source;

    public enum Source {
        EURO_RTV_AGD("euro"),KOMPUTRONIK("komputronik"),MEDIA_MARKT("media_markt"),SATURN("saturn"),VOBIS("vobis");
        private String name;
        Source(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Computer(int price, String model, String os, String cpu, String ram, String hdd, String screen, String graphics, String source) {
        this.price = price;
        this.model = model;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.screen = screen;
        this.graphics = graphics;
        this.source = source;
    }

    public Computer() {
    }

    public boolean isFilledCorrectly(){
        return price != 0 && !StringUtils.isAnyEmpty(os,model,cpu,ram,graphics);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (price != computer.price) return false;
        if (cpu != null ? !cpu.equals(computer.cpu) : computer.cpu != null) return false;
        if (graphics != null ? !graphics.equals(computer.graphics) : computer.graphics != null) return false;
        if (hdd != null ? !hdd.equals(computer.hdd) : computer.hdd != null) return false;
        if (model != null ? !model.equals(computer.model) : computer.model != null) return false;
        if (os != null ? !os.equals(computer.os) : computer.os != null) return false;
        if (ram != null ? !ram.equals(computer.ram) : computer.ram != null) return false;
        if (screen != null ? !screen.equals(computer.screen) : computer.screen != null) return false;
        if (source != null ? !source.equals(computer.source) : computer.source != null) return false;
        if (timestamp != null ? !timestamp.equals(computer.timestamp) : computer.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + (ram != null ? ram.hashCode() : 0);
        result = 31 * result + (hdd != null ? hdd.hashCode() : 0);
        result = 31 * result + (screen != null ? screen.hashCode() : 0);
        result = 31 * result + (graphics != null ? graphics.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
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
                ", graphics='" + graphics + '\'' +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                '}';
    }
}

