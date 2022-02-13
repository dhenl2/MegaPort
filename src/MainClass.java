import java.io.*;
import java.util.LinkedList;

/**
 * Main Class for this assignment
 */
public class MainClass {

    /**
     * Extracts the names from the given BufferedReader
     * @param reader: BufferedReader to be read from
     * @return List of names taken from the given reader
     */
    public static LinkedList<Person> extractNames(BufferedReader reader) throws IOException {
        LinkedList<Person> names = new LinkedList<>();
        while (reader.ready()) {
            String line = reader.readLine();
            if (line.equals("")) {
                continue;
            }
            String[] split = line.split(",");
            if (split.length != 2 || split[0].equals("") || split[1].equals("")) {
                // invalid name not of format lastname, firstname
                continue;
            }
            Person person = new Person(split[0], split[1]);
            names.add(person);
        }
        reader.close();
        return names;
    }

    /**
     * Gets a BufferedReader from the given filename. Checks if the file exists. If not, a message is created and the
     * program exits.
     * @param filename: File to be read
     * @return BufferedReader of given filename
     */
    public static BufferedReader getBuffReader(String filename) {
        try {
            FileReader file = new FileReader(filename);
            return new BufferedReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return null;
    }

    /**
     * Merge sort algorithm to sort a list of Persons
     * @param persons: Persons to be sorted
     * @return Sorted list of Persons
     */
    public static LinkedList<Person> mergeSort(LinkedList<Person> persons) {
        if (persons.size() < 2) {
            return persons;
        }
        int mid = persons.size() / 2;
        LinkedList<Person> left = new LinkedList<>();
        LinkedList<Person> right = new LinkedList<>();
        // split list into left and right
        for (int i = 0; i < mid; i++) {
            left.add(persons.get(i));
        }
        for (int i = mid; i < persons.size(); i++) {
            right.add(persons.get(i));
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    /**
     * Merges the two lists of Persons given
     * @param left: A list of Persons
     * @param right: A list of Persons
     * @return A merged and sorted list of the two lists given
     */
    public static LinkedList<Person> merge(LinkedList<Person> left, LinkedList<Person> right) {
        int l = 0, r = 0;
        LinkedList<Person> merged = new LinkedList<>();
        while (l < left.size() && r < right.size()) {
            if (left.get(l).compareTo(right.get(r)) <= 0) {
                // left before right
                merged.add(left.get(l++));
            } else {
                // right before left
                merged.add(right.get(r++));
            }
        }

        // add remaining in either list
        while (l < left.size()) {
            merged.add(left.get(l++));
        }
        while (r < right.size()) {
            merged.add(right.get(r++));
        }

        return merged;
    }

    /**
     * Writes the given list of names to the given filename.
     * @param sorted: A list of sorted names
     * @param filename: The filename to extend from as <filename>-sorted.txt
     */
    public static void writeSortedNames(LinkedList<Person> sorted, String filename) throws IOException {
        if (filename.contains("\\")) {
            // trim from \
            String[] split = filename.split("\\\\");
            // grab last object in path
            filename = split[split.length - 1];
        }
        filename = filename.substring(0, filename.indexOf("."));
        String newFileName = String.format("%s-sorted.txt", filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
        for (Person person : sorted) {
            writer.write(String.format("%s\n", person.toString()));
        }
        writer.close();
        System.out.printf("Finished: created %s%n", newFileName);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Expected 1 argument. This should be the filepath to the file containing" +
                    " names to be sorted");
            return;
        }

        String filename = args[0];
        BufferedReader buffReader = getBuffReader(filename);
        if (buffReader == null) {
            return;
        }
        LinkedList<Person> names = extractNames(buffReader);
        if (names.size() == 0) {
            System.out.println("No names found in file " + filename);
            return;
        }
        LinkedList<Person> merged = mergeSort(names);
        writeSortedNames(merged, filename);
    }
}
