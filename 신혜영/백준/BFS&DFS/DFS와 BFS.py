import sys
from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end = ' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

N, M, V = map(int, sys.stdin.readline().split())
graph = [[]]
for i in range(N):
    graph.append([])
    node, vertex = map(int, sys.stdin.readline().split())
    graph[node].append(vertex)

visited = [False] * M
dfs(graph, V, visited)
bfs(graph, V, visited)
