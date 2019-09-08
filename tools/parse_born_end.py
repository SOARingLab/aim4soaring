import datetime
import time
import sys

time_pattern=""

records = []
for line in sys.stdin:
  record = line.split()
  records.append(record)
  timestamp = record[0]
  realtime = time.strptime(timestamp[:-4], '%Y-%m-%d-%H:%M:%S')
  print(realtime)
