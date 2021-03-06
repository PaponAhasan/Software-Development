import queue

q = queue.Queue()

adj_list = {
    "A": ["B", "D"],
    "B": ["A", "C"]
}
visited = {}
level = {}
parent = {}
bfs_traversal_output = []

for node in adj_list.keys():
    visited[node] = False
    parent[node] = None
    level[node] = -1
# print(visited)
# print(level)
# print(parent)

s = "A"
visited[s] = True
level[s] = 0
q.put(s)

while not q.empty():
    u = q.get()
    bfs_traversal_output.append(u)

    for v in adj_list[u]:
        if not visited[v]:
            visited[v] = True
            parent[v] = u
            level[v] = level[u] + 1
            q.put(v)
print(bfs_traversal_output)
