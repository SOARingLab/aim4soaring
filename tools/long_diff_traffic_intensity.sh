#!/usr/bin/env bash
# -e: exit as long as
# -x: output command before run it
# -u: ignore undefined variable
#set -eux

# Timestamp: (100-1000)/100
# Traffic level: 500 1000 1500

serial="100 200 300 400 500 600 700 800 900 1000"

echo -e "\n[benchmark-1000]"
for sec in ${serial}
do
    echo -e " (${sec},"`./travel_time.py ../result/b1000/f${sec}.csv`")\c"
done

echo -e "\n[benchmark-1500]"
for sec in ${serial}
do
    echo -e " (${sec},"`./travel_time.py ../result/b1500/f${sec}.csv`")\c"
done

echo -e "\n[priority-1000 ]"
for sec in ${serial}
do
     echo -e " (${sec},"`./travel_time.py ../result/p1000/p${sec}.csv`")\c"
done

echo -e "\n[priority-1500 ]"
for sec in ${serial}
do
     echo -e " (${sec},"`./travel_time.py ../result/p1500/p${sec}.csv`")\c"
done
