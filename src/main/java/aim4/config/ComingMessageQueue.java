package aim4.config;

import aim4.msg.i2i.Leave;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ComingMessageQueue {
    private List<Leave> messageOrderedByTime;
    private Map<Constants.Direction, List<Leave>> messagesByDirection;

    public ComingMessageQueue() {
        messagesByDirection = new ConcurrentHashMap<>();
        messagesByDirection.put(Constants.Direction.NORTH, new ArrayList<>());
        messagesByDirection.put(Constants.Direction.WEST, new ArrayList<>());
        messagesByDirection.put(Constants.Direction.SOUTH, new ArrayList<>());
        messagesByDirection.put(Constants.Direction.EAST, new ArrayList<>());

        messageOrderedByTime = new ArrayList<>();
    }

    public void insertMessage(Leave leave) {
        messagesByDirection.get(leave.getDirectionFrom()).add(leave);
        messageOrderedByTime.add(leave);
    }

    public void removeMessage(Leave leave) {
        messagesByDirection.get(leave.getDirectionFrom()).remove(leave);
        messageOrderedByTime.remove(leave);
    }

    private static double NEAR_TIME = 5.0;

    public List<Leave> getAllNearTimeMessage(double time) {
        List<Leave> tmpMessageOrderedByTime = new CopyOnWriteArrayList<>(messageOrderedByTime);
        return tmpMessageOrderedByTime.stream()
                .filter(m -> m.getEstimateArriveTime() < time || Math.abs(m.getEstimateArriveTime() - time) < NEAR_TIME)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "LeaveMessageQueue{" +
                "messageOrderedByTime=" + messageOrderedByTime +
                ", messagesByDirection=" + messagesByDirection +
                '}';
    }
}
