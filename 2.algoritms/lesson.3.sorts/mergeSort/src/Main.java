import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] national_team;
        int[][] regional_teams = new int[3][10];

        regional_teams[0] = new int[]{45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        regional_teams[1] = new int[]{31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        regional_teams[2] = new int[]{51, 30, 10, 9, 8, 7, 6, 5, 2, 1};

        national_team = regional_teams[0];
        for (int i = 1; i < regional_teams.length; i++) {
            national_team = merge(national_team, regional_teams[i]);
        }
        System.out.println(Arrays.toString(national_team));
    }

    public static int[] merge(int[] team, int[] nextTeam) {
        int iTeam = 0;
        int iResult = 0;
        int iNationalTeam = 0;
        int[] result = new int[10];
        while (iTeam < team.length && iNationalTeam < nextTeam.length && iResult < result.length) {
            if (team[iTeam] > nextTeam[iNationalTeam]) {
                result[iResult] = team[iTeam];
                iTeam += 1;
            } else {
                result[iResult] = nextTeam[iNationalTeam];
                iNationalTeam += 1;
            }
            iResult += 1;
        }
        return Arrays.copyOf(result, 10);
    }
}