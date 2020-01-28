import pickle

in_file = "./kur2.csv"
out_map_file = "kur2-authors.dat"
out_file = "kur2-coauth.dat"

print("Started.")

coauth = []
with open(in_file, "r") as f:
    lines = f.readlines()

    for line in lines:
        [a, b, _] = line.split(",")
        coauth.append((a.strip(), b.strip()))


print("Loaded.")

auth_to_idx = {}
authors = sorted(set([x for a, b in coauth for x in [a, b]]))

for i, a in enumerate(authors):
    auth_to_idx[a] = i


print("Preparing edges.")

edges = []
for a, b in coauth:
    edges.append((auth_to_idx[a], auth_to_idx[b]))

print("Saving.")

with open(out_map_file, "w") as f:
    for a in authors:
        f.write(a + "\n")


with open(out_file, "w") as f:
    for a, b in edges:
        f.write(f"{a} {b}\n")


print("Finished.")
