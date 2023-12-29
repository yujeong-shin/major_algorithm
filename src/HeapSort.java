import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        int n = arr.length;
//        최초 힙 구성 : n/2번만큼 heapify 수행
//        루트노드 제외, 자식이 있는 노드를 대상으로 heapify

        for(int i=arr.length/2-1; i>=0; i--){
            heapify(arr, n, i);
        }

//        최초 힙 구성 이후에 root 노드와 마지막 노드와 change
        for (int i = 0; i < arr.length-1; i++) {
//            0번째 노드와 마지막 노드 change -> 최댓값이 마지막 위치에 담김
//            0번째부터 하향식으로 내려가면서 heapify -> 다음 최댓값이 맨 위에 담김
            swap(arr, 0, arr.length-(i+1));

//            다음 반복은 n값을 n-1로 줄여줘서
//            이전 반복에서 정렬된 최댓값은 다음 heapify에서 접근하지 못하도록 제외시켜줘야 함
            heapify(arr, n-(i+1), 0);
        }

        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int n, int root){
        //        넘어온 자식 노드가 배열 범위를 벗어나면 탐색X -> 루트 노드이기 때문에
        if(root >= n) return;

//        부모보다 큰 자식이 있을 경우 change
//        넘어온 부모 노드의 자식이 arr.length-1보다 크면
//        해당 인덱스에는 자식이 위치하지 않는 것 = 배열 상에 존재하지 않기 때문에 체크하면 안된다.
        int lChild = root*2+1;
        int rChild = root*2+2;
        int bigChild=root;

        if (lChild < n && arr[lChild] > arr[bigChild]) {
            bigChild = lChild;
        }

        if (rChild < n && arr[rChild] > arr[bigChild]) {
            bigChild = rChild;
        }

        if (bigChild != root) {
            swap(arr, root, bigChild);
            heapify(arr, n, bigChild);
        }
    }


    static void swap(int[] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}