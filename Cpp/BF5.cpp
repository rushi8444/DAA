#include <iostream>
#include <vector>
#include <climits>
using namespace std;

struct Edge {
    int u, v, w;
    Edge(int u, int v, int w) : u(u), v(v), w(w) {}
};

vector<int> bellman_ford(int vertices, vector<Edge>& edges, int source) {
    // Step 1: Initialize distances
    vector<int> dist(vertices, INT_MAX);
    dist[source] = 0;

    // Step 2: Relax edges repeatedly
    for (int i = 0; i < vertices - 1; i++) {
        for (auto& edge : edges) {
            if (dist[edge.u] != INT_MAX && dist[edge.u] + edge.w < dist[edge.v]) {
                dist[edge.v] = dist[edge.u] + edge.w;
            }
        }
    }

    // Step 3: Check for negative weight cycles
    for (auto& edge : edges) {
        if (dist[edge.u] != INT_MAX && dist[edge.u] + edge.w < dist[edge.v]) {
            cout << "Graph contains a negative weight cycle!" << endl;
            return {};
        }
    }

    return dist;
}

int main() {
    vector<Edge> edges = {
        Edge(0, 1, 1),
        Edge(0, 2, 4),
        Edge(1, 2, -3),
        Edge(1, 3, 2),
        Edge(2, 3, 3)
    };

    int vertices = 4, source = 0;
    vector<int> distances = bellman_ford(vertices, edges, source);

    if (!distances.empty()) {
        cout << "Shortest distances from source: ";
        for (int d : distances) cout << d << " ";
        cout << endl;
    }

    return 0;
}