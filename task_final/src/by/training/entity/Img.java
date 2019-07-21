package by.training.entity;

public class Img implements Entity {
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return false; }
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Img img = (Img) obj;
        if(this.hashCode() != img.hashCode()) { return false; }
        return (filePath == img.getFilePath()
                || (filePath != null && filePath.equals(img.getFilePath())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int)( prime  + ((filePath == null) ? 0 : filePath.hashCode()));
    }

    @Override
    public String toString() {
        return "Img{" + "filePath= '" + filePath + "}";
    }
}
