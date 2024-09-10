class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    // 병합 정렬 함수
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 리스트를 반으로 나눕니다.
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;  // 리스트를 두 부분으로 나눔

        // 왼쪽과 오른쪽 부분을 재귀적으로 정렬합니다.
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // 병합된 리스트를 반환합니다.
        return merge(left, right);
    }

    // 두 정렬된 리스트를 병합하는 함수
    public Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;

        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    // 중간 노드를 찾는 함수 (중간을 기준으로 리스트를 나누기 위해 사용)
    public Node getMiddle(Node head) {
        if (head == null) return head;  // 리스트가 비어있으면 null을 반환

        Node slow = head, fast = head.next;  // slow는 처음에 head, fast는 head의 다음 노드를 가리킴

        // fast가 리스트 끝에 도달할 때까지 반복
        while (fast != null && fast.next != null) {
            slow = slow.next;  // slow는 한 칸씩 이동
            fast = fast.next.next;  // fast는 두 칸씩 이동
        }

        return slow;  // slow가 중간 노드를 가리키게 됨
    }

    // 리스트를 출력하는 함수
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortLinkedList list = new MergeSortLinkedList();
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(5);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);

        System.out.println("정렬 전 리스트:");
        list.printList(head);

        head = list.mergeSort(head);

        System.out.println("정렬 후 리스트:");
        list.printList(head);
    }
}
