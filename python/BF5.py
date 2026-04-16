class Edge:
    def __init__(self, u, v, w):
        self.u = u
        self.v = v
        self.w = w


def bellman_ford(vertices, edges, source):
    dist = [float("inf")] * vertices
    dist[source] = 0

    for _ in range(vertices - 1):
        for edge in edges:
            if dist[edge.u] != float("inf") and dist[edge.u] + edge.w < dist[edge.v]:
                dist[edge.v] = dist[edge.u] + edge.w

    # Check negative cycle
    for edge in edges:
        if dist[edge.u] != float("inf") and dist[edge.u] + edge.w < dist[edge.v]:
            print("Negative weight cycle detected")
            return

    print("Shortest distances:", dist)


edges = [
    Edge(0,1,1),
    Edge(0,2,4),
    Edge(1,2,-3),
    Edge(1,3,2),
    Edge(2,3,3)
]

bellman_ford(4, edges, 0)