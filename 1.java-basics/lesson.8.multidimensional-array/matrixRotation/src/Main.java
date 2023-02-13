import ru.maki.Matrix;

public class Main {
    public static void main(String[] args) {
//        int[][] testMatrix = new int[][]{{114, 112, 148, 83, 204, 22, 125, 31}
//                , {192, 231, 245, 128, 63, 246, 139, 17}
//                , {61, 128, 224, 45, 91, 57, 239, 34}
//                , {219, 237, 167, 191, 236, 146, 144, 117}
//                , {35, 199, 102, 124, 208, 195, 21, 147}
//                , {52, 229, 126, 32, 24, 145, 19, 39}
//                , {107, 43, 190, 43, 47, 172, 18, 19}
//                , {62, 221, 6, 208, 241, 198, 187, 85}};
//        Matrix matrix = new Matrix(testMatrix);

        System.out.println("..было..");
        Matrix matrix = new Matrix(14, 3, 255);
        matrix.showMatrix();

        int[][] newMatrix = matrix.rotate(90);

        System.out.println("..стало..");
        matrix.showMatrix(newMatrix);
    }
}