package wkda;

public enum Maintypesdetails {

    MAIN_TYPES_DETAILS2("/main-types-details");

    String path;

    Maintypesdetails(String path) {this.path = path;}

    public String getPath() {return path;}

    public String addPath(String additionalPath) {return path + additionalPath;}
}
