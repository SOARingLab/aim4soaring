#!/usr/bin/env bash
# -e: exit as long as
# -x: output command before run it
# -u: ignore undefined variable
#set -eux

# Timestamp: (50-300)/50
# Traffic level: 500 1000 1500

serial="50 100 150 200 250 300"

echo -e "\n[benchmark-500 ]"
for sec in ${serial}
do
    echo -e "\t${sec}s:" `./travel_time.py ../result/benchmark500/f${sec}.csv` "\c"
done

echo -e "\n[benchmark-1000]"
for sec in ${serial}
do
    echo -e "\t${sec}s:" `./travel_time.py ../result/benchmark1000/f${sec}.csv` "\c"
done

echo -e "\n[benchmark-1500]"
for sec in ${serial}
do
    echo -e "\t${sec}s:" `./travel_time.py ../result/benchmark1500/f${sec}.csv` "\c"
done

echo -e "\n[priority-500  ]"
for sec in ${serial}
do
     echo -e "\t${sec}s:" `./travel_time.py ../result/priority500/p${sec}.csv` "\c"
done

echo -e "\n[priority-1000 ]"
for sec in ${serial}
do
     echo -e "\t${sec}s:" `./travel_time.py ../result/priority1000/p${sec}.csv` "\c"
done

echo -e "\n[priority-1500  ]"
for sec in ${serial}
do
     echo -e "\t${sec}s:" `./travel_time.py ../result/priority1500/p${sec}.csv` "\c"
done
