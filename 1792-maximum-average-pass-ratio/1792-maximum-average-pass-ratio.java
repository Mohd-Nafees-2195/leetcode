class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<Node> maxHeap=new PriorityQueue<>((n1,n2)->Double.compare(n2.avg,n1.avg));
        for(int i=0;i<classes.length;i++){
            double x=classes[i][0];
            double y=classes[i][1];
            double newAvg=(x+1)/(y+1)-(x/y);
            maxHeap.add(new Node(newAvg,i));
        }
        for(int i=0;i<extraStudents;i++){
            Node node=maxHeap.poll();
            double x=++classes[node.ind][0];
            double y=++classes[node.ind][1];
            double newAvg=(x+1)/(y+1)-(x/y);
            maxHeap.add(new Node(newAvg,node.ind));
        }
        double ans=0;
        for(int i=0;i<classes.length;i++){
            double x=classes[i][0];
            double y=classes[i][1];
            ans+=x/y;
        }
        return getRoundedValue(ans/classes.length);
    }
    public double getRoundedValue(double value){
        String roundedStr = String.format("%.5f", value);
        return Double.parseDouble(roundedStr);
    }
    public class Node{
        double avg;
        int ind;
        public Node(double avg,int ind){
            this.avg=avg;
            this.ind=ind;
        }
    }
}