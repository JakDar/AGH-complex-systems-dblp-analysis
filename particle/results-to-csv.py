import re
import os
import pandas as pd


path = "./Snap-5.0/examples/particles/results"

edge_regex = r"(\d+) -- (\d+)"
node_regex = r"(\d+) \[label=\"(.*?)\" fillcolor=\"(.*?)\""


def process_file(path):
    content = None
    with open(path, "r") as f:
        content = "".join(f.readlines())

    node_attrs = re.findall(node_regex, content)
    color_to_id = {c: i for i, c in enumerate(set([c for _, _, c in node_attrs]))}
    edges = re.findall(edge_regex, content)
    nodes = [(i, a, color_to_id[c]) for i, a, c in node_attrs]

    return nodes, edges


def process_all(dir_path):
    result = []
    for fn in os.listdir(dir_path):
        if fn.endswith(".gv"):
            alpha, beta = 1.0, fn[:-3]
            nodes, _ = process_file(os.path.join(dir_path, fn))

            for node in nodes:
                result.append(node + (alpha, beta))

    return pd.DataFrame(result, columns=["id", "author", "community", "alpha", "beta"])


df = process_all(path)

df.to_csv("communities.csv", index=False)
