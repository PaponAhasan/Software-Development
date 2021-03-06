# graph representation
adj_list = {
    "A": [],
    "B": [],
    "C": [],
    "D": [],
    "E": []
}

# adj_list["A"].append("D")

all_edges = [
    ("A", "B"), ("A", "C"), ("B", "D"), ("C", "D"), ("C", "E"), ("D", "E")
]


class Graph:
    def __init__(self, nodes, is_directed=False):
        self.nodes = nodes
        self.adj_list = {}
        self.is_directed = is_directed
        for node in self.nodes:
            self.adj_list[node] = []

    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        if not self.is_directed:
            self.adj_list[v].append(u)

    def degree(self, node):
        deg = len(self.adj_list[node])
        return deg

    def print_adj_list(self):
        for node in self.nodes:
            print(node, "->", self.adj_list[node])


nodes = ["A", "B", "C", "D", "E"]
graph = Graph(nodes, is_directed=True)
# graph.print_adj_list()

for u, v in all_edges:
    graph.add_edge(u, v)

graph.print_adj_list()

print("Degree of C ", graph.degree("C"))
