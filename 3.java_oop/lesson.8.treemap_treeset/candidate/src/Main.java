import ru.maki.Candidate;
import ru.maki.CandidateComparator;
import ru.maki.Sex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // вариант с TreeSet
        Set<Candidate> candidates = trySet();

        // вариант с List
        tryList((TreeSet<Candidate>) candidates);
    }

    // вариант с TreeSet
    //   ... т.к. строит уникальность на базе Comparator - то пришлось добавить уникальное поле в сортировку
    //   ... иначе, могли теряться записи
    public static Set<Candidate> trySet() {

        Set<Candidate> candidates =
                new TreeSet<>(Comparator.comparing(Candidate::getRelevance, Comparator.reverseOrder())
                        .thenComparing(Candidate::getRating, Comparator.reverseOrder()).thenComparing(Candidate::getFullName));

        candidates.add(new Candidate("Ковальчук", "Александр", "Михайлович", Sex.MALE, 43, 5, 5));
        candidates.add(new Candidate("Петров", "Владислав", "Иванович", Sex.MALE, 34, 1, 5));
        candidates.add(new Candidate("Бабкин", "Илья", "Олегович", Sex.MALE, 56, 4, 5));
        candidates.add(new Candidate("Ряполов", "Олег", "Игоревич", Sex.MALE, 23, 3, 5));
        candidates.add(new Candidate("Андреев", "Семен", "Моисеевич", Sex.MALE, 41, 2, 5));
        candidates.add(new Candidate("Губанов", "Вячеслав", "Сергеевич", Sex.MALE, 39, 5, 4));
        candidates.add(new Candidate("Мармеладов", "Леонид", "Артемович", Sex.MALE, 39, 5, 5));
        candidates.add(new Candidate("Газманов", "Иннокентий", "Павлович", Sex.MALE, 39, 5, 4));
        candidates.add(new Candidate("Глазунов", "Илья", "Афанасьевич", Sex.MALE, 39, 4, 4));
        candidates.add(new Candidate("Петропавлов", "Никанор", "Гуторович", Sex.MALE, 39, 4, 2));
        candidates.add(new Candidate("Герцен", "Литий", "Петрович", Sex.MALE, 39, 4, 5));
        candidates.add(new Candidate("Муромский", "Игнатий", "Львович", Sex.MALE, 39, 5, 2));

        System.out.println("\n\nTreeSet - отсортировали по релевантности и рейтингу\n");
        System.out.println(candidates);
        return candidates;
    }

    // вариант с List
    //  ... тут потребуется описать класс, реализующий Comparator
    public static void tryList(TreeSet<Candidate> setCandidates) {

        List<Candidate> candidates = new ArrayList<>();
        NavigableSet<Candidate> newSet = setCandidates.descendingSet();

        candidates.addAll(newSet);

        System.out.println("\n\nзалили TreeSet в NavigableSet, отсортировали в обратном порядке и залили в ArrayList\n");
        System.out.println(candidates);

        candidates.sort(new CandidateComparator());

        System.out.println("\n\nArrayList - отсортировали по релевантности и рейтингу\n");
        System.out.println(candidates);
    }

}