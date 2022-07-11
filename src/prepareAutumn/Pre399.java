package prepareAutumn;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-07 23:29
 */
public class Pre399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> varaiables = new HashMap<>();
        int n = equations.size();

        for (int i = 0; i < n; i++){
            if (!varaiables.containsKey(equations.get(i).get(0))){
                varaiables.put(equations.get(i).get(0), nvars++);
            }
            if (!varaiables.containsKey(equations.get(i).get(1))){
                varaiables.put(equations.get(i).get(1), nvars++);
            }
        }
        List<Pair>[] edges = new ArrayList[nvars];
        for (int i = 0; i < nvars; i++){
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < n; i++){
            int va = varaiables.get(equations.get(i).get(0));
            int vb = varaiables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];

        for (int i = 0; i < queriesCount; i++){
            List<String> query = queries.get(i);
            double result = -1.0;
            if (varaiables.containsKey(query.get(0)) && varaiables.containsKey(query.get(1))){
                int ia = varaiables.get(query.get(0));
                int ib = varaiables.get(query.get(1));
                if (ia == ib){
                    result = 1.0;
                }else{
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, - 1);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0){
                        int x = points.poll();
                        for(Pair pair : edges[x]){
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0){
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;

    }
    class Pair{
        int index;
        double value;
        public Pair(int index, double value){
            this.index = index;
            this.value = value;
        }
    }
}
