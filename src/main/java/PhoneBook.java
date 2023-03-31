import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();

    int add(String name, String number) throws Exception {
        if (phoneBook.containsKey(name)) {
            throw new Exception("Контакт " + name + " с номером " + number + " не добавлен. " +
                                "Контакт с таким имененм уже существует");
        } else {
            phoneBook.put(name, number);
            return phoneBook.size();
        }
    }

    //Выводит несколько имен, если у них одинаковый номер
    String findByNumber(String number) {
        if (phoneBook.containsValue(number)) {
            return phoneBook.entrySet().stream()
                    .filter(x -> x.getValue().equals(number))
                    .map(Map.Entry::getKey)
                    .reduce((x, y) -> x + ",\n" + y).get();
        } else {
            return null;
        }
    }

    String findByName(String name) {
        return phoneBook.getOrDefault(name, null);
    }
}
