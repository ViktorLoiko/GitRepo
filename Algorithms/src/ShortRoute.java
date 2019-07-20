import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ShortRoute {


    private String[] nameCities;

    private boolean[][] isVisitMatrix;


    private Stack<Integer> oderVisit = new Stack<>();


    private List<Integer> listResult = new ArrayList();


    private final int[][] matrix = {    {0, 3, 0, 0, 4, 0},
                                        {3, 0, 2, 4, 0, 2},
                                        {0, 2, 0, 0, 3, 2},
                                        {0, 4, 0, 0, 1, 0},
                                        {4, 0, 3, 1, 0, 0},
                                        {0, 2, 4, 0, 0, 0}};


    public ShortRoute() {
        initIsVisitMatrix(6);
        listResult.add(calculatePath(0, 5));
        showResult();
        //  listResult.add( calculatePath(1,3));
        //  showResult();


    }


    private List<Integer> searchRoute(int source, int destination) {

        int nextNeighborVertex = 0;
        int resultCost = 0;


        List<Integer> allCost = new ArrayList();


        oderVisit.push(source);


        if (source == destination) {

            allCost.add(0);
            return allCost;


        } else if (source > destination) {
            int temp = destination;
            destination = source;
            source = temp;
        }


        while (true) {


            if (nextNeighborVertex > matrix.length - 1 || source > matrix.length - 1) {


                if (oderVisit.empty()) {
                    return allCost;
                }


                int previousVertex = oderVisit.pop();


                if (source == previousVertex) {


                    if (oderVisit.empty()) {
                        resultCost -= getCost(source, previousVertex);
                        setFalseVisit(source);
                        source = previousVertex;
                        nextNeighborVertex = source;
                        continue;


                    } else if (oderVisit.peek() > previousVertex) {
                        resultCost -= getCost(source, oderVisit.peek());
                        setFalseVisit(source);
                        source = oderVisit.peek();
                        nextNeighborVertex = 0;
                        continue;


                    }


                    previousVertex = oderVisit.pop();
                    resultCost -= getCost(source, previousVertex);
                    setFalseVisit(source);
                    source = previousVertex;
                    nextNeighborVertex = source;


                } else {
                    resultCost -= getCost(source, previousVertex);
                    setFalseVisit(source);
                    source = previousVertex;
                    nextNeighborVertex = source;
                }

            }


            if (source == nextNeighborVertex) {
                nextNeighborVertex++;


            } else if (getCost(source, nextNeighborVertex) != 0 && !isVisitMatrix[source][nextNeighborVertex]) {


                if (getCost(source, nextNeighborVertex) != 0 && nextNeighborVertex == destination) {

                    isVisitMatrix[source][nextNeighborVertex] = true;
                    resultCost += getCost(source, nextNeighborVertex);
                    allCost.add(resultCost);
                    resultCost -= getCost(source, nextNeighborVertex);
                    nextNeighborVertex++;


                } else if (isVisitMatrix[source][nextNeighborVertex] || isVisitMatrix[nextNeighborVertex][source]) {

                    nextNeighborVertex++;


                } else if (!isVisitMatrix[source][nextNeighborVertex]) {


                    if (oderVisit.empty())
                        oderVisit.push(source);


                    if (oderVisit.contains(nextNeighborVertex)) {
                        nextNeighborVertex++;
                        continue;
                    }


                    if (!oderVisit.contains(source))
                        oderVisit.push(source);


                    oderVisit.push(nextNeighborVertex);
                    resultCost += getCost(source, nextNeighborVertex);
                    isVisitMatrix[source][nextNeighborVertex] = true;
                    source = nextNeighborVertex;
                    nextNeighborVertex = 0;


                } else {


                    if (oderVisit.empty())
                        oderVisit.push(source);


                    if (oderVisit.contains(nextNeighborVertex)) {
                        nextNeighborVertex++;
                        continue;
                    }


                    oderVisit.push(nextNeighborVertex);
                    resultCost += getCost(source, nextNeighborVertex);
                    isVisitMatrix[source][nextNeighborVertex] = true;
                    source = nextNeighborVertex;
                    nextNeighborVertex = 0;


                }


            } else {
                nextNeighborVertex++;
            }
        }
    }


    private int getCost(int source, int destination) {

        if (matrix[source][destination] != 0) {

            return matrix[source][destination];
        }
        return 0;
    }


    private int minCost(List<Integer> allCost) {


        return Collections.min(allCost);

    }


    private int calculatePath(int indexSource, int indexDestination) {
        return minCost(searchRoute(indexSource, indexDestination));

    }


    private void initIsVisitMatrix(int length) {

        isVisitMatrix = new boolean[length][length];
    }


    private void setFalseVisit(int vertex) {
        int e = isVisitMatrix.length - 1;
        while (e >= 0) {
            isVisitMatrix[vertex][e] = false;
            e--;
        }

    }


    private void showResult() {

        System.out.println("RESULT MIN : ");
        for (int i : listResult) {
            System.out.println(i);
        }
    }


    public void showMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }


    }


    public static void main(String[] args) {

        ShortRoute costPath = new ShortRoute();


    }


}
