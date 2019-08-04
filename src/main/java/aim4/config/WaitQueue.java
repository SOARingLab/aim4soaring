package aim4.config;

import aim4.msg.i2i.Leave;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WaitQueue extends ConcurrentHashMap<Constants.Direction, List<Leave>> {
}
