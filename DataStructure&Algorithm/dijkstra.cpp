#include <bits/stdc++.h>
using namespace std;

// Function to implement Dijkstra's algorithm
pair<vector<int>, vector<int>> dijkstra(const vector<vector<int>>& graph, int src) {
    int n = graph.size();
    vector<int> dist(n, INT_MAX);
    vector<bool> visited(n, false);
    vector<int> prev(n, -1);

    // Priority queue to store (distance, node)
    priority_queue<
        pair<int, int>, 
        vector<pair<int, int>>, 
        greater<pair<int, int>>
        > pq;

    // Start from the source node
    dist[src] = 0;
    pq.push({0, src});

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        if (visited[u]) continue;

        visited[u] = true;

        // Update distances for neighbors of u
        for (int v = 0; v < n; ++v) {
            if (graph[u][v] != 0 && !visited[v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
                prev[v] = u;
                pq.push({dist[v], v});
            }
        }
    }

    return {dist, prev};
}

// Function to reconstruct the path from src to dest using the 'prev' vector
vector<int> reconstruct_path(int dest, const vector<int>& prev) {
    vector<int> path;
    for (int at = dest; at != -1; at = prev[at])
        path.push_back(at);
    reverse(path.begin(), path.end());
    return path;
}

int main() {
    // Representation of the graph as an adjacency matrix
    vector<vector<int>> graph = {
        {0, 12, 0, 14, 0, 0},
        {12, 0, 11, 3, 8, 5},
        {0, 11, 0, 15, 9, 6},
        {14, 3, 15, 0, 7, 0},
        {0, 8, 9, 7, 0, 13},
        {0, 5, 6, 0, 13, 0}
    };

    vector<vector<int>> graph1 = {
        {0, 24, 15, 10, 0, 0, 0, 0, 0},
        {24, 0, 14, 0, 0, 0, 0, 0, 6},
        {15, 14, 0, 16, 25, 17, 0, 23, 0},
        {10, 0, 16, 0, 22, 0, 15, 0, 0},
        {0, 0, 25, 22, 0, 0, 0, 8, 0},
        {0, 0, 17, 0, 0, 0, 0, 9, 12},
        {0, 0, 0, 15, 0, 0, 0, 21, 0},
        {0, 0, 23, 0, 8, 9, 21, 0, 18},
        {0, 6, 0, 0, 0, 12, 0, 18, 0}
    };

    int src = 0;  // Start node (A)

    auto [distances, prev] = dijkstra(graph1, src);

    for(int i = 0; i < 9; i++){
        printf("The shortest distance from A to %c is: %d\n", 'A' + i, distances[i]);
        
        // Reconstruct the path from src to i
        vector<int> path = reconstruct_path(i, prev);
        printf("Path: ");
        for (int node : path) {
            printf("%c ", 'A' + node);
        }
        printf("\n");
    }

    return 0;
}
