public class AirlineNetwork {
    private int[][] adjMatrix;//초기화 할 때 결정되어야 함
    private int numNodes;//얘 또한 초기화할때 결정되어야 함

    public AirlineNetwork(int numNodes) {
        this.numNodes = numNodes;
        adjMatrix = new int[numNodes][numNodes];
    }

    // 간선을 추가하는 메서드 (두 공항 간 직항 노선을 추가)
    public void addFlight(int node1, int node2) {
        adjMatrix[node1][node2] = 1;
        adjMatrix[node2][node1] = 1; // 무방향 그래프 (양방향 직항 노선)
    }

    //인접 행렬을 출력하는 메서드
    public void displayMatrix() {
        System.out.print("  ");
        //가로 라벨
        for (int i = 0; i < numNodes; i++) {
            //65가 'A'야. 'A' + i 해도 댐
            System.out.print((char) (65 + i) + " ");
        }//End of For
        System.out.println();

        for (int i = 0; i < numNodes; i++) {
            System.out.print((char) (65 + i) + " ");
            for (int j = 0; j < numNodes; j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AirlineNetwork network = new AirlineNetwork(4);

        int A = 0;
        int B = 1;
        int C = 2;
        int D = 3;
        // 직항 노선 추가
        network.addFlight(A, B); // A-B
        network.addFlight(A, C); // A-C
        network.addFlight(B, D); // B-D
        network.addFlight(C, D); // C-D

        // 인접 행렬 출력
        network.displayMatrix();
    }//End Of Main
}
