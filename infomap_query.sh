#!/usr/bin/env bash

set -e
csv_dir="/home/owner/blob/data/data_mining/dblp/csv"

# algo="infomap_major"
algo="infomap"

key=$(fzf <"$csv_dir/persons.csv" | cut -d',' -f1)
echo "Key: $key"

fn="$csv_dir/infomap/author_community.csv"

label=$(rg "$key" <$fn)

# Not used, terminates in `label for infomap minor lack`
if [ -z "$label" ]; then
	echo "$key doesn't have ifnomap_minor label"
	exit
fi

echo -e "\n"
echo -e "$(head -n1 <$fn)\n$label" | column -t -s',' --output-separator ' | '
echo -e "\n"

path=$(echo $label | cut -d',' -f4)

echo "$algo label: $path"

echo "MATCH  (p:person{$algo: \"$path\"}) return p" | xclip -selection clipboard
echo "Copied query"
