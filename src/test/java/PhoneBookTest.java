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
}
