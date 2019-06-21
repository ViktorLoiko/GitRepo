public class BinTree {

    private int indexStorage = 14;

    private Integer[] mas = {111, 81, 247, 42, 82, 134, 435, 15, 52, null, 83, 127, 211, 393, 450,};


    public void insert(Integer key) {

        int index = 0;
        while (true) {

            if (mas[index] == null) {
                mas[index] = key;
                break;
            }

            if (key > mas[index]) {

                if ((2 * index + 2) < indexStorage) {

                    index = 2 * index + 2;

                } else break;


            } else if (key < mas[index]) {

                if ((2 * index + 1) < indexStorage) {

                    index = 2 * index + 1;

                } else break;

            } else break;

        }

    }

    public void insertPosition(Integer key, int position) {

        int x = position;

        if (key != null) {


            while (true) {


                if (mas[x] == null) {
                    mas[x] = key;
                    break;
                }

                if (key > mas[x]) {

                    if ((2 * x + 2) < indexStorage) {

                        x = 2 * x + 2;

                    } else break;


                } else if (key < mas[x]) {

                    if ((2 * x + 1) < indexStorage) {

                        x = 2 * x + 1;

                    } else break;

                } else break;

            }
        }
    }

    public void printKey() {

        for (int i = 0; i < mas.length; i++) {

            System.out.print(mas[i] + " ");

        }

    }

    public boolean findKey(int key) {


        boolean mark = true;
        int x = 0;

        while (mark) {

            if (mas[x] == null) {
                return false;
            } else if (key >= mas[x]) {


                if (key == mas[x]) {
                    return true;

                } else if ((2 * x + 2) < indexStorage)
                    x = 2 * x + 2;

                else return false;

            } else if (key < mas[x]) {

                if (mas[x] == key)
                    return true;

                else if ((2 * x + 1) < indexStorage)
                    x = 2 * x + 1;

                else return false;


            }
        }

        return false;
    }

    public void maxKey() {

        int x = 0;
        int max = mas[0];

        while (true) {

            if (mas[x] == null) {
                break;

            } else if (mas[x] >= max) {

                max = mas[x];
                if ((2 * x + 2) > indexStorage)
                    break;
                else x = 2 * x + 2;

            }
        }


        System.out.println("Max-" + max);

    }

    public int maxKeyIndex() {

        int x = 0;
        int max = 0;

        while (true) {

            if (mas[x] == null) {
                break;

            } else if (mas[x] >= max) {

                max = x;
                if ((2 * x + 2) > indexStorage)
                    break;
                else x = 2 * x + 2;

            }
        }
        return max;
    }

    public void minKey() {

        int x = 0;
        int min = mas[0];

        while (true) {

            if (mas[x] == null) {
                break;

            } else if (mas[x] <= min) {

                min = mas[x];
                if ((2 * x + 1) > indexStorage)
                    break;
                else x = 2 * x + 1;

            } else break;
        }


        System.out.println("Min-" + min);
    }

    public Integer nextKey(int key) {
        int x = 0;

        while (true) {

            if (mas[x] == null) {
                return null;
            } else if (key >= mas[x]) {


                if (key == mas[x]) {
                    if ((2 * x + 2) < indexStorage)
                        return mas[2 * x + 2];
                    else return null;

                } else if ((2 * x + 2) < indexStorage)
                    x = 2 * x + 2;

                else return null;

            } else if (key < mas[x]) {

                if (key == mas[x]) {
                    if ((2 * x + 1) < indexStorage)
                        return mas[2 * x + 1];

                } else if ((2 * x + 1) < indexStorage) {
                    x = 2 * x + 1;

                } else return null;
            } else return null;
        }

    }

    public Integer prevKey(int key) {

        int indexPrev = 0;
        int x = 0;

        while (true) {

            if (mas[x] == null) {
                return null;
            } else if (key >= mas[x]) {


                if (key == mas[x]) {
                    if (((x - 1) / 2) >= indexPrev)
                        return mas[(x - 1) / 2];
                    else return null;

                } else if ((2 * x + 2) < indexStorage)
                    x = 2 * x + 2;

                else return null;

            } else if (key < mas[x]) {

                if (key == mas[x]) {
                    if (((x - 1) / 2) > indexPrev)
                        return mas[(x - 1) / 2];
                    else return null;

                } else if ((2 * x + 1) < indexStorage) {
                    x = 2 * x + 1;

                } else return null;
            } else return null;
        }
    }

    public Integer successorKey(int key) {

        int x = 0;

        while (true) {

            if (mas[x] == null) {
                return null;
            } else if (key >= mas[x]) {


                if (key == mas[x]) {
                    if ((2 * x + 1) < indexStorage)
                        return mas[(2 * x + 1)];
                    else return null;

                } else if ((2 * x + 2) < indexStorage)
                    x = 2 * x + 2;

                else return null;

            } else if (key < mas[x]) {

                if (key == mas[x]) {
                    if ((2 * x + 1) > indexStorage)
                        return mas[(2 * x) + 1];
                    else return null;

                } else if ((2 * x + 1) < indexStorage) {
                    x = 2 * x + 1;

                } else return null;
            } else return null;
        }

    }

    public Integer minSuccessorKey(int position) {

        int x = 2 * position + 2;
        int min = mas[x];

        while (true) {

            if (mas[x] <= min) {
                min = mas[x];
                if ((2 * x + 1) < indexStorage)
                    x = 2 * x + 1;
                else {
                    mas[x] = null;
                    return min;
                }
            }

        }
    }

    public Integer[] copy(int position) {

        Integer masCopy[] = new Integer[indexStorage];

        masCopy[0] = minSuccessorKey(position);
        mas[position] = null;
        int low = position;
        int hi = position;
        int i = 1;
        int temp;


        while (true) {

            low = 2 * low + 1;
            hi = 2 * hi + 2;
            temp = low;
            if (low > indexStorage - 1) {
                return masCopy;
            }
            while (temp <= hi) {

                if (mas[temp] == null)
                    temp++;
                else {
                    masCopy[i] = mas[temp];
                    mas[temp] = null;
                    i++;
                    temp++;
                }
            }

        }


    }

    public boolean deleteKey(int key) {


        int x = 0;
        while (true) {

            if (mas[x] == null) {
                return false;

            } else if (key >= mas[x]) {

                if (key == mas[x]) {

                    if ((2 * x + 2) > indexStorage && (2 * x + 1) >= indexStorage) {

                        mas[x] = null;
                        return true;

                    } else if (mas[2 * x + 2] != null && mas[2 * x + 1] != null) {


                        Integer temp[] = copy(x);
                        for (int i = 0; i < temp.length; i++)
                            insertPosition(temp[i], x);

                        return true;

                    }
                } else if ((2 * x + 2) < indexStorage) {
                    x = 2 * x + 2;


                } else return false;
            } else if (key < mas[x]) {

                if (mas[x] == key) {

                    if ((2 * x + 2) > indexStorage && (2 * x + 1) > indexStorage) {

                        mas[x] = null;
                        return true;

                    }
                } else if ((2 * x + 1) < indexStorage)
                    x = 2 * x + 1;

                else return false;


            }


        }
    }

    public void binaryMaxHeap() {
        int left, right;
        int temp;

        for (int i = 0; i < mas.length; i++) {

            left = 2 * i + 1;
            right = 2 * i + 2;
            while (true) {
                if (left < mas.length && mas[left] != null) {
                    if (mas[i] < mas[left]) {
                        temp = mas[i];
                        mas[i] = mas[left];
                        mas[left] = temp;
                        left = 2 * left + 1;

                    }
                } else break;
                if (right < mas.length && mas[right] != null) {
                    if (mas[i] < mas[right]) {
                        temp = mas[i];
                        mas[i] = mas[right];
                        mas[right] = temp;
                        right = 2 * right + 2;
                    }
                } else break;
            }
        }
    }


    public static void main(String[] args) {


        BinTree tree = new BinTree();

        tree.printKey();
        System.out.println();
        System.out.println(tree.findKey(247));
        tree.maxKey();
        tree.minKey();
        System.out.println("NextKey -" + tree.nextKey(42));
        System.out.println("PrevKey -" + tree.prevKey(82));
        System.out.println("SuccesoKey-" + tree.successorKey(42));

        tree.deleteKey(42);

        tree.printKey();

        tree.binaryMaxHeap();
        System.out.println();
        tree.printKey();


    }


}