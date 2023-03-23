import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AsFarFromLandAsPossible_1162 {
    public int maxDistance(int[][] grid) {
        boolean land = false;
        boolean water = false;
        int i,j;
        for(i=0;i<grid.length;i++){
            for(j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) land = true;
                else water = true;
            }
        }
        // 只有一种
        if(!land||!water) return -1;
        // 记录每块水域离陆地最小值
        Map<String,Integer> map = new HashMap<>();
        for(i=0;i<grid.length;i++){
            for(j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    String pos = String.valueOf(i)+"#"+String.valueOf(j);
                    map.put(pos,Integer.MAX_VALUE);
                }
            }
        }
        int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
        for(i=0;i<grid.length;i++){
            for(j=0;j<grid[0].length;j++){
                // 水域bfs找最近陆地
                if(grid[i][j]==0){
                    int step = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int k=0;k<size;k++){
                            int[] pos = queue.poll();
                            int row = pos[0];
                            int col = pos[1];
                            // 如果pos位置是陆地了，那么说明距离是step
                            if(grid[row][col]==1){

                            }
                        }
                    }
                }
            }
        }
    }
}
