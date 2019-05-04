#!/usr/bin/env bash
# -e: exit as long as
# -x: output command before run it
# -u: ignore undefined variable
set -eux

for sec in 50 100 150 200 250 300
do
    echo "[benchmark] average travel_time in ${sec} seconds:"
    ./travel_time.py ../result/benchmark/f${sec}.csv
    echo "[priority ] average travel_time in ${sec} seconds:"
    ./travel_time.py ../result/priority/p${sec}.csv
done
