//ReadFileHandler

package lesson7.x;

public abstract class ReadFileHandler {
    private String filename;

    public ReadFileHandler(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
