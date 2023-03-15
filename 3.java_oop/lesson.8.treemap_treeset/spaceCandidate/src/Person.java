class Person {
    private final String name;
    private final int age;
    private final int experience;

    public Person(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return name;
    }
}