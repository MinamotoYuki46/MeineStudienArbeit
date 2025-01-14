#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define vertices 9

struct Edge {
    int src, dest, weight;
};

struct Graph {
    int V = vertices, E;
    vector<Edge> edges;
};

struct subset {
    int parent;
    int rank;
};

char convert(int num){
    return 'A' + num;
}

int find(subset subsets[], int i) {
    if (subsets[i].parent != i)
        subsets[i].parent = find(subsets, subsets[i].parent);
    return subsets[i].parent;
}

void Union(subset subsets[], int x, int y) {
    int xroot = find(subsets, x);
    int yroot = find(subsets, y);

    if (subsets[xroot].rank < subsets[yroot].rank)
        subsets[xroot].parent = yroot;
    else if (subsets[xroot].rank > subsets[yroot].rank)
        subsets[yroot].parent = xroot;
    else {
        subsets[yroot].parent = xroot;
        subsets[xroot].rank++;
    }
}

bool compare(Edge a, Edge b) {
    return a.weight < b.weight;
}

void KruskalMST(Graph& graph) {
    int V = graph.V;
    vector<Edge> result;
    sort(graph.edges.begin(), graph.edges.end(), compare);

    subset* subsets = new subset[V];
    for (int v = 0; v < V; ++v) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
    }

    for (Edge& edge : graph.edges) {
        int x = find(subsets, edge.src);
        int y = find(subsets, edge.dest);

        if (x != y) {
            result.push_back(edge);
            Union(subsets, x, y);
        }
    }

    cout << "Edges in MST:\n";
    for (Edge& edge : result)
        cout << convert(edge.src) << " -- " << convert(edge.dest) << " == " << edge.weight << endl;
}



int main() {
    Graph graph;
    graph.V = vertices;
    graph.edges = {
        {0, 1, 24}, {0, 2, 15}, {0, 3, 10},
        {1, 2, 14}, {1, 8, 6},
        {2, 3, 16}, {2, 4, 25}, {2, 5, 17}, {2, 7, 23},
        {3, 4, 22}, {3, 6, 15},
        {4, 7, 8},
        {5, 7, 9}, {5, 8, 12},
        {6, 7, 21},
        {7, 8, 18}
    };

    KruskalMST(graph);

    return 0;
}
