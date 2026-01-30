public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int [] list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();

        steps = 0;
        for (int outer = 0; outer < list.length - 1; outer++){
            for (int inner = 0; inner < list.length-outer-1; inner++){
                steps += 3;//count one compare and 2 gets
                if (list[inner]>(list[inner + 1])){
                    steps += 4;//count 2 gets and 2 sets
                    int temp = list[inner];
                    list[inner] = list[inner + 1];
                    list[inner + 1] = temp;
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int [] list){
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
      
        steps = 0;
        for (int outer = 0; outer < list.length - 1; outer++){
            int minIndex = outer;
            for (int inner = outer + 1; inner < list.length; inner++){
                // count one compare and two gets
                steps += 3;
                if (list[inner] < list[minIndex]){
                    minIndex = inner;
                }
            }
            if (minIndex != outer){
                // count two gets and two sets for the swap
                steps += 4;
                int temp = list[outer];
                list[outer] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int [] list){
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        steps = 0;
        for (int i = 1; i < list.length; i++){
            // get key from array
            int key = list[i];
            steps += 1; // one get for key
            int j = i - 1;

            // shift elements of the sorted segment forward if they are larger than key
            while (j >= 0){
                // one compare and one get of list[j]
                steps += 2;
                if (list[j] > key){
                    // move element one position to the right (one get + one set)
                    steps += 2;
                    list[j + 1] = list[j];
                    j--;
                } else {
                    break;
                }
            }
            // place key into its correct position (one set)
            steps += 1;
            list[j + 1] = key;
        }

    }

     /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void mergeSort(int [] list, int n){
        //replace these lines with your code
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = list[i];
            // count one get and one set for copying into l
            steps += 2;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = list[i];
            // count one get and one set for copying into r
            steps += 2;
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(list, l, r, mid, n - mid);
    }

        public void merge(int[] a, int[] l, int[] r, int left, int right) {
            int i = 0, j = 0, k = 0;
            while (i < left && j < right) {
                // count one compare and two gets for l[i] and r[j]
                steps += 3;
                if (l[i] <= r[j])
                {
                    // one get and one set for the copy into a
                    steps += 2;
                    a[k++] = l[i++];
                }
                else
                {
                    // one get and one set for the copy into a
                    steps += 2;
                    a[k++] = r[j++];
                }
            }
        
            while (i < left)
            {
                // one get and one set for remaining elements from l
                steps += 2;
                a[k++] = l[i++];
            }
            while (j < right)
            {
                // one get and one set for remaining elements from r
                steps += 2;
                a[k++] = r[j++];
            }
        }    
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}
