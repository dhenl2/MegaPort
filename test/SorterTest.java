import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class SorterTest {

    /**
     * Checks if two lists are the same
     * @param list1: List 1 to be compared
     * @param list2: List 2 to be compared
     * @return True if the same, False otherwise
     */
    public static boolean listsEqual(LinkedList<Person> list1, LinkedList<Person> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).compareTo(list2.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void twoArgumentTest() throws IOException {
        String[] args = {"TextFiles/perfectlyFineFile.txt", "123"};
        MainClass.main(args);
        File toCheck = new File("TextFiles/perfectlyFineFile-sorted.txt");
        assert !toCheck.exists();
    }

    @Test
    public void invalidNameTest() throws IOException {
        String[] args = {"TextFiles/invalidName.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/invalidName-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/invalidName-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void mixOfUpperLowerCaseTest() throws IOException {
        String[] args = {"TextFiles/mixOfUpperLowerCase.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/mixOfUpperLowerCase-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/mixOfUpperLowerCase-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void emptyTest() throws IOException {
        String[] args = {"TextFiles/empty.txt"};
        MainClass.main(args);
        File toCheck = new File("TextFiles/empty-sorted.txt");
        assert !toCheck.exists();
    }

    @Test
    public void namesWithGapsTest() throws IOException {
        String[] args = {"TextFiles/namesWithGaps.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/namesWithGaps-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/namesWithGaps-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void simpleTest() throws IOException {
        String[] args = {"TextFiles/twoNames.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/twoNames-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/twoNames-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void largerTest() throws IOException {
        String[] args = {"TextFiles/largeSet.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/largeSet-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/largeSet-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void sameLastNameTest() throws IOException {
        String[] args = {"TextFiles/sameLastName.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/sameLastName-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/sameLastName-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void sameFirstNameTest() throws IOException {
        String[] args = {"TextFiles/sameFirstName.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/sameFirstName-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/sameFirstName-correct.txt"));
        assert listsEqual(sorted, correct);
    }

    @Test
    public void reallySimilarNamesTest() throws IOException {
        String[] args = {"TextFiles/reallySimilarNames.txt"};
        MainClass.main(args);
        LinkedList<Person> sorted = MainClass.extractNames(MainClass.getBuffReader("TextFiles/reallySimilarNames-sorted.txt"));
        LinkedList<Person> correct = MainClass.extractNames(MainClass.getBuffReader("TextFiles/reallySimilarNames-correct.txt"));
        assert listsEqual(sorted, correct);
    }
}
