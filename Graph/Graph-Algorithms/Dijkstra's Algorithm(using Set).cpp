#include <bits/stdc++.h> 
vector<int> dijkstra(vector<vector<int>> &vec, int vertices, int edges, int source) {
    // Write your code here.
    unordered_map<int,list<pair<int,int> > >adj;
    for(int i=0; i<edges; i++){
        int u =vec[i][0];
        int v= vec[i][1];
        int w =vec[i][2];

        adj[u].push_back(make_pair(v,w));
        adj[v].push_back(make_pair(u,w));
    }
    vector<int>dist(vertices,INT_MAX);
    dist[source]=0;

    set<pair<int,int> >st;
    st.insert(make_pair(0,source));

    while(!st.empty()){
        // fatch top record
        auto top =*(st.begin());

        int nodeDist =top.first;
        int topNode =top.second;
        // remove top record now
        st.erase(st.begin() );


        // traverse for neighbour
        for(auto neighbour:adj[topNode]){
            if(nodeDist +neighbour.second < dist[neighbour.first]){

                // finding record
                auto record = st.find( make_pair(dist[neighbour.first],
    neighbour.first) );
                // if record found than erase it
                if( record != st.end()){
                    st.erase(record);
                }

                // distance update
                dist[neighbour.first] =nodeDist + neighbour.second;
                // push in set
                st.insert( make_pair(dist[neighbour.first],neighbour.first)  );
            }
        }
    }
    return dist;
}
