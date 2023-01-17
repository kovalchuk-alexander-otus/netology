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
        int i_t = 0;
        int i_r = 0;
        int i_nt = 0;
        int[] result = new int[10];
        while (i_t < team.length && i_nt < nextTeam.length && i_r < result.length) {
            if (team[i_t] > nextTeam[i_nt]) {
                result[i_r] = team[i_t];
                i_t += 1;
            } else {
                result[i_r] = nextTeam[i_nt];
                i_nt += 1;
            }
            i_r += 1;
        }
        return Arrays.copyOf(result, 10);
    }
}