package hm5;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private List<Resource> resources = new ArrayList<>();

    public void add(Resource res) {
        resources.add(res);
    }

    public List<Resource> getResources() {
        return resources;
    }

    public Resource findById(String id) {
        for (Resource res : resources) {
            if (res.getId().equals(id)) return res;
        }
        return null;
    }
}