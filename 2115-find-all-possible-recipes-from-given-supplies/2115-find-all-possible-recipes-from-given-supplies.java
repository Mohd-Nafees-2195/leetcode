class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // Adjacency list
        Map<String, Integer> inDegree = new HashMap<>();   // In-degree map
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies)); // Quick lookup

        // Initialize graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // In-degree is the number of required ingredients

            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        // BFS (Topological Sorting)
        Queue<String> queue = new LinkedList<>();
        for (String recipe : recipes) {
            if (inDegree.get(recipe) == 0) { // If it can be made immediately
                queue.offer(recipe);
            }
        }
        queue.addAll(supplySet); // Add initial supplies to the queue

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (inDegree.containsKey(current) && inDegree.get(current) == 0) { // It's a recipe
                result.add(current);
            }
            // Process neighbors (recipes dependent on 'current' ingredient)
            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return result;
    }
}