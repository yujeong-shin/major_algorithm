import java.util.Arrays;

public class HeapSort_T {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        int n = arr.length;
//        최초 힙 구성 : n/2번만큼 heapify 수행
//        루트노드 제외, 자식이 있는 노드를 대상으로 heapify
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }

//        최초 힙구성 이후에 root 노드와 마지막 노드와 change
        for (int i = n-1; i >0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int n, int root){
        int max_index = root;
        int left = root*2+1;
        int right = root*2+2;
        if(left<n && arr[max_index] < arr[left]) max_index = left;
        if(right<n && arr[max_index] < arr[right]) max_index = right;

        if(max_index != root){
            //초기값이 root였기 때문에, max_index가 바뀌었다면 자식 중 root보다 큰 값이 있는 것임 -> swap
            int tmp = arr[root];
            arr[root] = arr[max_index];
            arr[max_index] = tmp;
            heapify(arr, n, max_index);
        }
    }
}
