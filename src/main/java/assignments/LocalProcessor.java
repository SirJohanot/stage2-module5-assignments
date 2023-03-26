package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {

    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueOfCheap;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringList.stream()
                .map(Objects::hashCode)
                .forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullProcessorNameGenerator(List<String> stringList) {
        processorName += String.join(" ", stringList);
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        Scanner informationscanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder(processorVersion);
        while (informationscanner.hasNext()) {
            stringBuilder.append(informationscanner.nextLine());
        }
        processorVersion = stringBuilder.toString();
    }
}
