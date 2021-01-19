package sortalgorithms;


import java.util.Arrays;

public class SortAlgorithms {
    public static void main(String[] args) {
        int size = 10000;
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * size);
        }
        System.out.println("Original Array: " + Arrays.toString(array));


        //Bubble Sort
        int[] bubbleArray = Arrays.copyOf(array, array.length);
        long timeBeforeBubble = System.currentTimeMillis();
        bubbleSort(bubbleArray);
        System.out.println("Bubble sort: \n" + Arrays.toString(bubbleArray));
        long timeAfterBubble = System.currentTimeMillis();

        //Selection Sort
        int[] selectionArray = Arrays.copyOf(array, array.length);
        long timeBeforeSelection = System.currentTimeMillis();
        selectionSort(selectionArray);
        System.out.println("Selection sort: \n" + Arrays.toString(selectionArray));
        long timeAfterSelection = System.currentTimeMillis();

        //Insertion Sort
        int[] insertionArray = Arrays.copyOf(array, array.length);
        long timeBeforeInsertion = System.currentTimeMillis();
        insertionSort(insertionArray);
        System.out.println("Insertion sort: \n" + Arrays.toString(insertionArray));
        long timeAfterInsertion = System.currentTimeMillis();

        //Shuffle Sort
        int[] shuttleArray = Arrays.copyOf(array, array.length);
        long timeBeforeShuttle = System.currentTimeMillis();
        shuttleSort(shuttleArray);
        System.out.println("Shuttle sort: \n" + Arrays.toString(shuttleArray));
        long timeAfterShuttle = System.currentTimeMillis();

        //ShellBad Sort
        int[] shellBadArray = Arrays.copyOf(array, array.length);
        long timeBeforeShell = System.currentTimeMillis();
        shellSortBad(shellBadArray);
        System.out.println("ShellBad sort: \n" + Arrays.toString(shellBadArray));
        long timeAfterShell = System.currentTimeMillis();

        //ShellGood Sort
        int[] shellGoodArray = Arrays.copyOf(array, array.length);
        long timeBeforeShellGood = System.currentTimeMillis();
        shellSortGood(shellGoodArray);
        System.out.println("ShellGood sort: \n" + Arrays.toString(shellGoodArray));
        long timeAfterShellGood = System.currentTimeMillis();


        //Merge Sort
        int[] mergeArray = Arrays.copyOf(array, array.length);
        long timeBeforeMerge = System.currentTimeMillis();
        mergeSort(mergeArray, mergeArray.length);
        System.out.println("Merge sort: \n" + Arrays.toString(mergeArray));
        long timeAfterMerge = System.currentTimeMillis();

        //Quick Sort
        int[] quickArray = Arrays.copyOf(array, array.length);
        long timeBeforeQuick = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("Quick sort: \n" + Arrays.toString(quickArray));
        long timeAfterQuick = System.currentTimeMillis();

        System.out.println("\n------Simple sort algorithms-------");
        System.out.println("Bubble sort time: " + (timeAfterBubble - timeBeforeBubble) + " ms");
        System.out.println("Selection sort time: " + (timeAfterSelection - timeBeforeSelection) + " ms");
        System.out.println("Insertion sort time: " + (timeAfterInsertion - timeBeforeInsertion) + " ms");
        System.out.println("Shuttle sort time: " + (timeAfterShuttle - timeBeforeShuttle) + " ms");
        System.out.println("ShellBad sort time: " + (timeAfterShell - timeBeforeShell) + " ms");
        System.out.println("ShellGood sort time: " + (timeAfterShellGood - timeBeforeShellGood) + " ms");

        System.out.println("\n------Medium sort algorithms-------");
        System.out.println("Merge sort time: " + (timeAfterMerge - timeBeforeMerge) + " ms");
        System.out.println("Quick sort time: " + (timeAfterQuick - timeBeforeQuick) + " ms");

    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

//    ----------------------------- Simple Sort ----------------------------------------

    /**
     * O(n^2)
     * Элемент "всплывает" вправо.
     * <p>
     * Вероятно, пузырьковую сортировку лучше не использовать, разве что если под
     * рукой у вас не оказалось описаний алгоритмов. Пузырьковая сортировка настолько
     * проста, что ее вполне можно написать «по памяти»
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastSorted = array.length;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < lastSorted; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    isSorted = false;
                }
            }
            lastSorted--;
        }
    }

    /**
     * O(n^2) но быстрее пузырька
     * В сортировке методом выбора вы последовательно перебираете всех игроков
     * и выбираете (отсюда и название) самого низкорослого из них.
     * <p>
     * Данная сортировка неустойчива, т.к. одинаковые элементы (с точки зрения той характеристики,
     * по которой мы сортируем элементы) могут изменить своё положение.
     * Алгоритм должен сохранить исходный порядок следования элементов.
     * <p>
     * Сортировка методом выбора сводит к минимуму количество перестановок, но
     * количество сравнений все равно остается высоким. Такая сортировка может
     * пригодиться, если объем данных относительно невелик, а перестановка выполняется
     * намного медленнее сравнения.
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            // save this element
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    // if there is element smaller than min, rewrite min
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
    }

    /**
     * O(n^2) быстрее пузырька и немного быстрее выбора
     * Данная сортировка является "устойчивой". Это значит, что одинаковые элементы не изменят свой порядок.
     * Одинаковые с точки зрения характеристики, по которой мы сортируем.
     * <p>
     * Сортировка методом вставки — самый универсальный алгоритм среди тех описанных.
     * Он лучше всего подойдет в большинстве ситуаций, когда объем данных
     * невелик или данные почти отсортированы.
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int left = 1; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }

    /**
     * O(n^2)
     * Суть алгоритма в том, что мы итерируемся слева направо, при этом при выполнении swap элементов
     * мы выполняем проверку всех остальных элементов, которые остались позади, не нужно ли повторить swap.
     *
     * @param array
     */
    public static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swap(array, z, z - 1);
                    } else break;
                }
            }
        }
    }

    /**
     * O(n^2)
     * Суть её похожа на сортировку пузырьком, но каждую итерацию мы имеем разный промежуток
     * между сравниваемыми элементами. Здесь каждую итерацию он уменьшается вдвое.
     * Почему плохой?
     * тут внешний цикл for на первом проходе пройдет полмассива, а должен только 2 или 3 элемента взять.
     * Суть алгоритма в том, что сортировка вставками работает очень быстро на частично отсортированном массиве.
     * Поэтому перед тем как прогнать сортировку вставками по всему массиву делается несколько итераций
     * по небольшим подмассивам, состоящим из элементов массива, отстоящим друг от друга на величину gap.
     *
     * @param array
     */
    public static void shellSortBad(int[] array) {
        int h = 1;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int right = 0; right < array.length; right++) {
                // Смещаем правый указатель, пока не сможем найти такой, что
                // между ним и элементом до него не будет нужного промежутка
                for (int c = right - h; c >= 0; c -= h) {
                    if (array[c] > array[c + h]) {
                        swap(array, c, c + h);
                    }
                }
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * O(n log n)
     * Почему сортировка Шелла работает быстрее сортировки методом вставки, на
     * которой она базируется? При больших значениях h количество элементов на один
     * проход невелико, а элементы перемещаются на большие расстояния. С уменьшением h
     * количество элементов на каждую итерацию возрастает, но и элементы
     * находятся ближе к своим конечным позициям в порядке сортировки, поэтому
     * алгоритм по эффективности превосходит сортировку методом вставки. Сочетание
     * этих особенностей делает сортировку такой эффективной.
     *
     * @param array
     */
    public static void shellSortGood(int[] array) {
        int inner, outer;
        int temp;
        int h = 1;

        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }


//    ----------------------------- Medium Sorts ----------------------------------------

//    -----------------------------  MergeSort ----------------------------------------

    /**
     * O(nLogn)
     * mergeSort - разделение неотсортированного массива на две части
     * и сортировка отдельных половинок по рекурсивному принципу.
     *
     * @param array
     * @param size
     */
    public static void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        // here we create the pivot - midpoint
        int mid = size / 2;
        // divide our array into two temporary halves
        int[] leftArray = new int[mid];
        int[] rightArray = new int[size - mid];
        //fill them
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < size; i++) {
            rightArray[i - mid] = array[i];
        }

        mergeSort(leftArray, mid);
        mergeSort(rightArray, size - mid);
        merge(array, leftArray, rightArray, mid, size - mid);

    }

    /**
     * Сравнивает элементы обоих подмассивов один за другим и вставлеяет меньший из них в результирующий массив.
     *
     * @param array
     * @param leftArray
     * @param rightArray
     * @param left
     * @param right
     */
    public static void merge(int[] array, int[] leftArray, int[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;
        // if each array isn't empty
        while (i < left && j < right) {
            //In this step, we sort and merge the divided arrays from bottom to top and get the sorted array.
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        // if one of them is empty
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

//    -----------------------------  QuickSort ----------------------------------------

    /**
     * O(nLogn)
     * Алгоритм быстрой сортировки Хоара основан на механизме разбиения.
     * Учтите, что разбиение не обладает свойством устойчивости.
     * Удачность зависит от выбора порогового значения.
     *
     * @param array
     * @param leftBorder
     * @param rightBorder
     */
    public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];

        //partition of the array
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    swap(array, leftMarker, rightMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightBorder) {
            quickSort(array, leftBorder, rightMarker);
        }

    }

}