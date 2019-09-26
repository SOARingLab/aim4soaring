#!/usr/bin/env python3

import datetime
import time
import sys
import pprint
import collections

vin_to_born_time = {}
timestamp_to_count = collections.defaultdict(int)
time_pattern='%Y-%m-%d-%H:%M:%S.%f'

init_time = -1
step = 1
for line in sys.stdin:
  record = line.strip(',\n').split()
  timestamp = datetime.datetime.strptime(record[0], time_pattern).timestamp()
  if init_time == -1:
    init_time = timestamp

  vin = record[1]
  if vin not in vin_to_born_time:
    vin_to_born_time[vin] = timestamp
  else:
    timestamp_to_count[int(timestamp-init_time)//step] += 1

res = collections.defaultdict(int)
res1 = collections.defaultdict(int)

for k, v in timestamp_to_count.items():
  res[k] = res[k-step] + v
for k, v in res.items():
  res1[k] = res1[k-step] + v

for i, item in res1.items():
  print("({}, {})".format(i, item), end=" ")