package wkda;

public enum MainTypes {

    MAIN_TYPES2("/main-types");

    String path;

    MainTypes(String path) {this.path = path;}

    public String getPath() {return path;}

    public String addPath(String additionalPath) {return path + additionalPath;}

}
