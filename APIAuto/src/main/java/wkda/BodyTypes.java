package wkda;

public enum BodyTypes {

    BODY_TYPES2("/body-types");

    String path;

    BodyTypes(String path) {this.path = path;}

    public String getPath() {return path;}

    public String addPath(String additionalPath) {return path + additionalPath;}
}
