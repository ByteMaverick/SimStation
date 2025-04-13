package mvc;
/*
Edits:
Mohammed Ansari: 4/10 created file, using code from minefield assignment
 */
import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    private boolean unsavedChanges = false;
    private String fileName = null;

    public Model() {

    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public String getFileName() {
        return fileName;
    }

    public static void changed() {
        unsavedChanges = true;
        this.notifySubscribers();
    }
}
