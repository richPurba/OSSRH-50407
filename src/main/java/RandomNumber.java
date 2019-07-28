public class RandomNumber {
    private String type;
    private int length;
    private int[] data;
    private boolean status;

    public RandomNumber(String type, int length, int[] data, boolean status) {
        this.type = type;
        this.length = length;
        this.data = data;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
