import ru.maki.Candidate;
import ru.maki.CandidateComparator;
import ru.maki.Sex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // вариант с TreeSet
        trySet();

        // вариант с List
        tryList();
    }

    // вариант с List
    //  ... тут потребуется описать класс, реализующий Comparator
    public static void tryList(){
        List<Candidate> candidates = new ArrayList<>();

        candidates.add(new Candidate("Ковальчук", "Александр","Михайлович", Sex.MALE, 43
                , 5, 5));
        candidates.add(new Candidate("Петров", "Владислав","Иванович", Sex.MALE, 34
                , 1, 5));
        candidates.add(new Candidate("Бабкин", "Илья","Олегович", Sex.MALE, 56
                , 4, 5));
        candidates.add(new Candidate("Ряполов", "Олег","Игоревич", Sex.MALE, 23
                , 3, 5));
        candidates.add(new Candidate("Андреев", "Семен","Моисеевич", Sex.MALE, 41
                , 2, 5));
        candidates.add(new Candidate("Губанов", "Вячеслав","Сергеевич", Sex.FEMALE, 39
                , 5, 4));
        candidates.add(new Candidate("Мармеладов", "Леонид","Артемович", Sex.MALE, 39
                , 5, 5));
        candidates.add(new Candidate("Газманов", "Иннокентий","Павлович", Sex.MALE, 39
                , 5, 4));

        // System.out.println(candidates);

        candidates.sort(new CandidateComparator());

        System.out.println(candidates);
    }

    // вариант с TreeSet
    //   ... т.к. строит уникальность на базе Comparator - то пришлось добавить уникальное поле в сортировку
    //   ... иначе, могли теряться записи
    public static void trySet(){

        Set<Candidate> candidates =
                new TreeSet<>(Comparator.comparing(Candidate::getRelevance, Comparator.reverseOrder())
                        .thenComparing(Candidate::getRating, Comparator.reverseOrder()).thenComparing(Candidate::getFullName));

        candidates.add(new Candidate("Ковальчук", "Александр","Михайлович", Sex.MALE, 43
                , 5, 5));
        candidates.add(new Candidate("Петров", "Владислав","Иванович", Sex.MALE, 34
                , 1, 5));
        candidates.add(new Candidate("Бабкин", "Илья","Олегович", Sex.MALE, 56
                , 4, 5));
        candidates.add(new Candidate("Ряполов", "Олег","Игоревич", Sex.MALE, 23
                , 3, 5));
        candidates.add(new Candidate("Андреев", "Семен","Моисеевич", Sex.MALE, 41
                , 2, 5));
        candidates.add(new Candidate("Губанов", "Вячеслав","Сергеевич", Sex.MALE, 39
                , 5, 4));
        candidates.add(new Candidate("Мармеладов", "Леонид","Артемович", Sex.MALE, 39
                , 5, 5));
        candidates.add(new Candidate("Газманов", "Иннокентий","Павлович", Sex.MALE, 39
                , 5, 4));

        System.out.println(candidates);
    }

}