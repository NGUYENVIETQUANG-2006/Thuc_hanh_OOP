package B4;

interface IData {
    void show(); // Mặc định là public abstract
}

class DataManager implements IData {
    public void show() { 
        System.out.println("Show Data");
    }
}

public class main4 {
    public static void main(String[] args) {
        IData data = new DataManager();
        data.show();
    }
}