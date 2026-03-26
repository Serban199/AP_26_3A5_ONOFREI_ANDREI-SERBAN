package Advanced;

import java.util.*;

public class Algorithm {
    public List<Resource> findCover(List<Resource> catalog, Set<String> target) {
        List<Resource> result = new ArrayList<>();
        Set<String> uncovered = new HashSet<>(target);
        List<Resource> available = new ArrayList<>(catalog);

        while (!uncovered.isEmpty() && !available.isEmpty()) {
            Resource best = null;
            int max = 0;

            for (Resource r : available) {
                Set<String> common = new HashSet<>(r.getConcepts());
                common.retainAll(uncovered);

                if (common.size() > max) {
                    max = common.size();
                    best = r;
                }
            }

            if (best == null) break;

            result.add(best);
            uncovered.removeAll(best.getConcepts());
            available.remove(best);
        }
        return result;
    }
}