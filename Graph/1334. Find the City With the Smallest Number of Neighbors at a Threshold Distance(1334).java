
//***********************************************************(Floyd Warshell)************************************************************
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        if(edges==null || edges.length==0) return 0;
        int m=edges.length;

        int[][] dist=new int[n][n]; // to keep track of shortest dist from each node one by one to every node in a graph;
        
        for(int i=0;i<n ;i++){
            for(int j=0;j< n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        //filling the dist matrix innitially;
        for(int i=0;i<m;i++){
            // u --> v
            int u=edges[i][0];
            int v=edges[i][1];
            int cost=edges[i][2];

            //we  are given bidirectional so do it for both node;
            dist[u][v]=cost;
            dist[v][u]=cost;
        }

        //now we got the initial dist matrix;
        for(int i=0;i<n;i++) dist[i][i]=0;

        //now we are using floyd warshell algo;
        for(int via=0;via<n;via++){
            for(int i=0;i<n ;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]==Integer.MAX_VALUE || dist[via][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j] , dist[i][via] + dist[via][j]);
                }
            }
        }

        //as we have the dist matrix with cost<=distanceThreshold , so we told we have to return the city with smallest no of cities ; and if 2 or more have the same return the max one;
        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}

//*****************************************************************(dijkstra's Algorithm)*********************************************************
