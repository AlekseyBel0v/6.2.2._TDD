import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @Test
    void testByAdditionNewContact() throws Exception {
        String name = "Petya";
        String phoneNumber = "1111";
        int expectedQuantityOfContacts = 1;

        int quantityOfContacts = phoneBook.add(name, phoneNumber);

        Assertions.assertEquals(expectedQuantityOfContacts, quantityOfContacts);
    }

    @Test
    void testByAdditionDoubleContact() {
        String name = "Petya";
        String phoneNumber = "1111";

        Executable executable = () -> {
            phoneBook.add(name, phoneNumber);
            phoneBook.add(name, phoneNumber);
        };

        Assertions.assertThrows(Exception.class, executable);
    }

    @Test
    void testForFindByNumber() throws Exception {
        String name1 = "Petya",
                phoneNumber1 = "1111",
                phoneNumber2 = "2222",
                expectedFoundName1 = "Petya",
                expectedFoundName2 = null;

        phoneBook.add(name1, phoneNumber1);
        String foundName1 = phoneBook.findByNumber(phoneNumber1);
        String foundName2 = phoneBook.findByNumber(phoneNumber2);

        Assertions.assertEquals(expectedFoundName1, foundName1);
        Assertions.assertEquals(expectedFoundName2, foundName2);
    }
}
