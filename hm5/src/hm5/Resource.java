package hm5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Resource implements Serializable {
    protected String id;
    protected String title;
    protected String location;
    protected Map<String, Object> tags = new HashMap<>();

    public Resource(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object value) {
        tags.put(key, value);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public Map<String, Object> getTags() { return tags; }

    @Override
    public String toString() {
        return "Resource{id='" + id + "', title='" + title + "'}";
    }
}