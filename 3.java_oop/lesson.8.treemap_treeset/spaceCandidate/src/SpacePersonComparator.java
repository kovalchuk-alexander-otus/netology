import java.util.Comparator;

public class SpacePersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        // тот у кого больше опыта; если опыт одинаковый то
        if (o1.getExperience() == o2.getExperience()) {
            // тот, у кого в имени с фамилией (т.е. name) больше букв s или S (от слова space - космос; было решено, что
            //   медийность - важная часть космонавтики); если по этому критерию оказываются равны, то
            if (getCount(o1.getName(), 's') == getCount(o2.getName(), 's')) {
                // тот, у кого имя с фамилией (т.е. name) короче (так легче будет запоминать имена астронавтов по всему миру)
                return Integer.compare(o1.getName()
                        .length(), o2.getName()
                        .length());
            } else {
                return Integer.compare(getCount(o2.getName(), 's'), getCount(o1.getName(), 's'));
            }
        } else {
            return Integer.compare(o2.getExperience(), o1.getExperience());
        }

    }

    public static int getCount(String text, char symbol) {
        int count = 0;
        for (char c : text.toLowerCase()
                .toCharArray()) {
            count += c == symbol ? 1 : 0;
        }
        return count;
    }
}