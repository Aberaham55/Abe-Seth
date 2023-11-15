package Data;


import java.util.ArrayList;
import java.util.List;

public class Contacts_methods {
    private String name;
    private List<Long> number;

    //constructor
    public void Contacts(String name) {
        this.name = name;
        this.number = new ArrayList<>();
    }
    //getter
    public String getName() {
        return name;
    }

    public List<Long> getNumber() {
        return number;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(List<Long> number) {
        this.number = number;
    }
}
