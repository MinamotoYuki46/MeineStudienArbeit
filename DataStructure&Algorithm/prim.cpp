#include<bits/stdc++.h>
using namespace std;

#define vertices 9

int minKey(int key[], bool mstSet[]){
    int minimum = INT_MAX, minIndex;

    for(int i = 0; i < vertices; i++){
        if (mstSet[i] == false && key[i] < minimum){
            minimum = key[i], minIndex = i;
        }
    }

    return minIndex;
}

char convert(int num){
    return 'A' + num;
}

void printMST(int parent[], int graph[vertices][vertices]) {
    cout << "Edge \tWeight\n";
    for (int i = 1; i < vertices; i++)
        cout << convert(parent[i]) << " - " << convert(i) << " \t" << graph[i][parent[i]] << " \n";
}

void prim(int graph[vertices][vertices]){
    int parent[vertices]; 
    int key[vertices];   
    bool mstSet[vertices];  

    for (int i = 0; i < vertices; i++)
        key[i] = INT_MAX, mstSet[i] = false;

    key[0] = 0;     
    parent[0] = -1; 

    for (int count = 0; count < vertices - 1; count++) {
        int u = minKey(key, mstSet);
        mstSet[u] = true;

        for (int v = 0; v < vertices; v++)
            if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])
                parent[v] = u, key[v] = graph[u][v];
    }

    printMST(parent, graph);
}

int main(){
    int graph[vertices][vertices]{
        0, 24, 15, 10, 0, 0, 0, 0, 0,
        24, 0, 14, 0, 0, 0, 0, 0, 6,
        15, 14, 0, 16, 25, 17, 0, 23, 0,
        10, 0, 16, 0, 22, 0, 15, 0, 0,
        0, 0, 25, 22, 0, 0, 0, 8, 0, 
        0, 0, 17, 0, 0, 0, 0, 9, 12,
        0, 0, 0, 15, 0, 0, 0, 21, 0,
        0, 0, 23, 0, 8, 9, 21, 0, 18,
        0, 6, 0, 0, 0, 12, 0, 18, 0 
        };

    prim(graph);
    return 0;
}