package wkda;

public enum Manufacturer {

    MANUFACTURES2("/manufacturer");

    String path;

    Manufacturer(String path) {this.path = path;}

    public String getPath() {return path;}

    public String addPath(String additionalPath) {return path + additionalPath;}
}
