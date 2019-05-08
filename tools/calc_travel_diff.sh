#!/usr/bin/env bash
# -e: exit as long as
# -x: output command before run it
# -u: ignore undefined variable
#set -eux

# Timestamp: (50-300)/50
# Traffic level: 1000

serial="50 100 150 200 250 300"
echo -e "\n[benchmark] average travel_time"
for sec in ${serial}
do
    echo -e " (${sec},"`./travel_time.py ../result/benchmark/f${sec}.csv`")\c"
done

echo -e "\n[priority ] average travel_time"
for sec in ${serial}
do
    echo -e " (${sec},"`./travel_time.py ../result/priority/p${sec}.csv`")\c"
done
