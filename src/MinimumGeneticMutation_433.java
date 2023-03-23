import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        HashSet<String> hasVisit = new HashSet<>();
        hasVisit.add(startGene);
        if(startGene.equals(endGene)) return 0;
        if(!set.contains(endGene)) return -1;
        queue.offer(startGene);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String origin = queue.poll();
                for(String target:set){
                    if(!hasVisit.contains(target)&&isConvertable(origin,target)){
                        queue.offer(target);
                        hasVisit.add(target);
                        if(target.equals(endGene)) return step+1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public boolean isConvertable(String origin, String target){
        int dif = 0;
        for(int i=0;i<origin.length();i++){
            if(origin.charAt(i)!=target.charAt(i)) dif++;
        }
        return dif==1;
    }

    public static void main(String[] args) {
        String[] bank = {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        MinimumGeneticMutation_433 m = new MinimumGeneticMutation_433();
        m.minMutation("AAAACCCC","CCCCCCCC",bank);
    }
}
