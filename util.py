import matplotlib.pyplot as plt
from typing import Dict
import os


def show_df(df, title=None):
    fig = plt.figure(figsize=(8, 2))
    ax = fig.add_subplot(111)

    ax.table(cellText=df.values, rowLabels=df.index, colLabels=df.columns, loc="center")

    if title is not None:
        ax.set_title(title)

    ax.axis("off")


def get_envs() -> Dict[str, str]:
    with open(".env") as f:
        return {
            line.split("=")[0]: "=".join(line.split("=")[1:]) for line in f.readlines()
        }


def cached_load(fn: str, cached, generate_saving):
    if os.path.isfile(fn):
        return cached(fn)
    else:
        return generate_saving(fn)
