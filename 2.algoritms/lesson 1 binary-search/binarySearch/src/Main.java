import ru.maki.BinarySearch;

public class Main {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.setShowOnlyError(true);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72}, 32);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 32, 56, 69, 72}, 32);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72}, 33);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 32, 56, 69, 72}, 33);
//        binarySearch.debug(new int[]{14, 16, 32, 32, 32, 32, 56, 69, 72}, 31);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 32, 56, 69, 72}, 31);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72}, 31);
//        binarySearch.debug(new int[]{14, 16, 19, 32, 32, 32, 32, 56, 69, 72}, 31);
//        binarySearch.debug(new int[]{17, 21, 21, 32, 37, 42, 43, 49, 69, 73}, 73);
//        binarySearch.debug(new int[]{29, 51, 69, 77, 90, 104, 114, 132, 154, 163, 177, 185, 202, 216, 218, 231, 253, 264, 283, 306, 311, 332, 344, 346, 365, 388, 390, 413, 428, 450}, 483);
//        binarySearch.debug(new int[]{29, 42, 46, 53, 58, 79, 80, 81, 99, 101, 115, 118, 121, 144, 151, 163, 165, 186, 201, 219, 236, 257, 275, 292, 314, 336, 345, 348, 361, 372}, 276);
//        binarySearch.debug(new int[]{29, 38, 62, 72, 78, 98, 116, 124, 135, 157, 157, 169, 191, 192, 214, 234, 251, 254, 260, 277, 294, 308, 323, 326, 344, 352, 366, 379, 392, 413}, 129);
//        binarySearch.debug(new int[]{31, 35, 48, 67, 91, 111, 129, 142, 154, 172}, 159);
//        binarySearch.debug(new int[]{13, 36, 54, 64, 72, 74, 76, 95, 107, 112}, 24);
//        binarySearch.debug(new int[]{16, 40, 40, 62, 73, 91, 104, 127, 144, 154}, 66);
//        binarySearch.debug(new int[] {21, 30, 34, 38, 59, 73, 92, 110, 113, 120, 133, 141, 163, 172, 180, 180, 188, 200, 218, 218, 221, 239, 252, 267, 283, 298, 311, 324, 329, 343, 359, 375, 390, 406, 430, 450, 460, 469, 490, 494, 500, 503, 521, 543, 554, 570, 576, 582, 589, 611, 623}, 11);
        for (int i = 0; i < 99; i++) {
            binarySearch.demo(10);
        }
        for (int i = 0; i < 99; i++) {
            binarySearch.demo(11);
        }
    }


}