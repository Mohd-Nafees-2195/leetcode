class NumberContainers {
    Map<Integer, Integer> map;
    Map<Integer, PriorityQueue<Integer>> pq;

    public NumberContainers() {
        map = new HashMap<>();
        pq = new HashMap<>();
    }

    public void change(int index, int number) {
        if (map.containsKey(index)) {
            int oldNo = map.get(index);
            if (pq.get(oldNo).size() == 1)
                pq.remove(oldNo);
            else
                pq.get(oldNo).remove(index);
            map.put(index, number);
            if (pq.containsKey(number)) {
                pq.get(number).add(index);
            } else {
                PriorityQueue<Integer> npq = new PriorityQueue<>();
                npq.add(index);
                pq.put(number, npq);
            }
        } else {
            map.put(index, number);
            if (pq.containsKey(number)) {
                pq.get(number).add(index);
            } else {
                PriorityQueue<Integer> npq = new PriorityQueue<>();
                npq.add(index);
                pq.put(number, npq);
            }
        }
    }

    public int find(int number) {
        if (pq.containsKey(number)) {
            return pq.get(number).peek();
        } else {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */