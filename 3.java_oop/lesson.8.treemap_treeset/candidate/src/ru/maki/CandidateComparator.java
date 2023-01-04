package ru.maki;

import java.util.Comparator;

public class CandidateComparator implements Comparator<Candidate> {
    @Override
    public int compare(Candidate o1, Candidate o2) {
        int retVal = Integer.compare(o2.getRelevance(), o1.getRelevance());
        if (retVal == 0) return Integer.compare(o2.getRating(), o1.getRating());
        else return retVal;
    }
}
