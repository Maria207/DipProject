package wkda;

public enum BuiltDates {

    BUILT_DATES2("/built-dates");

    String path;

    BuiltDates(String path) {this.path = path;}

    public String getPath() {return path;}

    public String addPath(String additionalPath) {return path + additionalPath;}
}
