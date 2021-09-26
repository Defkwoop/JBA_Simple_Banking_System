class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        System.out.print(twoDimArray[0][0] + " ");
        System.out.println(twoDimArray[0][(twoDimArray[0].length - 1)]);
        System.out.print(twoDimArray[twoDimArray.length - 1][0] + " ");
        System.out.println(twoDimArray[twoDimArray.length - 1] [(twoDimArray[0].length - 1)]);

    }
}

//class ArrayOperations {
//    public static void printCorners(int[][] twoDimArray) {
//        int maxI = twoDimArray.length - 1;
//        int maxJ = twoDimArray[0].length - 1)]
//
//        System.out.print(twoDimArray[0][0] + " ");
//        System.out.println(twoDimArray[0][maxJ]);
//        System.out.print(twoDimArray[maxI][0] + " ");
//        System.out.println(twoDimArray[maxI][maxJ]);
//    }
//}