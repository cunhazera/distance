package com.graph.distance;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.LinkedList;

@RestController
public class DistanceResource {

    @RequestMapping(consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON}, method = RequestMethod.GET, value = "/shortest")
    public Response findDistance(@RequestBody GraphRestObject graph) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph.getGraph());
        dijkstraAlgorithm.execute(graph.getSource());
        LinkedList<Vertex> shortest = dijkstraAlgorithm.getPath(graph.getDest());
        return Response.ok(shortest).build();
    }

    /***
     * The unique goal here is to provide a json to the endpoint above
     */
    @RequestMapping(method = RequestMethod.GET, value = "/json")
    public GraphRestObject fake() {
        Vertex sp = new Vertex("1", "SP");
        Vertex sc = new Vertex("2", "SC");
        Vertex rj = new Vertex("3", "RJ");
        Vertex bh = new Vertex("4", "BH");
        Edge edge = new Edge("1", sp, sc, 100);
        Edge edge2 = new Edge("2", sp, rj, 123414);
        Edge edge3 = new Edge("3", sp, bh, 453443);
        Edge edge4 = new Edge("3", rj, bh, 546545);
        Edge edge5 = new Edge("3", rj, sc, 9976);
        Edge edge6 = new Edge("3", bh, sc, 55812);

        Graph graph = new Graph(Arrays.asList(sp, sc, rj, bh), Arrays.asList(edge, edge2, edge3, edge4, edge5, edge6));

        GraphRestObject obj = new GraphRestObject();
        obj.setGraph(graph);
        obj.setSource(sp);
        obj.setDest(sc);
        return obj;
    }

}
