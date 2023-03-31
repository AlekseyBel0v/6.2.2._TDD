import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.*;

public class PhoneBookTest {
    private PhoneBook phoneBook = new PhoneBook();

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

    @Test
    void testForFindByName() throws Exception {
        String name1 = "Petya",
                name2 = "Vanya",
                phoneNumber1 = "1111",
                expectedFoundNumber1 = "1111",
                expectedFoundNumber2 = null;

        phoneBook.add(name1, phoneNumber1);
        String foundNumber1 = phoneBook.findByName(name1);
        String foundNumber2 = phoneBook.findByName(name2);

        Assertions.assertEquals(expectedFoundNumber1, foundNumber1);
        Assertions.assertEquals(expectedFoundNumber2, foundNumber2);
    }

    @Test
    void testForPrintAllNames() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String name1 = "Vanya",
                name2 = "Petya",
                phoneNumber1 = "1111",
                phoneNumber2 = "2222",
                expectedOutput = "Petya, Vanya";

        phoneBook.printAllNames();

        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}
