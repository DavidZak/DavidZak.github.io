package Helpers;

import PathElements.AbstractClasses.PathElement;
import java.util.*;

public class PathFinderHelper {

    Map<PathElement, Integer> map = new HashMap<>();
    Queue<PathElement> queue = new PriorityQueue<>();

    public void findPathWithMinimalElementsCount(PathElement first, PathElement second, int marker) {

        map.put(first, marker);
        queue.add(first);

        do {
            PathElement element = queue.poll();
            for (ConnectionData connectionData : element.getConnections()) {

                System.out.println(connectionData.pathElement);
                queue.add(connectionData.pathElement);
                map.put(connectionData.pathElement, marker + 1);

                System.out.println(marker);
            }

            marker += 1;

        } while (!queue.isEmpty() && !map.containsKey(second));

        System.out.println("path found");

        int n = marker - 1;
        PathElement temp = second;
        Set<PathElement> elements = new LinkedHashSet<>();
        elements.add(temp);

        System.out.println("map: " + map);

        while (n > 0) {
            System.out.println("n : " + n);
            for (Map.Entry<PathElement, Integer> entry : map.entrySet()) {
                if (entry.getValue() == n && entry.getKey().getConnections().contains(new ConnectionData(temp, 0, 0))) {
                    System.out.println("entry getKey: " + entry.getKey());
                    elements.add(entry.getKey());
                    temp = entry.getKey();
                }
            }
            n--;
        }
        System.out.println("elements: " + elements);
    }
}
