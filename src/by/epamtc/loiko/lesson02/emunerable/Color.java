package by.epamtc.loiko.lesson02.emunerable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public enum Color {

    RED("красных"),
    BLUE("синих"),
    GREEN("зелёных"),
    YELLOW("жёлтых"),
    PURPLE("фиолетовых"),
    BLACK("чёрных"),
    WHITE("белых"),
    PINK("розовых");

    private String colorName;

    Color(String name) {
        colorName = name;
    }

    @Override
    public String toString() {
        return colorName;
    }
}