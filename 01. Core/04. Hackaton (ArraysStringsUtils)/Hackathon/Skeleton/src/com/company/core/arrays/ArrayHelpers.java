public class ArrayHelpers {

    public static int[] add(int[] source, int element) {
        //Michaela Kostova
        int newLenght = source.length + 1;
        int[] result = new int[newLenght];
        for (int i = 0; i < newLenght - 1; i++) {
            result[i] = source[i];
        }
        result[newLenght - 1] = element;
        return result;
    }

    public static int[] addFirst(int[] source, int element) {
        int[] result = new int[source.length + 1];

        result[0] = element;

        for (int i = 1; i < result.length; i++) {
            result[i] = source[i - 1];
        }

        return result;
    }

    public static int[] addAll(int[] source, int... elements) {

        int[] result = new int[source.length + elements.length];
        int i = 0;
        for (
                int element : source) {
            result[i++] = element;
        }
        for (
                int element : elements) {
            result[i++] = element;
        }
        return result;
    }

    public static boolean contains(int[] source, int element) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == element) {
                return true;
            }

        }

        return false;
    }

    public static void copy(int[] sourceArray, int[] destinationArray, int count) {
        for (int i = 0; i < count; i++) {
            destinationArray[i] = sourceArray[i];
        }
    }

    public static void copyFrom(int[] sourceArray, int sourceStartIndex,
                                int[] destinationArray, int destStartIndex, int count) {
        for (int i = sourceStartIndex; i < count; i++) {
            destinationArray[destStartIndex] = sourceArray[i]
        }
        //Copies elements from sourceArray,
        // starting from sourceStartIndex into destinationArray, starting from destStartIndex, taking count elements.
    }

    public static void fill(int[] source, int element) {
        for (int i = 0; i < source.length; i++) {
            source[i] = element;
        }

    }

    public static int firstIndexOf(int[] source, int target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] insert(int[] source, int index, int element) {
        source[index] = element;
        return source;
    }

    public static boolean isValidIndex(int[] source, int index) {
        if ( index >= 0 && index < source.length();){
            return true;
        }
        return false;
    }

    public static int lastIndexOf(int[] source, int target) {
        for (int i = source.length - 1; i >= 0; i--) {
            if (source[i] == target) {
                return i;
                break;
            }

        }
        return -1;
    }

    public static int[] removeAllOccurrences(int[] source, int element) {
        int current = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] != element) {
                current = ccurrent + 1;
            }
        }
        int[] removed = new int[current];

        int j = 0;

        for (int i = 0; i < source.length; i++) {
            if (source[i] != element) {
                result[j] = source[i];
                j++;
            }
        }
        return removed;
    }

    public static void reverse(int[] arrayToReverse) {
        //Mihaela Kostova
        int length = arrayToReverse.length;
        int[] reversedArray = new int[length];
        int reversedIndex = 0;
        for (int i = length - 1; i >= 0; i--) {
            reversedArray[reversedIndex] = arrayToReverse[i];
            reversedIndex++;
        }
    }

    public static int[] section(int[] source, int start, int end) {

        int all = end - start;

        String arrayStr = "";


        for (int i = start; i < end + 1; i++) {
            arrayStr = arrayStr + source[i] + " ";
        }

        String[] array = arrayStr.split(" ");

        int[] sectioned = new int[array.length];

        for (int i = 0; i < all + 1; i++) {
            sectioned[i] = Integer.parseInt(array[i]);
        }

        return sectioned;

    }
}