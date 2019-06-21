import java.util.LinkedList;
import java.util.List;

public class Vertex {
    private static final int WHITE = 0; //white - color
    private static final int GRAY = 1; //gray - color
    private static final int BLACK = 2; //black - color

    private int colors[] = {0, 0, 0, 0, 0};
    private int vertex[] = {0, 1, 2, 3, 4};

    private final int matrix[][] = {{0, 1, 1, 1, 1},
                                    {1, 0, 1, 0, 0},
                                    {1, 1, 0, 1, 0},
                                    {1, 0, 1, 0, 1},
                                     {1, 0, 0, 1, 0}};

    private int list0[] = {1, 2, 3, 4};
    private int list1[] = {0, 2};
    private int list2[] = {0, 1, 3};
    private int list3[] = {0, 2, 4};
    private int list4[] = {0, 3};

    private List vertexList = new LinkedList();


    public Vertex() {

        vertexList.add(list0);
        vertexList.add(list1);
        vertexList.add(list2);
        vertexList.add(list3);
        vertexList.add(list4);


    }

    public void displayVertexList() {

        for (int s = 0; s < vertexList.size(); s++) {
            int temp[] = (int[]) vertexList.get(s);

            System.out.println();
            System.out.print(s + " ");
            for (int i = 0; i < temp.length; i++) {


                if (i + 1 >= temp.length)
                    System.out.print(temp[i]);
                else
                    System.out.print(temp[i] + "-");

            }

        }
    }

    public void displayMatrixVertex() {

        System.out.print("\t");
        for (int i = 0; i < vertex.length; i++) {

            System.out.print(vertex[i] + "\t");
        }
        System.out.println();
        for (int j = 0; j < matrix.length; j++) {
            System.out.print(vertex[j] + "\t");
            for (int k = 0; k < matrix.length; k++)
                System.out.print(+matrix[j][k] + "\t");
            System.out.println();
        }
    }

    void ScanGraphMatrix(int list_x, int num_count)
    {


        colors[ list_x ] = GRAY;

        for(int i=0; i<num_count; i++)
        {
            if(matrix[list_x][i] > 0 && colors[i] == WHITE)
            {
                ScanGraphMatrix(i, num_count);
            }
        }

        colors[ list_x ] = BLACK;
        System.out.print( " "+list_x);
    }

    void ScanGraphList(int list_x)
    {
        int counter = 0;
        colors[ list_x ] = GRAY;

        int temp[] = (int[]) vertexList.get(list_x);

        if(colors[list_x] == WHITE)
        {
            ScanGraphList(temp[counter]);
        }else
            while(counter <=temp.length-1){
                System.out.print( " "+temp[counter]);
                counter++;
            }


    }

    public static void main(String[] args) {


        Vertex labs3 = new Vertex();

    //    labs3.displayMatrixVertex();
        labs3.displayVertexList();

    }
}
