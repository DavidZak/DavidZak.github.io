package RouteProviders;

import Helpers.RouteNotFoundException;
import Network.Network;
import PathElements.Interfaces.PathElement;

import java.util.*;

public class IDRouteProvider implements RouteProvider {
    @Override
    public List<PathElement> getRoute(int firstID, int secondID, Network network) throws RouteNotFoundException {
        return null;
    }

    public void fordBellman(int firstID, Network network){

        int size=network.getPathElements().size();
        int dist[] = new int[size];
        for (int i=0;i<dist.length;i++){
            dist[i]=228;
        }
        dist[firstID]=0;
    }

    public Set<PathElement> bfs(int firstID, int secondID, Network network) throws RouteNotFoundException {
        PriorityQueue<PathElement> queue=new PriorityQueue<>();
        Set<PathElement> pathElements=new LinkedHashSet<>();

        for (PathElement element:network.getPathElements()) {
            if (element.getID() == firstID && !pathElements.contains(element)) {
                queue.add(element);
                pathElements.add(element);
                while (!queue.isEmpty()) {
                    System.out.println("queue: "+queue);
                    PathElement elem = queue.poll();
                    if (elem.getID() == secondID) {
                        System.out.println("path Elements: " + pathElements);
                        return pathElements;
                    }
                    for (PathElement pathElement : elem.getConnections()) {
                        if (!pathElements.contains(pathElement)) {
                            queue.add(pathElement);
                            pathElements.add(pathElement);
                        }
                        if (pathElement.getID() == secondID) {
                            System.out.println("path Elements: " + pathElements);
                            return pathElements;
                        }
                    }
                }
            }
            System.out.println("route not found");
            System.out.println("pathElems: " + pathElements);
            return pathElements;
        }
        return null;
    }

    public Set<PathElement> dfs(int firstID, int secondID, Network network) throws RouteNotFoundException {
        Set<PathElement> pathElements=new LinkedHashSet<>();
        Stack<PathElement> stack=new Stack<>();

        for (PathElement element:network.getPathElements()) {
            if (element.getID() == firstID && !pathElements.contains(element)) {
                stack.push(element);
                pathElements.add(element);
                while (!stack.empty()) {
                    System.out.println("stack: "+stack);
                    PathElement elem=stack.pop();
                    if (elem.getID() == secondID) {
                        System.out.println("dfs pathElemsss: " + pathElements);
                        return pathElements;
                    }
                    for (PathElement pathElement : elem.getConnections()) {
                        if (!pathElements.contains(pathElement)) {
                            stack.push(pathElement);
                            pathElements.add(pathElement);
                        }
                        if (pathElement.getID() == secondID) {
                            System.out.println("path Elements: " + pathElements);
                            return pathElements;
                        }
                    }
                }
            }
        }
        System.out.println("dfs pathElems: " + pathElements);
        return pathElements;
    }
}
