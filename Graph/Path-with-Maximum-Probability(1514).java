class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Double, Integer>>() {
            public int compare(Pair<Double, Integer> p1, Pair<Double, Integer> p2) {
                return Double.compare(p2.getKey(), p1.getKey());
            }
        });
        
        List<Map<Integer, Double>> g = new ArrayList<>();
        double[] prob = new double[n];
        Arrays.fill(prob, -1);
        
        for (int i = 0; i < n; i++) {
            g.add(new HashMap<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            g.get(u).put(v, p);
            g.get(v).put(u, p);
        }
        
        pq.add(new Pair<>(1.0, start));
        
        while (!pq.isEmpty()) {
            Pair<Double, Integer> pair = pq.poll();
            double sp = pair.getKey();
            int u = pair.getValue();
            
            if (prob[u] != -1) {
                continue;
            }
            
            prob[u] = sp;
            
            for (Map.Entry<Integer, Double> entry : g.get(u).entrySet()) {
                int v = entry.getKey();
                double p = entry.getValue();
                
                if (prob[v] == -1) {
                    pq.add(new Pair<>(sp * p, v));
                }
            }
        }
        return Math.max(prob[end], 0.0);
    }
}
