import java.util.*;

public class ShortestPathWithAlternatingColors_1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer,List<Integer>> blueMap = new HashMap<>();
        int i;
        for(i=0;i< redEdges.length;i++){
            int start = redEdges[i][0];
            int end = redEdges[i][1];
            List<Integer> list = redMap.getOrDefault(start,new ArrayList<>());
            list.add(end);
            redMap.put(start,list);
        }
        for(i=0;i< blueEdges.length;i++){
            int start = blueEdges[i][0];
            int end = blueEdges[i][1];
            List<Integer> list = blueMap.getOrDefault(start,new ArrayList<>());
            list.add(end);
            blueMap.put(start,list);
        }
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        res[0] = 0;
        queue.offer(0);
        int flag = 0;
        int distance = 0;
        // 已经走过的点
        HashSet<Integer> redset = new HashSet<>();
        HashSet<Integer> blueset = new HashSet<>();
        // 初始是走红色边
        blueset.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(i=0;i<size;i++){
                int tmp = queue.poll();
                // 如果是偶数就走红色边
                if(flag%2==0){
                    List<Integer> list = redMap.getOrDefault(tmp,new ArrayList<>());
                    for(Integer child:list){
                        if(redset.contains(child)) continue;
                        redset.add(child);
                        queue.offer(child);
                        res[child] = Math.min(res[child],distance+1);
                    }
                }
                // 如果是奇数就走蓝色边
                else{
                    List<Integer> list = blueMap.getOrDefault(tmp,new ArrayList<>());
                    for(Integer child:list){
                        if(blueset.contains(child)) continue;
                        blueset.add(child);
                        queue.offer(child);
                        res[child] = Math.min(res[child],distance+1);
                    }
                }
            }
            flag++;
            distance++;
        }
        redset.clear();
        blueset.clear();
        // 初始走蓝色
        flag = 0;
        distance = 0;
        queue.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(i=0;i<size;i++){
                int tmp = queue.poll();
                // 如果是偶数就走蓝色色边
                if(flag%2==0){
                    List<Integer> list = blueMap.getOrDefault(tmp,new ArrayList<>());
                    for(Integer child:list){
                        if(blueset.contains(child)) continue;
                        blueset.add(child);
                        queue.offer(child);
                        res[child] = Math.min(res[child],distance+1);
                    }
                }
                // 如果是奇数就走蓝色边
                else{
                    List<Integer> list = redMap.getOrDefault(tmp,new ArrayList<>());
                    for(Integer child:list){
                        if(redset.contains(child)) continue;
                        redset.add(child);
                        queue.offer(child);
                        res[child] = Math.min(res[child],distance+1);
                    }
                }
            }
            flag++;
            distance++;
        }
        for(i=0;i<res.length;i++){
            if(res[i]==Integer.MAX_VALUE) res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] redEdges = {{3,2},{4,1},{1,4},{2,4}};
        int[][] blueEdges = {{2,3},{0,4},{4,3},{4,4},{4,0},{1,0}};
        ShortestPathWithAlternatingColors_1129 s = new ShortestPathWithAlternatingColors_1129();
        s.shortestAlternatingPaths(5,redEdges,blueEdges);
    }
}
