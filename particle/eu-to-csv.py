import re
import os
import pandas as pd


res_path = "./Snap-5.0/examples/particles/results"


file_names = os.listdir(res_path)

results = []

for name in file_names:
    path = os.path.join(res_path, name)
    alpha = 1.0
    beta = float(name[:-4])

    with open(path, "r") as f:
        lines = f.readlines()

        for line in lines:
            id, community = line.split("\t")
            results.append((id.strip(), community.strip(), alpha, beta))

df = pd.DataFrame(results, columns=["id", "community", "alpha", "beta"])

df.to_csv("eu.csv", index=False)
