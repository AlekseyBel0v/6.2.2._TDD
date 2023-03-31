import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();

    int add(String name, String number) throws Exception{
        if (phoneBook.containsKey(name)) {
            throw new Exception("Контакт " + name + " с номером " + number + " не добавлен. " +
                                "Контакт с таким имененм уже существует");
        } else {
            phoneBook.put(name, number);
            return phoneBook.size();
        }
    }

    String findByNumber(String number) {
        return "";
    }

    String findByName(String name) {
        return "";
    }

    void printAllNames() {

    }
}
