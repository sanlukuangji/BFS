import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares_279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int tmp = queue.poll();
                int maxSquare = (int) Math.sqrt(tmp);
                for(int j=1;j<=maxSquare;j++){
                    queue.offer(tmp-j*j);
                    if(tmp-j*j==0) return step+1;
                }
            }
            step++;
        }
        return 0;
    }
}
