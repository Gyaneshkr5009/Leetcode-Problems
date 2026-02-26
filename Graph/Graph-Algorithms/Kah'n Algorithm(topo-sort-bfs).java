public int[] toposort(int v , ArrayList<ArrayList<Integer>> adj){
  int[] indegree = new int[v];  // declaring a indegreee array to count for all vercies indegree;
  for(int i=0 ; i<v ;i++){
    //a->b so b++ if b->a a++;
    for(int a:adj.get(i)){
      indegree[a]++;
    }
  }
  //above we fill the indegree now;
  int[] toposort = new int[v];
  int idx=0;
  Queue<Integer> q= new LinkedList<>();
  for(int i=0;i<v;i++){
    //which ever vertices have the zero indegree, is consider a perfect start for toposort
    if(indegree[i] == 0) q.offer(i);
  }

  //required a visited array to track of elements are visited or not;
  while(!q.isEmpty()){
    int node = q.poll();
    toposort[idx++] = node;
    for(int a:adj.get(node)){
      indegree[a]--;
      if(indegree[a] == 0) q.offer(a);
    }
  }
  return toposort;
}
