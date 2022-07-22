import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class encapsulates the Turnitin test coding implementation.
 *
 * To run this class:
 *
 * 1) Open a command shell.
 * 2) Place this file in a directory of your choice.
 * 3) Change directory to your directory of choice.
 * 4) Compile this class thus:
 *
 *    javac TurnitinTest.java
 * 
 * 5) Execute this class, providing a sentence as separate words on the command line. Example:
 *
 *    java -cp . TurnitinTest the cat is in the bag
 *
 * 6) Output is to the console.
 *
 * 7) Prerequisites:
 *    Java installation bin directory is on the Path
 *
 */
public class TurnitinTest {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No sentence provided.");
            System.exit(-1);
		}
		
		TurnitinTest test = new TurnitinTest();
		
		test.countAndSortWordFrequencyTest(args);
		
	}
	
    public TurnitinTest() {


    }

    public void countAndSortWordFrequencyTest(String[] sentence) {

        List<String> wordList = Arrays.asList(sentence);

        Map<String,Long> wordMap = wordList.stream()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        }));

        wordMap.entrySet().forEach(e -> {
            System.out.println(e.getValue() + " " + e.getKey());
        });
    }
}
